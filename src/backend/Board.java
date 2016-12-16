package backend;

import java.util.ArrayList;

public class Board{
	
	public ArrayList<Character> b;//guaranteed to have 9 
	
	public Board(){
		b = new ArrayList<Character>();
		for(int i = 0; i < 9; i++){
			b.add(' ');
		}
	}
	
	public void AIMove(int x){
		b.set(x, 'O');
	}
	
	public void playerMove(int x){
		b.set(x, 'X');
	}
	
	public boolean validMove(int x){
		return x >= 0 && x <= 8 && b.get(x)==' ';
	}
	
	public boolean triple(int x, int y, int z){
		return (b.get(x) == b.get(y) && b.get(x) == b.get(z) && b.get(z) != ' ');
	}
	
	public boolean emptyBoard(){
		for(char c: b){
			if(c=='X' || c == 'O') return false;
		}
		return true;
	}
	
	public boolean fullBoard(){
		for(char c: b){
			if(c==' ') return false;
		}
		return true;
	}
	
	public boolean someoneWon(){
		
		return(
				triple(0,1,2)||triple(3,4,5)||triple(6,7,8)||//rows
				triple(0,3,6)||triple(1,4,7)||triple(2,5,8)||//columns
				triple(0,4,8)||triple(2,4,6));//diagonals
	}
	
	public boolean enemyPair(int x, int y, int z){
		return (int)b.get(x) + (int)b.get(y) + (int)b.get(z) == 208;
	}
	
	public boolean alliedPair(int x, int y, int z){
		return (int)b.get(x) + (int)b.get(y) + (int)b.get(z) == 190;
	}
	
	//ASSUMES THAT EXACTLY ONE OF THESE THREE LOCATIONS HAS A SPACE CHARACTER
	public int findSpace(int x, int y, int z){
		return (int)b.get(x) == 32? x:((int)b.get(y) == 32? y:z);
	}
	
	
	public int levelZero(){
		int x = (int)(Math.random()*9);
		while(validMove(x) == false){
			x = (int)(Math.random()*9);
		}
		return x;
	}
	
	public int levelOne(){
		if(alliedPair(0, 1, 2)) return findSpace(0, 1, 2);
		if(alliedPair(3, 4, 5)) return findSpace(3, 4, 5);
		if(alliedPair(6, 7, 8)) return findSpace(6, 7, 8);
		if(alliedPair(0, 3, 6)) return findSpace(0, 3, 6);
		if(alliedPair(1, 4, 7)) return findSpace(1, 4, 7);
		if(alliedPair(2, 5, 8)) return findSpace(2, 5, 8);
		if(alliedPair(0, 4, 8)) return findSpace(0, 4, 8);
		if(alliedPair(2, 4, 6)) return findSpace(2, 4, 6);
		
		if(enemyPair(0, 1, 2)) return findSpace(0, 1, 2);
		if(enemyPair(3, 4, 5)) return findSpace(3, 4, 5);
		if(enemyPair(6, 7, 8)) return findSpace(6, 7, 8);
		if(enemyPair(0, 3, 6)) return findSpace(0, 3, 6);
		if(enemyPair(1, 4, 7)) return findSpace(1, 4, 7);
		if(enemyPair(2, 5, 8)) return findSpace(2, 5, 8);
		if(enemyPair(0, 4, 8)) return findSpace(0, 4, 8);
		if(enemyPair(2, 4, 6)) return findSpace(2, 4, 6);
		
		int x = (int)(Math.random()*9);
		while(validMove(x) == false){
			x = (int)(Math.random()*9);
		}
		return x;
	}
	
	
	
	
	
	
	
	
	
	public String toString(){
		String retval = "";
		retval += b.get(0)+"|"+b.get(1)+"|"+b.get(2)+"\n";
		retval += "_____\n";
		retval += b.get(3)+"|"+b.get(4)+"|"+b.get(5)+"\n";
		retval += "_____\n";
		retval += b.get(6)+"|"+b.get(7)+"|"+b.get(8);
		return retval;
	}
}
