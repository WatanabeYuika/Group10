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
    
    @Override
    public void start(Stage primaryStage) throws Exception {
	stage = primaryStage;
	primaryStage.setTitle("JIKANWARI");
	Pane myPane_top = (Pane)FXMLLoader.load(getClass().getResource("Jikanwari.fxml"));
    Pane myPane_other = (Pane)FXMLLoader.load(getClass().getResource("Kamoku.fxml"));
	Scene myScene = new Scene(myPane_top);
	primaryStage.setScene(myScene);
	primaryStage.show();
    }

    public static Stage getStage(){
        return stage;
    }

    public static void kamokuStart(){
        startkamoku("Kamoku.fxml");
    }

    public void startkamoku(String fxml) throws Exception{
        Pane myPane_other = (Pane)FXMLLoader.load(getClass().getResource(fxml));
        Scene otherScene = new Scene(myPane_other);
        stage.setScene(otherScene);
        stage.show();
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
}