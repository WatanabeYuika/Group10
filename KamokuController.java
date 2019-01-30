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
    private static String tani; //各授業の取得可能単位数
    

    Jugyou(String str){
        String[] re = str.split(",", 0);
        this.kamoku   = re[0];
        this.tani     = re[1];
    }

    public static String getTani(){
        return tani;
    }
    
    public String toString(){
        return kamoku;
    }
}

class ReturnTani{
    
}

public class KamokuController implements Initializable {
    int x = 0;
    private TextArea classroomTextArea;
    private TextArea teacherTextArea;
    private TextArea memoTextArea;
    private CheckBox taniCheck;
    public String kamokugun,kamoku,tani;// 単位の保存も

    @FXML private Label absenceLabel;
    @FXML private ComboBox<String> subjectGroupChoice;
    @FXML private ComboBox<String> subjectChoice;

    /*static Jugyou[] kijiku = new Jugyou[31];
    static Jugyou[] gendai = new Jugyou[23];
    static Jugyou[] ryugaku = new Jugyou[7];
    static Jugyou[] rikei = new Jugyou[58];
    static Jugyou[] kyosyoku = new Jugyou[23];
    static Jugyou[] kyoutu = new Jugyou[22];*/

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
	    kamokugun = (String)c.getValue();

        if(c.getValue().equals("基軸教育科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);//メソッドにしました
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("現代教養科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("留学生科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("教職等資格科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("理系科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }else if(c.getValue().equals("学部共通科目")){
            subjectChoice.getItems().clear();
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
            subjectChoice.getSelectionModel().select(-1);
        }
    }

    public void subjectChoiced(ActionEvent event) {//科目を選択したら
        ComboBox c = (ComboBox)event.getSource();
        kamoku = (String)c.getValue();//add
        System.out.println( "選択:"+kamoku);
    }

    public void backAction(ActionEvent event) {//←のボタンを押すと
       System.out.println("戻る");
       JikanwariController.reStart();
    }

    public void saveAction(ActionEvent event) {//OKボタンを押すと
        kamokugun = (String)subjectGroupChoice.getValue();
        kamoku = (String)subjectChoice.getValue();//add
        String str;

        if(kamokugun.equals("基軸教育科目")){
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                /*while(sc.hasNextLine()){
                    str = sc.nextLine();               
                    String[] re = str.split(",", 0);
                    Jugyou jugyou = new Jugyou(str);
                    String kamoku2 = jugyou.toString();
                    if(kamoku.equals(kamoku2)){
                        String tani = jugyou.getTani();
                        System.out.println("保存:"+kamokugun+","+kamoku+","+tani);
                        Jikanwari.save(kamokugun+","+kamoku+","+tani);//add
                    }
                }*/
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("現代教養科目")){
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("留学生科目")){
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("教職等資格科目")){
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("理系科目")){
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("学部共通科目")){
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }
        
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

    public void fileYomikomi(Scanner sc){//ファイルを読み込みコンボボックスに表示
        String str;

        while(sc.hasNextLine()){
            str = sc.nextLine();               
            String[] re = str.split(",", 0);
            Jugyou kamoku = new Jugyou(str);
            String kamoku2 = "" + kamoku;
            subjectChoice.getItems().add(kamoku2);
            
        }
    }
    public void saveKamokuToTani(Scanner sc,String kamokugun,String kamoku){
        String str;
        while(sc.hasNextLine()){
            str = sc.nextLine();               
            String[] re = str.split(",", 0);
            Jugyou jugyou = new Jugyou(str);
            String kamoku2 = jugyou.toString();
            if(kamoku.equals(kamoku2)){
                String tani = jugyou.getTani();
                System.out.println("保存:"+kamokugun+","+kamoku+","+tani);
                Jikanwari.save(kamokugun+","+kamoku+","+tani);//add
            }
        }
    }
}