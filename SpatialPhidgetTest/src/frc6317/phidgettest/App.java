package frc6317.phidgettest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		Main main = loader.getController();
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Spatial Phidget Test");
		primaryStage.setOnHidden(e -> main.shutdown());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
