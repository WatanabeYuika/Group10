import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class KamokuController implements Initializable {
    int x = 0;
    @FXML private TextField classroomTextFeild;
    @FXML private TextField teacherTextFeild;
    @FXML private TextArea memoTextArea;
    private CheckBox taniCheck;
    public String kamokugun = null;
    public String kamoku = null;
    public String tani = null;// 単位の保存も

    @FXML private Label absenceLabel;
    @FXML private ComboBox<String> subjectGroupChoice;
    @FXML private ComboBox<String> subjectChoice;

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

    public Label getAbsenceLabel(){
        return absenceLabel;
    }

    public void setAbsenceLabel(Label absenceLabel){
        this.absenceLabel = absenceLabel;
    }

    public TextField getTeacherFeild(){
        return classroomTextFeild;
    }
    
    public void setTeacherFeild(TextField teacherTextFeild){
        this.teacherTextFeild = teacherTextFeild;
    }

    public TextField getClassroomTextFeild(){
        return classroomTextFeild;
    }

    public void setClassroomFeild(TextField classroomTextFeild){
        this.classroomTextFeild = classroomTextFeild;
    }

    public TextArea getMemoTextArea(){
        return memoTextArea;
    }

    public void setMemoArea(TextArea memoTextArea){
        this.memoTextArea = memoTextArea;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectGroupChoice.getItems().add("");
        subjectGroupChoice.getItems().add("基軸教育科目");
        subjectGroupChoice.getItems().add("現代教養科目");
        subjectGroupChoice.getItems().add("留学生科目");
        subjectGroupChoice.getItems().add("教職等資格科目");
        subjectGroupChoice.getItems().add("理系科目");
        subjectGroupChoice.getItems().add("学部共通科目");

        subjectGroupChoice.getSelectionModel().select(0);
    }

    public void subjectGroupChoiced(ActionEvent event) {//科目群の選択をしたら
        ComboBox c = (ComboBox)event.getSource();
        System.out.println( "Select:"+(String)c.getValue() ) ;
	    kamokugun = (String)c.getValue();
        
        subjectChoice.getItems().clear();
        if(c.getValue().equals("基軸教育科目")){
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);//メソッドにしました
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("現代教養科目")){
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("留学生科目")){
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("教職等資格科目")){
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("理系科目")){
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(c.getValue().equals("学部共通科目")){
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                fileYomikomi(sc);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }  
        }
        subjectChoice.getSelectionModel().select(0);
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
        String teacher = (String)teacherTextFeild.getText();
        String classroom = (String)classroomTextFeild.getText();
        String memo = (String)memoTextArea.getText();
        String str;

        if(kamokugun.equals("基軸教育科目")){
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("現代教養科目")){
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("留学生科目")){
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("教職等資格科目")){
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("理系科目")){
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("学部共通科目")){
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(kamokugun.equals("")){

            System.out.println(JikanwariController.getTermComboBox().getValue() +"Save:"
                                +kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
            Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo, 
                           JikanwariController.getTermComboBox().getValue());
        }
        
        JikanwariController.initialize();//更新するように変更
        Jikanwari.jikanwariStart();//add
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと//作成
        subjectGroupChoice.getSelectionModel().select(0);
        subjectChoice.getItems().clear();
        teacherTextFeild.clear();
        classroomTextFeild.clear();
        memoTextArea.clear();

        String teacher = (String)teacherTextFeild.getText();
        String classroom = (String)classroomTextFeild.getText();
        String memo = (String)memoTextArea.getText();

        System.out.println(JikanwariController.getTermComboBox().getValue() +"Save:"
                                +kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
        Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo, 
                           JikanwariController.getTermComboBox().getValue());
    }

    public void upAbsenceAction(ActionEvent event) {//欠席カウントup
        x = x + 1;
        absenceLabel.setText( + x + "回");
        System.out.println("欠席回数："+ x);
    }

    public void downAbsenceAction(ActionEvent event) {//欠席カウントdown
        x = x - 1;
        if(x >= 0){
            absenceLabel.setText( + x + "回");
            System.out.println("欠席回数：" + x);
        }else{
            absenceLabel.setText("0回");
            System.out.println("欠席回数：0");
        }   
    }

    public void getTani(ActionEvent event) {//単位取得のチェックしたら

    }
    
    public static void initialize() {
        System.out.println("KamokuStart");
        Jikanwari.kamokuStart();
    }

    public void fileYomikomi(Scanner sc){//ファイルを読み込みコンボボックスに表示
        String str;
        subjectChoice.getItems().add("");

        while(sc.hasNextLine()){
            str = sc.nextLine();               
            String[] re = str.split(",", 0);
            Jugyou kamoku = new Jugyou(str);
            String kamoku2 = "" + kamoku;
            subjectChoice.getItems().add(kamoku2);
            
        }
    }
    public void saveKamokuToTani(Scanner sc,String kamokugun,String kamoku,int x,
                                 String teacher,String classroom,String memo){//保存する場所
        String str;
        while(sc.hasNextLine()){
            str = sc.nextLine();               
            String[] re = str.split(",", 0);
            Jugyou jugyou = new Jugyou(str);
            String kamoku2 = jugyou.toString();
            if(kamoku.equals(kamoku2)){
                String tani = jugyou.getTani();
                System.out.println(JikanwariController.getTermComboBox().getValue() +"保存:"+
                                    kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
                Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo, 
                               JikanwariController.getTermComboBox().getValue());
            }
        }
    }
}