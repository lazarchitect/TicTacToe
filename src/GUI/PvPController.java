package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import backend.Board;

public class PvPController {

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
	
	
	
	int i = -1;
	String xImg = "GUI/X.png";
	String oImg = "GUI/O.png";
	String spaceImg = "GUI/space.png";
	
	Stage parent;
	Stage thisOne;
	
	public void start(Stage stage, Stage parent){
		t.setText("Player one, your turn.");
		replay.setDisable(true);
		thisOne = stage;
		this.parent = parent;
	}
	
//	public void click(Node node){
//		if(node.getClass().getName().equals("ImageView")==false) return;
//		ImageView n = (ImageView)zero.getScene().lookup("#"+node);
//		i++;
//		if(i%2==0) n.setImage(new Image(xImg));
//		else n.setImage(new Image(oImg));
//		n.setDisable(true);
//		System.out.println("oh fuck.");
//	}
	
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
		i++;
		if(i%2==0){
			num.setImage(new Image(xImg));
			b.playerMove(x);
			t.setText("Player two, your turn.");
		}
		else{
			num.setImage(new Image(oImg));
			b.AIMove(x);
			t.setText("Player one, your turn.");
		}
		num.setDisable(true);
		if(b.someoneWon()){
			t.setText(i%2==0? "Damn Player 2 gg ez lol":"...Wow, Player 1. Jesus. git gud."); 
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
