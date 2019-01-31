import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class JikanwariController implements Initializable {
    @FXML private ComboBox<String> termComboBox;

    private static Label subjectLavel[];
    private static Label teacherLavel[];
    private static Label classRoomLavel[];
    private static Label memoLavel[];
    public static String gakki;

    @FXML private Label mon1Subject;
    @FXML private Label mon1Teacher;
    @FXML private Label mon1ClassRoom;
    @FXML private Label mon1Memo;
    @FXML private Label tue1Subject;
    @FXML private Label tue1Teacher;
    @FXML private Label tue1ClassRoom;
    @FXML private Label tue1Memo;
    @FXML private Label wed1Subject;
    @FXML private Label wed1Teacher;
    @FXML private Label wed1ClassRoom;
    @FXML private Label wed1Memo;
    @FXML private Label tur1Subject;
    @FXML private Label tur1Teacher;
    @FXML private Label tur1ClassRoom;
    @FXML private Label tur1Memo;
    @FXML private Label fri1Subject;
    @FXML private Label fri1Teacher;
    @FXML private Label fri1ClassRoom;
    @FXML private Label fri1Memo;
    @FXML private Label mon2Subject;
    @FXML private Label mon2Teacher;
    @FXML private Label mon2ClassRoom;
    @FXML private Label mon2Memo;
    @FXML private Label tue2Subject;
    @FXML private Label tue2Teacher;
    @FXML private Label tue2ClassRoom;
    @FXML private Label tue2Memo;
    @FXML private Label wed2Subject;
    @FXML private Label wed2Teacher;
    @FXML private Label wed2ClassRoom;
    @FXML private Label wed2Memo;
    @FXML private Label tur2Subject;
    @FXML private Label tur2Teacher;
    @FXML private Label tur2ClassRoom;
    @FXML private Label tur2Memo;
    @FXML private Label fri2Subject;
    @FXML private Label fri2Teacher;
    @FXML private Label fri2ClassRoom;
    @FXML private Label fri2Memo;
    @FXML private Label mon3Subject;
    @FXML private Label mon3Teacher;
    @FXML private Label mon3ClassRoom;
    @FXML private Label mon3Memo;
    @FXML private Label tue3Subject;
    @FXML private Label tue3Teacher;
    @FXML private Label tue3ClassRoom;
    @FXML private Label tue3Memo;
    @FXML private Label wed3Subject;
    @FXML private Label wed3Teacher;
    @FXML private Label wed3ClassRoom;
    @FXML private Label wed3Memo;
    @FXML private Label tur3Subject;
    @FXML private Label tur3Teacher;
    @FXML private Label tur3ClassRoom;
    @FXML private Label tur3Memo;
    @FXML private Label fri3Subject;
    @FXML private Label fri3Teacher;
    @FXML private Label fri3ClassRoom;
    @FXML private Label fri3Memo;
    @FXML private Label mon4Subject;
    @FXML private Label mon4Teacher;
    @FXML private Label mon4ClassRoom; 
    @FXML private Label mon4Memo;
    @FXML private Label tue4Subject; 
    @FXML private Label tue4Teacher;
    @FXML private Label tue4ClassRoom;
    @FXML private Label tue4Memo;
    @FXML private Label wed4Subject;
    @FXML private Label wed4Teacher;
    @FXML private Label wed4ClassRoom;
    @FXML private Label wed4Memo;
    @FXML private Label tur4Subject;
    @FXML private Label tur4Teacher;
    @FXML private Label tur4ClassRoom;
    @FXML private Label tur4Memo;
    @FXML private Label fri4Subject;
    @FXML private Label fri4Teacher;
    @FXML private Label fri4ClassRoom;
    @FXML private Label fri4Memo;
    @FXML private Label mon5Subject;
    @FXML private Label mon5Teacher;
    @FXML private Label mon5ClassRoom;
    @FXML private Label mon5Memo;
    @FXML private Label tue5Subject;
    @FXML private Label tue5Teacher;
    @FXML private Label tue5ClassRoom;
    @FXML private Label tue5Memo;
    @FXML private Label wed5Subject;
    @FXML private Label wed5Teacher;
    @FXML private Label wed5ClassRoom;
    @FXML private Label wed5Memo;
    @FXML private Label tur5Subject;
    @FXML private Label tur5Teacher;
    @FXML private Label tur5ClassRoom;
    @FXML private Label tur5Memo;
    @FXML private Label fri5Subject;
    @FXML private Label fri5Teacher;
    @FXML private Label fri5ClassRoom;
    @FXML private Label fri5Memo;

    @FXML private TextArea monText;
    @FXML private TextArea tueText;
    @FXML private TextArea wedText;
    @FXML private TextArea turText;
    @FXML private TextArea friText;

    public ComboBox<String> getTermComboBox() {
        return termComboBox;
    }
 
    public void setTermComboBox(ComboBox<String> termComboBox) {
        this.termComboBox = termComboBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectLavel = new Label[] {mon1Subject,tue1Subject,wed1Subject,tur1Subject,fri1Subject,mon2Subject,tue2Subject,wed2Subject,tur2Subject,fri2Subject,mon3Subject,tue3Subject,wed3Subject,tur3Subject,fri3Subject,mon4Subject,tue4Subject,wed4Subject,tur4Subject,fri4Subject,mon5Subject,tue5Subject,wed5Subject,tur5Subject,fri5Subject};
        teacherLavel = new Label[] {mon1Teacher,tue1Teacher,wed1Teacher,tur1Teacher,fri1Teacher,mon2Teacher,tue2Teacher,wed2Teacher,tur2Teacher,fri2Teacher,mon3Teacher,tue3Teacher,wed3Teacher,tur3Teacher,fri3Teacher,mon4Teacher,tue4Teacher,wed4Teacher,tur4Teacher,fri4Teacher,mon5Teacher,tue5Teacher,wed5Teacher,tur5Teacher,fri5Teacher};
        classRoomLavel = new Label[]{mon1ClassRoom,tue1ClassRoom,wed1ClassRoom,tur1ClassRoom,fri1ClassRoom,mon2ClassRoom,tue2ClassRoom,wed2ClassRoom,tur2ClassRoom,fri2ClassRoom,mon3ClassRoom,tue3ClassRoom,wed3ClassRoom,tur3ClassRoom,fri3ClassRoom,mon4ClassRoom,tue4ClassRoom,wed4ClassRoom,tur4ClassRoom,fri4ClassRoom,mon5ClassRoom,tue5ClassRoom,wed5ClassRoom,tur5ClassRoom,fri5ClassRoom};
        memoLavel = new Label[]{mon1Memo,tue1Memo,wed1Memo,tur1Memo,fri1Memo,mon2Memo,tue2Memo,wed2Memo,tur2Memo,fri2Memo,mon3Memo,tue3Memo,wed3Memo,tur3Memo,fri3Memo,mon4Memo,tue4Memo,wed4Memo,tur4Memo,fri4Memo,mon5Memo,tue5Memo,wed5Memo,tur5Memo,fri5Memo};

        termComboBox.getItems().add("1年前期");//コンボボックスリスト
        termComboBox.getItems().add("1年後期");
        termComboBox.getItems().add("2年前期");
        termComboBox.getItems().add("2年後期");
        termComboBox.getItems().add("3年前期");
        termComboBox.getItems().add("3年後期");
        termComboBox.getItems().add("4年後期");
        termComboBox.getItems().add("4年前期");

        termComboBox.getSelectionModel().select(0);//0ならコンボボックスの1番上の表示(1年前期)
        initialize();
        System.out.println("Start");
    }

    /*public static void initialize(){
        for(int i=0;i<25;i++){
            String[] str = Jikanwari.sal1Spring.data[i/5][i%5].split(",",9);
            if(str.length>1){
                subjectLavel[i].setText(str[1]);//科目ラベルの配置
            }
            if(str.length>4){
                teacherLavel[i].setText(str[5]);//担任名表示するよう変更
            }
            if(str.length>5){
                classRoomLavel[i].setText(str[6]);//教室名
            }
            if(str.length>6){
                memoLavel[i].setText(str[7]);//メモ
            }
        }
    }*/

     public static void initialize(){
        for(int i=0;i<25;i++){
            String[] str;
            if(gakki=="1年前期"){
                String[] str1 = Jikanwari.sal1Spring.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="1年後期"){
                String[] str1 = Jikanwari.sal1Fall.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="2年前期"){
                String[] str1 = Jikanwari.sal2Spring.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="2年後期"){
                String[] str1 = Jikanwari.sal2Fall.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="3年前期"){
                String[] str1 = Jikanwari.sal3Spring.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="3年後期"){
                String[] str1 = Jikanwari.sal3Fall.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="4年前期"){
                String[] str1 = Jikanwari.sal4Spring.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else if(gakki=="4年後期"){
                String[] str1 = Jikanwari.sal4Fall.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }else{
                String[] str1=Jikanwari.sal1Spring.data[i/5][i%5].split(",");
                str=new String[str1.length];
                for(int j=0;j<str1.length;j++){
                    str[j]=str1[j];
                }
            }
	    
            if(str.length>1){
                subjectLavel[i].setText(str[1]);//科目ラベルの配置
            }else{
                subjectLavel[i].setText(" ");
	    }
            if(str.length>5){
                teacherLavel[i].setText(str[5]);//担任名表示するよう変更
            }else{
                teacherLavel[i].setText(" ");
            }

            if(str.length>6){
                classRoomLavel[i].setText(str[6]);//教室名
            }else{
                classRoomLavel[i].setText(" ");
            }

            if(str.length>7){
                memoLavel[i].setText(str[7]);//メモ
            }else{
                memoLavel[i].setText(" ");
            }
        }
    }


    public void jikanwariSaveAction(ActionEvent event) {//保存ボタンを押したら
        System.out.println("Save：" + termComboBox.getValue());
        System.out.println(termComboBox.getValue() + " Save:" 
                            + monText.getText() + "," + tueText.getText() + "," + wedText.getText() + "," + turText.getText() + "," +friText.getText());
        Jikanwari.saving(0,monText.getText(),termComboBox.getValue());
        Jikanwari.saving(1,tueText.getText(),termComboBox.getValue());
        Jikanwari.saving(2,wedText.getText(),termComboBox.getValue());
        Jikanwari.saving(3,turText.getText(),termComboBox.getValue());
        Jikanwari.saving(4,friText.getText(),termComboBox.getValue());
    }

    public void termComboBoxCoiced( ActionEvent e ){//セメスターを選択したら
        gakki=(String)getTermComboBox().getValue();
        System.out.println( "Select:"+gakki ) ;
        //System.out.println( "Select:"+(String)getTermComboBox().getValue() ) ;
        Jikanwari.load(termComboBox.getValue());
        initialize();
    }    

    public void kamokuAction(ActionEvent event) {//時間割コマを押すと
        Button b =(Button)event.getSource();//add
        String sid = b.getId();//add
        int id = Integer.parseInt(sid);//add
        Jikanwari.ckoma = id/5;//add
        Jikanwari.cyoubi = id%5;//add
        System.out.println("Kamoku select");
        KamokuController.initialize1(termComboBox.getValue());
    }    

    public void checkTani(ActionEvent event) {//単位取得確認ボタンを押すと
        //すべてのファイルを読み込んで、trueの単位と選択or必修、科目群の取得
        System.out.println("Tani check Action");
        int i = 0;
        int j = 0;

        String[][][] str = new String[8][25][9]; 
        
        for( i=0;i<25;i++){
            try{  
                String st[] = Jikanwari.sal1Spring.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[0][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[0][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal1Fall.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[1][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[1][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal2Spring.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[2][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[2][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal2Fall.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[3][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[3][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal3Spring.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[4][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[4][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal3Fall.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[5][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[5][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal4Spring.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[6][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[6][i][j] = null;
                }
            }try{
                String st[] = Jikanwari.sal4Fall.data[i/5][i%5].split(",");
                for(j = 0; j < 9; j++){
                    str[7][i][j] = st[j];
                }
            }catch (Exception e){
                String st[] = null;
                for(j = 0; j < 9; j++){
                    str[7][i][j] = null;
                }
            }


              /*  System.out.println(st0[i]);

                for(j = 0; j < 9; j++){
                    str[0][i][j] = st0[j];
                    str[1][i][j] = st1[j];
                    str[2][i][j] = st2[j];
                    str[3][i][j] = st3[j];
                    str[4][i][j] = st4[j];
                    str[5][i][j] = st5[j];
                    str[6][i][j] = st6[j];
                    str[7][i][j] = st7[j];
                    
                }*/
             
            
        
           /* KeisanController.getTani("教養","必修",0.0);
            KeisanController.getTani("教養","選択必修",0.0);
            KeisanController.getTani("教養","選択",0.0);
            KeisanController.getTani("専門","必修",0.0);
            KeisanController.getTani("専門","選択必修",0.0);
            KeisanController.getTani("専門","選択",0.0);*/
        }     
        System.out.println(str[0][0][2]);
            String kyoutuorSentaku;
            for( i = 0; i < 8; i++){
                for(j = 0; j < 25; j++){
                    String s8 = str[i][j][8];
                   // System.out.println(s8);
                    if(s8!=null){
                        if(s8.equals("true")){
                            String s2 = str[i][j][2];
                            double tani = Double.parseDouble(s2);//Double.parseDouble(str[i])
                            System.out.println(tani);
                            String s0 = str[i][j][0];
                            String s4 = str[i][j][4];
                            if(s0!=null){
                                if((s0.equals("基軸教育科目"))|| (s0.equals("現代教養科目"))|| (s0.equals("留学生科目"))|| (s0.equals("教職等資格科目") )|| (s0.equals("理系科目")) )     {
                                    System.out.println("教養");
                                    kyoutuorSentaku = "教養";
                                    KeisanController.getTani(kyoutuorSentaku,s4,tani);
                                }else if(s0.equals("学部共通科目")){
                                    System.out.println("専門");
                                    kyoutuorSentaku = "専門";
                                    KeisanController.getTani(kyoutuorSentaku,s4,tani);
                                }
                            }
                        }   
                    }else{
                        KeisanController.getTani("教養","必修",0.0);
                        KeisanController.getTani("教養","選択必修",0.0);
                        KeisanController.getTani("教養","選択",0.0);
                        KeisanController.getTani("専門","必修",0.0);
                        KeisanController.getTani("専門","選択必修",0.0);
                        KeisanController.getTani("専門","選択",0.0);
                    }
                }
            }
          

        KeisanController.initialize();
    } 

    public static void reStart() {
        System.out.println("reStart");
        Jikanwari.jikanwariStart();
        initialize();//更新
    }

}