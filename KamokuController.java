import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

    public static String getSh(){//選択か必修か
        return sh;
    }
    
    public String toString(){
        return kamoku;
    }
}

public class KamokuController implements Initializable {
    int x = 0;
    @FXML private TextArea classroomTextArea;
    @FXML private TextArea teacherTextArea;
    @FXML private TextArea memoTextArea;
    @FXML private CheckBox taniCheck;
    private static TextArea[] kougijyoho;

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
    
    public void setMemoArea(TextArea memoTextArea){
        this.memoTextArea = memoTextArea;
    }

    public CheckBox getTaniCheck(){
        return taniCheck;
    }

    public void setTaniCheck(CheckBox taniCheck){
        this.taniCheck= taniCheck;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kougijyoho = new TextArea[] {teacherTextArea,classroomTextArea,memoTextArea};
        subjectGroupChoice.getItems().add("");
        subjectGroupChoice.getItems().add("基軸教育科目");
        subjectGroupChoice.getItems().add("現代教養科目");
        subjectGroupChoice.getItems().add("留学生科目");
        subjectGroupChoice.getItems().add("教職等資格科目");
        subjectGroupChoice.getItems().add("理系科目");
        subjectGroupChoice.getItems().add("学部共通科目");

        subjectGroupChoice.getSelectionModel().select(0);
    }

    public static void initialize1(String term, int koma, int youbi) {
        System.out.println("Kamoku Start");
        Jikanwari.kamokuStart();
        semester = term;
        Jikanwari.load(semester);
        String[] str = null;
        if(semester == "1年前期"){
            str = Jikanwari.sal1Spring.data[koma][youbi].split(",");
            preparation(str); 
        }else if(semester == "1年後期"){
            str = Jikanwari.sal1Fall.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "2年前期"){
            str = Jikanwari.sal2Spring.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "2年後期"){
            str = Jikanwari.sal2Fall.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "3年前期"){
            str = Jikanwari.sal3Spring.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "3年後期"){
            str = Jikanwari.sal3Fall.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "4年前期"){
            str = Jikanwari.sal4Spring.data[koma][youbi].split(",");
            preparation(str);
        }else if(semester == "4年後期"){
            str = Jikanwari.sal4Fall.data[koma][youbi].split(",");
            preparation(str);
        }
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
        String teacher = (String)teacherTextArea.getText();
        String classroom = (String)classroomTextArea.getText();
        String memo = (String)memoTextArea.getText();

        if(kamokugun.equals("")){
            System.out.println(semester + " Save:"+ kamokugun+","+kamoku+","+tani+","+x+","+teacher+","+classroom+","+memo+","+"false");
            Jikanwari.save(kamokugun+","+""+","+tani+","+x+","+""+","+teacher+","+classroom+","+memo+","+"false", semester);
        }else{
            file(kamokugun,1,kamokugun,kamoku,x,teacher,classroom,memo);//1ファイル保存
        }

        reset();
        JikanwariController.reStart();//更新するように変更
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと
        System.out.println("delete");
        reset();
        Jikanwari.save(",,null,0,,,,,false", semester);
        JikanwariController.reStart();
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

    //ファイル読み込み
    public void file(String fileMei,int k,  
                    String kamokugun,String kamoku,int x,String teacher,String classroom,String memo){

        if(fileMei.equals("基軸教育科目")){
            try {
                File file  = new File("基軸教育科目.csv");
                Scanner sc = new Scanner(file);
                if(k == 0){
                    fileYomikomi(sc);
                }else if(k == 1){
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
                    saveKamoku(sc,kamokugun,kamoku,x,teacher,classroom,memo);
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
    public void saveKamoku(Scanner sc,String kamokugun,String kamoku,int x,
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
                boolean check = taniCheck.isSelected();
                String ch = String.valueOf( check );//boolean → String
                System.out.println(semester + " Save:"+ 
                                   kamokugun+","+kamoku+","+tani+","+ x +","+ sh +","+teacher+","+classroom+","+memo+","+ch);
                Jikanwari.save(    kamokugun+","+kamoku+","+tani+","+ x +","+ sh +","+teacher+","+classroom+","+memo+","+ch, semester);
                //                      0     ,     1    ,   2    ,   3   ,    4   ,     5     ,      6      ,   7   ,   8
            }
        }
    }

    public void reset(){//初期化
        subjectGroupChoice.getSelectionModel().select(0);
        subjectChoice.getItems().clear();
        x = 0;
        for(int i = 0; i < 3; i++){
            kougijyoho[i].clear();
        }
        taniCheck.setSelected(false);
    }

    public static void preparation(String[] str){
        for(int i = 0; i < 3; i++){
            if(str.length > (5 + i)){
                kougijyoho[i].setText(str[5 + i]);
            }else{
                kougijyoho[i].clear();
            }
        }
    }
}