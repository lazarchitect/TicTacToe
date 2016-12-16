package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppStartup extends Application{

	@Override
	public void start(Stage stage)throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("menu.fxml"));
		AnchorPane screen = (AnchorPane)loader.load();
		Scene scene = new Scene(screen);
		stage.setScene(scene);
		stage.setTitle("Tic Tac Toe Menu");
		
		MenuController mc = loader.getController();
		mc.parent = stage;
		stage.show();
		
	}
	
	public static void main(String [] args){
		launch(args);
	}
}