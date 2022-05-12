package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.swap;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DSA  extends Application{
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("Start.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("DSA Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
    

