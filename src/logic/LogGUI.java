package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;



public class LogGUI extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try	{
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			primaryStage.setTitle("GoodHabits - login");
		    Scene scene = new Scene(root);
		    scene.getStylesheets().add(getClass().getResource("goodHabits.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}