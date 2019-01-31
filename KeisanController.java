import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class KeisanController implements Initializable {
    @FXML private Label khissyu2;
    @FXML private Label khissyu3;
    @FXML private Label ksentakuhissyu2;
    @FXML private Label ksentakuhissyu3;
    @FXML private Label ksentaku2;
    @FXML private Label ksentaku3;
    @FXML private Label shissyu2;
    @FXML private Label shissyu3;
    @FXML private Label ssentakuhissyu2;
    @FXML private Label ssentakuhissyu3;
    @FXML private Label sksentaku2;
    @FXML private Label ssentaku3;
    @FXML private Label sum1;
    @FXML private Label sum2;

    public static double s_htani = 0.0; //必修単位      //専門
    public static double s_shtani = 0.0; //選択必修単位
    public static double s_stani = 0.0; //選択単位
    public static double k_htani = 0.0; //必修単位      //共通
    public static double k_shtani = 0.0; //選択必修単位
    public static double k_stani = 0.0; //選択単位

    public static int k_hsum = 17;
    public static int k_shsum = 0;
    public static int k_ssum = 15;
    public static int s_hsum = 64;
    public static int s_shsum = 8;
    public static int s_ssum = 20;
    public static int sum = 124;

    public void backAction(ActionEvent event) {//保存もしなきゃ
        System.out.println("Back");
        JikanwariController.reStart();
    }

    public static void getTani(String a, String b, double k){
        String q = "教養";
        String w = "専門";
        String e = "必修";
        String r = "選択必修";
        String t = "選択";
    
        if(a.compareTo(q) == 0){ //教養
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
        int k_h = (int)(k_htani);
        int k_sh = (int)(k_shtani);
        int k_s = (int)(k_stani);
        int s_h = (int)(s_htani);
        int s_sh = (int)(s_shtani);
        int s_s = (int)(s_stani);

        int s = k_h + k_sh + k_s + s_h + s_sh + s_s;

        int leftk_h = k_hsum - k_h;
        int leftk_sh = k_shsum - k_sh;
        int leftk_s = k_ssum - k_s;
        int lefts_h = s_hsum - s_h;
        int lefts_sh = s_shsum - s_sh;
        int lefts_s = s_ssum - s_s;

        int lefts = sum - s;

        System.out.println("TaniKesan Start");

        khissyu2.setText(Integer.toString(k_h));
        khissyu3.setText(Integer.toString(leftk_h));
        //ksentakuhissyu2.setText(Integer.toString(k_sh));
        //ksentakuhissyu3.setText(Integer.toString(leftk_sh));
        ksentaku2.setText(Integer.toString(k_s));
        ksentaku3.setText(Integer.toString(leftk_s));
        shissyu2.setText(Integer.toString(s_h));
        shissyu3.setText(Integer.toString(lefts_h));
        ssentakuhissyu2.setText(Integer.toString(s_sh));
        ssentakuhissyu3.setText(Integer.toString(lefts_sh));
        sksentaku2.setText(Integer.toString(s_s));
        ssentaku3.setText(Integer.toString(lefts_s));
        sum1.setText(Integer.toString(s));
        sum2.setText(Integer.toString(lefts));
    }

    public static void initialize() {
        Jikanwari.keisanStart();
    }
}