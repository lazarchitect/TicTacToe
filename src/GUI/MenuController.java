package GUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuController {

	@FXML Button PvP;
	@FXML Button AI;
	
	Stage parent;
	
	public void PvP() throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("PvPBoard.fxml"));
		GridPane screen = (GridPane)loader.load();
		Scene scene = new Scene(screen);
		Stage stage  = new Stage();
		stage.setScene(scene);
		stage.setTitle("Tic Tac Toe");
		PvPController pc = loader.getController();
		pc.start(stage, parent);		
		stage.show();
		parent.hide();
	}
	
	
	public void AI() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("AIBoard.fxml"));
		GridPane screen = (GridPane)loader.load();
		Scene scene = new Scene(screen);
		Stage stage  = new Stage();
		stage.setScene(scene);
		stage.setTitle("Tic Tac Toe");
		AIController aic = loader.getController();
		aic.start(stage, parent);
		stage.show();
		parent.hide();
	}
	
}
