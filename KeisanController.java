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

    public static Label now[];
    public static Label left[];

    public static double s_htani = 0.0; //必修単位      //専門
    public static double s_shtani = 0.0; //選択必修単位
    public static double s_stani = 0.0; //選択単位
    public static double k_htani = 0.0; //必修単位      //教養
    public static double k_shtani = 0.0; //選択必修単位
    public static double k_stani = 0.0; //選択単位

    public static final int k_hsum = 17;//情報科学科
    public static final int k_shsum = 0;
    public static final int k_ssum = 15;
    public static final int s_hsum = 64;
    public static final int s_shsum = 8;
    public static final int s_ssum = 20;
    public static final int sum = 124;

    public Label getKhissyu2(){
        return khissyu2;
    }

    public Label getKhissyu3(){
        return khissyu3;
    }

    public Label getKsentakuhissyu2(){
        return ksentakuhissyu2;
    }

    public Label getKsentakuhissyu3(){
        return ksentakuhissyu3;
    }

    public Label getKsentaku2(){
        return ksentaku2;
    }

    public Label getKsentaku3(){
        return ksentaku3;
    }

    public Label getShissyu2(){
        return shissyu2;
    }

    public Label getShissyu3(){
        return shissyu2;
    }

    public Label getSsentakuhissyu2(){
        return ssentakuhissyu2;
    }

    public Label getSsentakuhissyu3(){
        return ssentakuhissyu2;
    }

    public Label getSksentaku2(){
        return sksentaku2;
    }

    public Label getSsentaku3(){
        return ssentaku3;
    }

    public Label getSum1(){
        return sum1;
    }

    public Label getSum2(){
        return sum2;
    }

    public void setKhissyu2(Label lavel){
        khissyu2 = lavel;
    }

    public void setKhissyu3(Label lavel){
        khissyu3 = lavel;
    }

    public void setKsentakuhissyu2(Label lavel){
        ksentakuhissyu2 = lavel;
    }

    public void setKsentakuhissyu3(Label lavel){
        ksentakuhissyu3 = lavel;
    }

    public void setKsentaku2(Label lavel){
        ksentaku2 = lavel;
    }

    public void setKsentaku3(Label lavel){
        ksentaku3 = lavel;
    }

    public void setShissyu2(Label lavel){
        shissyu2 = lavel;
    }

    public void setShissyu3(Label lavel){
        shissyu2 = lavel;
    }

    public void setSsentakuhissyu2(Label lavel){
        ssentakuhissyu2 = lavel;
    }

    public void setSsentakuhissyu3(Label lavel){
        ssentakuhissyu2 = lavel;
    }

    public void setSksentaku2(Label lavel){
        sksentaku2 = lavel;
    }

    public void setSsentaku3(Label lavel){
        ssentaku3 = lavel;
    }

    public void setSum1(Label lavel){
        sum1 = lavel;
    }

    public void setSum2(Label lavel){
        sum2 = lavel;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        now = new Label[] {khissyu2,ksentakuhissyu2,ksentaku2,shissyu2,ssentakuhissyu2,sksentaku2,sum1};
        left = new Label[] {khissyu3,ksentakuhissyu3,ksentaku3,shissyu3,ssentakuhissyu3,ssentaku3,sum2};
    }

    public static void initialize() {
        Jikanwari.keisanStart();
        System.out.println("TaniKesan Start");
    }


    public void backAction(ActionEvent event) {
        System.out.println("Back");
        JikanwariController.reStart();
    }

    public static void getTani(String kyouoOrSenmon, String hissyuOrSentaku, double tani, int i, int j){
        String hissyu = "必修";
        String sentakuhissyu = "選択必修";
        String sentaku = "選択";

        if(i == 0 && j == 0){//単位修得状況のボタンが選択されるたびに初期化されるように修正
            s_htani = 0.0;
            s_shtani = 0.0;
            s_stani = 0.0;
            k_htani = 0.0;
            k_shtani = 0.0;
            k_stani = 0.0;
        }
    
        if(kyouoOrSenmon.equals("教養")){ //教養

            if(hissyuOrSentaku.equals(hissyu)){ //必修
                k_htani += tani; 
            }else if(hissyuOrSentaku.equals(sentakuhissyu)){ //選択必修
                k_shtani += tani;
            }else if(hissyuOrSentaku.equals(sentaku)){ //選択
                k_stani += tani;
            }

        }else if(kyouoOrSenmon.equals("専門")){ //専門

            if(hissyuOrSentaku.equals(hissyu)){ //必修
                s_htani += tani;
            }else if(hissyuOrSentaku.equals(sentakuhissyu) ){ //選択必修
                s_shtani += tani;
            }else if(hissyuOrSentaku.equals(sentaku)){ //選択
                s_stani += tani;
            }
        }

        if(i == 7 && j == 24){//一番最後にint型に変える
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

            now[0].setText(Integer.toString(k_h));
            left[0].setText(Integer.toString(leftk_h));
            //ksentakuhissyu2.setText(Integer.toString(k_sh));
            //ksentakuhissyu3.setText(Integer.toString(leftk_sh));
            now[2].setText(Integer.toString(k_s));
            left[2].setText(Integer.toString(leftk_s));
            now[3].setText(Integer.toString(s_h));
            left[3].setText(Integer.toString(lefts_h));
            now[4].setText(Integer.toString(s_sh));
            left[4].setText(Integer.toString(lefts_sh));
            now[5].setText(Integer.toString(s_s));
            left[5].setText(Integer.toString(lefts_s));
            now[6].setText(Integer.toString(s));
            left[6].setText(Integer.toString(lefts));
        }   
    }

}
