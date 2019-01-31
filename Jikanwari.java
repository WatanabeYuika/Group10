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
    private static Scene myScene;
    private static Scene otherScene;
    private static Scene keisanScene;
    public static int koma = 6;//add
    public static int youbi = 5;//add
    public static String spring1stFile = "Spring1st.csv";
    public static String fall1stFile = "Fall1st.csv";
    public static String spring2ndFile = "Spring2nd.csv";
    public static String fall2ndFile = "Fall2nd.csv";
    public static String spring3rdFile = "Spring3rd.csv";
    public static String fall3rdFile = "Fall3rd.csv";
    public static String spring4thFile = "Spring4th.csv";
    public static String fall4thFile = "Fall4th.csv";
    public static int ckoma,cyoubi;//add
    public static SandL sal1Spring,sal1Fall,sal2Spring,sal2Fall,sal3Spring,sal3Fall,sal4Spring,sal4Fall;//add
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        sal1Spring = new SandL(koma,youbi,spring1stFile);//add
        sal1Fall = new SandL(koma,youbi,fall1stFile);
        sal2Spring = new SandL(koma,youbi,spring2ndFile);
        sal2Fall = new SandL(koma,youbi,fall2ndFile);
        sal3Spring = new SandL(koma,youbi,spring3rdFile);
        sal3Fall = new SandL(koma,youbi,fall3rdFile);
        sal4Spring = new SandL(koma,youbi,spring4thFile);
        sal4Fall = new SandL(koma,youbi,fall4thFile);
        sal1Spring.loadFile();//add
        stage = primaryStage;
        primaryStage.setTitle("JIKANWARI");
        Pane myPane_top = (Pane)FXMLLoader.load(getClass().getResource("Jikanwari.fxml"));   
        myScene = new Scene(myPane_top);	
        Pane myPane_other = (Pane)FXMLLoader.load(getClass().getResource("Kamoku.fxml"));
        otherScene = new Scene(myPane_other); 
        Pane myPane_keisan = (Pane)FXMLLoader.load(getClass().getResource("keisan.fxml"));
        keisanScene = new Scene(myPane_keisan);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static Stage getStage(){
        return stage;
    }

    public static Scene getMyScene(){
        return myScene;
    }

    public static Scene getOtherScene(){
        return otherScene;
    }

    public static Scene getKeisanScene(){
        return keisanScene;
    }

    public static void jikanwariStart(){
        getStage().setScene(getMyScene());
        getStage().show();
    }

    public static void kamokuStart(){
        getStage().setScene(getOtherScene());
        getStage().show();
    }

    public static void keisanStart(){
        getStage().setScene(getKeisanScene());
        getStage().show();
    }

    public static void load(String semester){//あと条件文とそのファイルを作る
        if(semester.equals("１年前期")){
            sal1Spring.loadFile();
        }else if(semester.equals("１年後期")){
            sal1Fall.loadFile();
        }else if(semester.equals("２年前期")){
            sal2Spring.loadFile();  
        }else if(semester.equals("２年後期")){
            sal2Fall.loadFile();
        }else if(semester.equals("３年前期")){
            sal3Spring.loadFile();  
        }else if(semester.equals("３年後期")){
            sal3Fall.loadFile();
        }else if(semester.equals("４年前期")){
            sal4Spring.loadFile();  
        }else if(semester.equals("４年後期")){
            sal4Fall.loadFile();
        }
    }

    public static void save(String str,String semester){
        if(semester.equals("１年前期")){
            sal1Spring.data[ckoma][cyoubi]=str;
            sal1Spring.saveFile();
        }else if(semester.equals("１年後期")){
            sal1Fall.data[ckoma][cyoubi]=str;
            sal1Fall.saveFile();  
        }else if(semester.equals("２年前期")){
            sal2Spring.data[ckoma][cyoubi]=str;
            sal2Spring.saveFile();
        }else if(semester.equals("２年後期")){
            sal2Fall.data[ckoma][cyoubi]=str;
            sal2Fall.saveFile();
        }else if(semester.equals("３年前期")){
            sal3Spring.data[ckoma][cyoubi]=str;
            sal3Spring.saveFile();
        }else if(semester.equals("３年後期")){
            sal3Fall.data[ckoma][cyoubi]=str;
            sal3Fall.saveFile();
        }else if(semester.equals("４年前期")){
            sal4Spring.data[ckoma][cyoubi]=str;
            sal4Spring.saveFile();
        }else if(semester.equals("４年後期")){
            sal4Fall.data[ckoma][cyoubi]=str;
            sal4Fall.saveFile();
        }
    }

    public static void saving(int j, String str, String semester){//似たようにする
        if(semester.equals("１年前期")){
            sal1Spring.data[6][j]=str;
            sal1Spring.save2File();
        }else if(semester.equals("１年後期")){
            sal1Fall.data[6][j]=str;
            sal1Fall.save2File();
        }else if(semester.equals("２年前期")){
            sal2Spring.data[6][j]=str;
            sal2Spring.save2File();  
        }else if(semester.equals("２年後期")){
            sal2Fall.data[6][j]=str;
            sal2Fall.save2File();
        }else if(semester.equals("３年前期")){
            sal3Spring.data[6][j]=str;
            sal3Spring.save2File();  
        }else if(semester.equals("３年後期")){
            sal3Fall.data[6][j]=str;
            sal3Fall.save2File();
        }else if(semester.equals("４年前期")){
            sal4Spring.data[6][j]=str;
            sal4Spring.save2File();  
        }else if(semester.equals("４年後期")){
            sal4Fall.data[6][j]=str;
            sal4Fall.save2File();
        }
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
