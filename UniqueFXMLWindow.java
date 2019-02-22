package sandbox;

import java.io.*;
import java.net.*;
import java.util.logging.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class UniqueFXMLWindow {

	private static UniqueFXMLWindow instance;
	private Stage stage;
	private Scene scene;
	private Parent root;
	private FXMLLoader loader;

	private UniqueFXMLWindow(URL fxml) {
		loader = new FXMLLoader(fxml);

		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
	}

	public static void init(URL fxml) {
		instance = new UniqueFXMLWindow(fxml);
	}

	public static UniqueFXMLWindow get() {
		if (instance == null) {
			try {
				throw new InstantiationException("instance was not initialized yet.");
			} catch (InstantiationException ex) {
				Logger.getLogger(UniqueFXMLWindow.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return instance;
	}

	public void kill() {
		stage.close();
	}

	public void show() {
		stage.show();
	}

}
