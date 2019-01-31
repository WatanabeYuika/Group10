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
    static int x = 0;
    @FXML private static TextField classroomTextFeild;
    @FXML private static TextField teacherTextFeild;
    @FXML private static TextArea memoTextArea;
    private CheckBox taniCheck;
    public String kamokugun = null;
    public String kamoku = null;
    public String tani = null;// 単位の保存も
    public static String semester = null;

    @FXML private static Label absenceLabel;
    @FXML private static ComboBox<String> subjectGroupChoice;
    @FXML private static ComboBox<String> subjectChoice;

    public static ComboBox<String> getSubjectGroupChoice() {
        return subjectGroupChoice;
    }
 
    public static void setSubjectGroupChoice(ComboBox<String> subjectGroup) {
        subjectGroupChoice = subjectGroup;
    }

    public static ComboBox<String> getSubjectChoice() {
        return subjectChoice;
    }

    public static void setSubjectChoice(ComboBox<String> subject) {
        subjectChoice = subject;
    }

    public static Label getAbsenceLabel(){
        return absenceLabel;
    }

    public static void setAbsenceLabel(Label absence){
        absenceLabel = absence;
    }

    public static TextField getTeacherFeild(){
        return classroomTextFeild;
    }
    
    public static void setTeacherFeild(TextField teacherText){
        teacherTextFeild = teacherText;
    }

    public static TextField getClassroomTextFeild(){
        return classroomTextFeild;
    }

    public static void setClassroomFeild(TextField classroomText){
        classroomTextFeild = classroomText;
    }

    public static TextArea getMemoTextArea(){
        return memoTextArea;
    }

    public static void setMemoArea(TextArea memoText){
        memoTextArea = memoText;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public static void initialize(String term,int koma, int youbi) {
        System.out.println("KamokuStart");
        semester = term;
        String st = null;

        getSubjectGroupChoice().getItems().add("");
        getSubjectGroupChoice().getItems().add("基軸教育科目");
        getSubjectGroupChoice().getItems().add("現代教養科目");
        getSubjectGroupChoice().getItems().add("留学生科目");
        getSubjectGroupChoice().getItems().add("教職等資格科目");
        getSubjectGroupChoice().getItems().add("理系科目");
        getSubjectGroupChoice().getItems().add("学部共通科目");

        if(semester == null){ 
            subjectGroupChoice.getSelectionModel().select(0);
        }else if(semester.equals("1年前期")){
            st = Jikanwari.sal1Spring.loadData(koma, youbi);
        
               
            String[] re = st.split(",", 7);
            if(re[0].equals("基軸教育科目")){
                subjectGroupChoice.getSelectionModel().select(1);
                try {
                    File file  = new File("基軸教育科目.csv");
                    Scanner sc = new Scanner(file);
                    String str;
                    int i = 0;
                    while(sc.hasNextLine()){
                        str = sc.nextLine();               
                        String[] r = str.split(",", 0);
                        Jugyou jugyou = new Jugyou(str);
                        String kamoku2 = jugyou.toString();
                        subjectChoice.getItems().add(kamoku2);
                        if(re[1].equals(kamoku2)){
                            subjectChoice.getSelectionModel().select(i);
                        }else{
                            i++;
                        }
                    }
                } catch (FileNotFoundException e){
                    System.err.print(e);
                }    
            }

            x = Integer.parseInt(re[3]);
            absenceLabel.setText( + x + "回");
    
            teacherTextFeild.setPromptText(re[4]);
            classroomTextFeild.setPromptText(re[5]);
            memoTextArea.setPromptText(re[6]);
        }
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
        
        JikanwariController.initialize();//更新するように変更
        Jikanwari.jikanwariStart();//add
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと
        System.out.println("delete");
        subjectGroupChoice.getSelectionModel().select(0);
        subjectChoice.getItems().clear();
        teacherTextFeild.clear();
        classroomTextFeild.clear();
        memoTextArea.clear();

        String teacher = (String)teacherTextFeild.getText();
        String classroom = (String)classroomTextFeild.getText();
        String memo = (String)memoTextArea.getText();

        System.out.println(semester + " Save:"+ kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
        Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo, semester);
    }

    public void upAbsenceAction(ActionEvent event) {//欠席カウントup
        x = x + 1;
        absenceLabel.setText( + x + "回");
        System.out.println("AbsenceCount："+ x);
    }

    public void downAbsenceAction(ActionEvent event) {//欠席カウントdown
        x = x - 1;
        if(x >= 0){
            absenceLabel.setText( + x + "回");
            System.out.println("AbsenceCount：" + x);
        }else{
            absenceLabel.setText("0回");
            System.out.println("AbsenceCount：0");
        }   
    }

    public void getTani(ActionEvent event) {//単位取得のチェックしたら

    }
    
    public void file(String fileMei,int k,String kamokugun,String kamoku,int x,String teacher,String classroom,String memo){
        if(fileMei != null){
            try {
                File file  = new File(fileMei +".csv");
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
                System.out.println(semester + " Save:"+ 
                                   kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo);
                Jikanwari.save(kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo,semester);
            }
        }
    }
}