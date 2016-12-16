package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import backend.Board;

public class AIController {

	@FXML ImageView zero;
	@FXML ImageView one;
	@FXML ImageView two;
	@FXML ImageView three;
	@FXML ImageView four;
	@FXML ImageView five;
	@FXML ImageView six;
	@FXML ImageView seven;
	@FXML ImageView eight;
	
	@FXML Text t;
	@FXML Button replay;
	
	Board b = new Board();
	
	boolean playerTurn = true;
	
	String xImg = "GUI/X.png";
	String oImg = "GUI/O.png";
	String spaceImg = "GUI/space.png";
	
	Stage parent;
	Stage thisOne;
	
	public void start(Stage stage, Stage parent){
		//t.setText("Player one, your turn.");
		replay.setDisable(true);
		thisOne = stage;
		this.parent = parent;		
	}
	
	public void disableAll(){
		zero.setDisable(true);
		one.setDisable(true);
		two.setDisable(true);
		three.setDisable(true);
		four.setDisable(true);
		five.setDisable(true);
		six.setDisable(true);
		seven.setDisable(true);
		eight.setDisable(true);
	}
	
	public void activate(ImageView num, int x){
		
		num.setImage(new Image(xImg));
		b.playerMove(x);
		num.setDisable(true);
		
		if(b.someoneWon()){
			t.setText("HUMANS RULE ROBOTS DROOL"); 
			disableAll(); 
			replay.setDisable(false);
			return;
		}
		if(b.fullBoard()){
			t.setText("It's a tie."); 
			disableAll();
			replay.setDisable(false);
			return;
		}
		
		x = b.levelOne();
		switch(x){
			case 0:num =zero;break;
			case 1:num = one;break;
			case 2:num = two;break;
			case 3:num=three;break;
			case 4:num =four;break;
			case 5:num =five;break;
			case 6:num = six;break;
			case 7:num=seven;break;
			case 8:num=eight;break;
		}
		
		num.setImage(new Image(oImg));
		b.AIMove(x);
		num.setDisable(true);
	
		if(b.someoneWon()){
			t.setText("SINGULARITY ACHIEVED. PREPARE FOR JUDGEMENT DAY."); 
			disableAll(); 
			replay.setDisable(false);
			return;
		}
		if(b.fullBoard()){
			t.setText("It's a tie."); 
			disableAll();
			replay.setDisable(false);
		}
	}
	
	
	public void clickZero(){
		activate(zero, 0);
	}
	
	public void clickOne(){
		activate(one, 1);
	}
	public void clickTwo(){
		activate(two, 2);
	}
	public void clickThree(){
		activate(three, 3);
	}
	public void clickFour(){
		activate(four, 4);
	}
	public void clickFive(){
		activate(five, 5);
	}
	public void clickSix(){
		activate(six, 6);
	}
	public void clickSeven(){
		activate(seven, 7);
	}
	public void clickEight(){
		activate(eight, 8);
	}
	
	public void replay(){
		thisOne.hide();
		parent.show();
	}

}
