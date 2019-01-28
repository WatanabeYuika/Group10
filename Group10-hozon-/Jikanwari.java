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
    private static Scene myScene;
    public static int ckoma,cyoubi;
    public static SandL sal;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        sal=new SandL(5,5,"test2.csv");
	sal.loadFile();
	stage = primaryStage;
	primaryStage.setTitle("JIKANWARI");
	Pane myPane_top = (Pane)FXMLLoader.load(getClass().getResource("Jikanwari.fxml"));   
        myScene = new Scene(myPane_top);	
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

    public static Scene getmyScene(){
	return myScene;
    }

    public static void kamokuStart(){
        getStage().setScene(getOtherScene());
        getStage().show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    public static void save(String str){
	sal.data[ckoma][cyoubi]=str;
    }

    public static void saving(){
	sal.saveFile();
    }

    public static void jikanwariStart(){
	getStage().setScene(getmyScene());
	getStage().show();
    }
}
