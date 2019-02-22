package sandbox;

import java.io.*;
import java.net.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class GenericFXMLWindow {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

	public GenericFXMLWindow(URL fxml) {
		loader = new FXMLLoader(fxml);
		
		try {root = loader.load();} 
		catch (IOException e) {e.printStackTrace();}
		
		scene = new Scene(root);
		stage= new Stage();
		stage.setScene(scene);
	}
	
	public void kill(){
		stage.close();
	}
	
	public void show(){
		stage.show();
	}

}
