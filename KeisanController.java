import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KeisanController implements Initializable {
    @FXML private Label khissyu1;
    @FXML private Label khissyu2;
    @FXML private Label khissyu3;
    @FXML private Label ksentakuhissyu1;
    @FXML private Label ksentakuhissyu2;
    @FXML private Label ksentakuhissyu3;
    @FXML private Label ksentaku1;
    @FXML private Label ksentaku2;
    @FXML private Label ksentaku3;
    @FXML private Label shissyu1;
    @FXML private Label shissyu2;
    @FXML private Label shissyu3;
    @FXML private Label ssentakuhissyu1;
    @FXML private Label ssentakuhissyu2;
    @FXML private Label ssentakuhissyu3;
    @FXML private Label ssentaku1;
    @FXML private Label sksentaku2;
    @FXML private Label ssentaku3;

    public static int s_htani = 0; //必修単位      //専門
    public static int s_shtani = 0; //選択必修単位
    public static int s_stani = 0; //選択単位
    public static int k_htani = 0; //必修単位      //共通
    public static int k_shtani = 0; //選択必修単位
    public static int k_stani = 0; //選択単位

    public void backAction(ActionEvent event) {//保存もしなきゃ
        System.out.println("Back");
        JikanwariController.reStart();
    }

    public static void getTani(String a, String b, int k){
        String q = "共通";
        String w = "専門";
        String e = "必修";
        String r = "選択必修";
        String t = "選択";
    
        if(a.compareTo(q) == 0){ //共通
            if(b.compareTo(e) == 0){ //必修
                k_htani += k; 
            }else if(b.compareTo(r) == 0){ //選択必修
                k_shtani += k;
            }else if(b.compareTo(t) == 0){ //選択
                k_stani += k;
            }
        }else if(a.compareTo(w) == 0){ //専門
            if(b.compareTo(e) == 0){ //必修
                s_htani += k;
            }else if(b.compareTo(r) == 0){ //選択必修
                s_shtani += k;
            }else if(b.compareTo(t) == 0){ //選択
                s_stani += k;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TaniKesan Start");
        khissyu2.setText(Integer.toString(k_htani));
        ksentakuhissyu2.setText(Integer.toString(k_shtani));
        ksentaku2.setText(Integer.toString(k_stani));
        shissyu2.setText(Integer.toString(s_htani));
        ssentakuhissyu2.setText(Integer.toString(s_shtani));
        sksentaku2.setText(Integer.toString(s_stani));
    }

    public static void initialize() {
        Jikanwari.keisanStart();
    }
}