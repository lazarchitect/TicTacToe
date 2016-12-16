package driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import backend.Board;

public class Driver {
	
	static Board ttt = new Board();
	static Scanner sc = new Scanner(System.in);
	
	public static void fred (String [] args){		
		
		int turnflag = -1;
		while(ttt.someoneWon() == false){//core game loop
			
			System.out.println(ttt);
			turnflag++;
			
			if(ttt.fullBoard()){
				System.out.println("It's a tie.");
				System.exit(0);
			}
			
			
			if(turnflag%2==0){
			
				System.out.println("Player 1, take your turn.");
				int x;
				while(true){
					try{
						System.out.println("where do you want to go? 0 thru 8");
						x = sc.nextInt();
						if(ttt.validMove(x)==false) throw new InputMismatchException();
						break;
					}
					catch(InputMismatchException e){
						System.out.println("Bad input Chief, gotta be a number between 1 and 9 and there cant be a piece there already.");
						continue;
					}
				}
				ttt.playerMove(x);
			}
			
			else{//AI turn
				System.out.println("AI is thinking...");
				int x;
				
				x = ttt.levelOne();//with more levels, the functions can be in an array(user chooses difficulty level aka index)
				
				ttt.AIMove(x);	
			}
		}	
		System.out.println(ttt);
		System.out.println(turnflag%2==0? "You win!":"AI Wins.");
	}
}

