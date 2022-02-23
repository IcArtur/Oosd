package application.java;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/application/resources/view/LoginFrame.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void changeScene(String fxml, String title) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource(fxml));
    	stg.setTitle(title);
    	stg.setScene(new Scene(root));
    	stg.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}