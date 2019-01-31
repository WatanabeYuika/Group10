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
    private static String sh;
    

    Jugyou(String str){
        String[] re = str.split(",", 3);
        this.kamoku   = re[0];
        this.tani     = re[1];
        this.sh = re[2];
    }

    public static String getTani(){
        return tani;
    }

    public static String getSh(){
        return sh;
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
    public static String semester = null;

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

        teacherTextFeild.clear();
        classroomTextFeild.clear();
        memoTextArea.clear();
    }

    public static void initialize1(String term) {
        System.out.println("Kamoku Start");
        semester = term;
        Jikanwari.kamokuStart();
    }

    public void subjectGroupChoiced(ActionEvent event) {//科目群の選択をしたら
        ComboBox c = (ComboBox)event.getSource();
        System.out.println( "Select:"+(String)c.getValue() ) ;
	    kamokugun = (String)c.getValue();
        
        subjectChoice.getItems().clear();

        file(kamokugun,0,null,null,0,null,null,null);//0ファイル読み込み
        
        subjectChoice.getSelectionModel().select(0);
    }

    public void subjectChoiced(ActionEvent event) {//科目を選択したら
        ComboBox c = (ComboBox)event.getSource();
        kamoku = (String)c.getValue();//add
        System.out.println( "Select:"+kamoku);
    }

    public void backAction(ActionEvent event) {//←のボタンを押すと
        System.out.println("Back");
        reset();
        JikanwariController.reStart();
    }

    public void saveAction(ActionEvent event) {//OKボタンを押すと
        kamokugun = (String)subjectGroupChoice.getValue();
        kamoku = (String)subjectChoice.getValue();//add
        String teacher = (String)teacherTextFeild.getText();
        String classroom = (String)classroomTextFeild.getText();
        String memo = (String)memoTextArea.getText();
        
        file(kamokugun,1,kamokugun,kamoku,x,teacher,classroom,memo);//1ファイル保存

        if(kamokugun.equals("")){
            System.out.println(semester + " Save:"+ kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
            Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo, semester);
        }
        
        reset();
        JikanwariController.initialize();//更新するように変更
        Jikanwari.jikanwariStart();//add
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと
        System.out.println("delete");
        reset();
    }

    public void upAbsenceAction(ActionEvent event) {//欠席カウントup
        x = x + 1;
        absenceLabel.setText( + x + "回");
        System.out.println("Abesence Count："+ x);
    }

    public void downAbsenceAction(ActionEvent event) {//欠席カウントdown
        x = x - 1;
        if(x >= 0){
            absenceLabel.setText( + x + "回");
            System.out.println("Abesence Count：" + x);
        }else{
            absenceLabel.setText("0回");
            System.out.println("Abesence Count：0");
        }   
    }

    public void getTani(ActionEvent event) {//単位取得のチェックしたら

    }
    
    

    public void file(String fileMei,int k,
                    String kamokugun,String kamoku,int x,String teacher,String classroom,String memo){//ファイルを読み込み
        if(fileMei.equals("基軸教育科目")){
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(fileMei.equals("現代教養科目")){
            try {
                File file  = new File("現代教養科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(fileMei.equals("留学生科目")){
            try {
                File file  = new File("留学生科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(fileMei.equals("教職等資格科目")){
            try {
                File file  = new File("教職等資格科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(fileMei.equals("理系科目")){
            try {
                File file  = new File("理系科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }else if(fileMei.equals("学部共通科目")){
            try {
                File file  = new File("学部共通科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamokuToTani(sc,kamokugun,kamoku,x,teacher,classroom,memo);
                }
            } catch (FileNotFoundException e){
                System.err.print(e);
            }
        }
    }

    public void fileYomikomi(Scanner sc){//コンボボックスに表示
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
                String sh = jugyou.getSh();
                System.out.println(semester + " Save:"+ 
                                   kamokugun+","+kamoku+","+tani+ ","+sh +","+x+","+teacher+","+classroom+","+memo);
                Jikanwari.save(kamokugun+","+kamoku+","+tani+","+ ","+sh +x+","+teacher+","+classroom+","+memo,semester);
            }
        }
    }

    public void reset(){//初期化
        subjectGroupChoice.getSelectionModel().select(0);
        subjectChoice.getItems().clear();
        x = 0;
        teacherTextFeild.clear();
        classroomTextFeild.clear();
        memoTextArea.clear();
    }
}