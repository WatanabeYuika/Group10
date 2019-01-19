import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Jikanwari extends Application {
    private static Stage stage;
    private static Scene otherScene;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
	stage = primaryStage;
	primaryStage.setTitle("JIKANWARI");
	Pane myPane_top = (Pane)FXMLLoader.load(getClass().getResource("Jikanwari.fxml"));   
	Scene myScene = new Scene(myPane_top);	
    Pane myPane_other = (Pane)FXMLLoader.load(getClass().getResource("Kamoku.fxml"));
    otherScene = new Scene(myPane_other); 

    primaryStage.setScene(myScene);
	primaryStage.show();
    }

    public static Stage getStage(){
        return stage;
    }

    public static Scene getOtherScene(){
        return otherScene;
    }

    public static void kamokuStart(){
        getStage().setScene(getOtherScene());
        getStage().show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}