import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

class Jugyou {
    private String kamoku; //授業名
    private String tani; //各授業の取得可能単位数

    Jugyou(String str){
        String[] re = str.split(",", 0);
        this.kamoku   = re[0];
        this.tani     = re[1];
    }
    
    public String toString(){
        return kamoku;
    }
}

public class KamokuController implements Initializable {
    int x = 0;
    private TextArea classroomTextArea;
    private TextArea teacherTextArea;
    private TextArea memoTextArea;
    private CheckBox taniCheck;
    public String kamokugun,kamoku;

    @FXML private Label absenceLabel;
    @FXML private ComboBox<String> subjectGroupChoice;
    @FXML private ComboBox<String> subjectChoice;

    static Jugyou[] kijiku = new Jugyou[31];
    static Jugyou[] gendai = new Jugyou[23];
    static Jugyou[] ryugaku = new Jugyou[7];
    static Jugyou[] rikei = new Jugyou[58];
    static Jugyou[] kyosyoku = new Jugyou[23];
    static Jugyou[] kyoutu = new Jugyou[22];

    public ComboBox<String> getSubjectGroupChoice() {
        return subjectGroupChoice;
    }
 
    public void setSubjectGroupChoice(ComboBox<String> subjectGroupChoice) {
        this.subjectGroupChoice = subjectGroupChoice;
    }

    public ComboBox<String> getSubjectChoice() {
        return subjectChoice;
    }

    public void setSubjectChoice(ComboBox<String> subjectChoice) {
        this.subjectChoice = subjectChoice;
    }

    public Label getabsenceLabel(){
        return absenceLabel;
    }

    public void setabsenceLabel(Label absenceLabel){
        this.absenceLabel = absenceLabel;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectGroupChoice.getItems().add("基軸教育科目");
        subjectGroupChoice.getItems().add("現代教養科目");
        subjectGroupChoice.getItems().add("留学生科目");
        subjectGroupChoice.getItems().add("教職等資格科目");
        subjectGroupChoice.getItems().add("理系科目");
        subjectGroupChoice.getItems().add("学部共通科目");

        subjectGroupChoice.getSelectionModel().select(-1);
    }

    public void subjectGroupChoiced(ActionEvent event) {//科目群の選択をしたら
        ComboBox c = (ComboBox)event.getSource();
        System.out.println( "選択:"+(String)c.getValue() ) ;
	    kamokugun=(String)c.getValue();
        String str;

        if(c.getValue().equals("基軸教育科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou kijiku = new Jugyou(str);
                    String kijiku2 = "" + kijiku;
                    subjectChoice.getItems().add(kijiku2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("現代教養科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou gendai = new Jugyou(str);
                    String gendai2 = "" + gendai;
                    subjectChoice.getItems().add(gendai2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("留学生科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou ryugaku = new Jugyou(str);
                    String ryugaku2 = "" + ryugaku;
                    subjectChoice.getItems().add(ryugaku2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("教職等資格科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou kyosyoku = new Jugyou(str);
                    String kyosyoku2 = "" + kyosyoku;
                    subjectChoice.getItems().add(kyosyoku2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("理系科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou rikei = new Jugyou(str);
                    String rikei2 = "" + rikei;
                    subjectChoice.getItems().add(rikei2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("学部共通科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                
                while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou kyoutu = new Jugyou(str);
                    String kyoutu2 = "" + kyoutu;
                    subjectChoice.getItems().add(kyoutu2);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }
    }

    public void subjectChoiced(ActionEvent event) {//科目を選択したら
        ComboBox c = (ComboBox)event.getSource();
        kamoku=(String)c.getValue();//add
        System.out.println( "選択:"+(String)c.getValue() );
    }

    public void backAction(ActionEvent event) {//←のボタンを押すと
        JikanwariController.reStart();
    }

    public void selectAction(ActionEvent event) {//メニューのセレクト
        System.out.println("select");
    }

    public void saveAction(ActionEvent event) {//OKボタンを押すと
       	Jikanwari.save(kamokugun+","+kamoku);//add
        Jikanwari.jikanwariStart();//add
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと
        initialize();
    }

    public void upAbsenceAction(ActionEvent event) {//欠席カウントup
        x = x + 1;
        absenceLabel.setText( + x + "回");
        System.out.println("欠席回数："+ x);
    }

    public void downAbsenceAction(ActionEvent event) {//欠席カウントdown
        x = x - 1;
        absenceLabel.setText( + x + "回");
        System.out.println("欠席回数：" + x);
    }

    public void getTani(ActionEvent event) {//単位取得のチェックしたら

    }
    
    public static void initialize() {
        System.out.println("科目入力画面になります");
        Jikanwari.kamokuStart();
    }
}
