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

    @FXML private TextArea monText;//getText()でテキストフィールドのように取得できます
    @FXML private TextArea tueText;
    @FXML private TextArea wedText;
    @FXML private TextArea TurText;
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

        termComboBox.getItems().add("1年前期");//コンボボックスリストstatic問題
        termComboBox.getItems().add("1年後期");
        termComboBox.getItems().add("2年前期");
        termComboBox.getItems().add("2年後期");
        termComboBox.getItems().add("3年前期");
        termComboBox.getItems().add("3年後期");
        termComboBox.getItems().add("4年後期");
        termComboBox.getItems().add("4年前期");

        termComboBox.getSelectionModel().select(0);//0ならコンボボックスの1番上の表示(1年前期)
        initialize();
    }

    public static void initialize(){
        for(int i=0;i<25;i++){
            String[] str=Jikanwari.sal1Spring.data[i/5][i%5].split(",");
            if(str.length>1){
                subjectLavel[i].setText(str[1]);//科目ラベルの配置
            }
            if(str.length>4){
                teacherLavel[i].setText(str[4]);//担任名表示するよう変更
            }
            if(str.length>5){
                classRoomLavel[i].setText(str[5]);//教室名
            }
            if(str.length>6){
                memoLavel[i].setText(str[6]);//メモ
            }
        }
        System.out.println("Start");
    }

    public void jikanwariSaveAction(ActionEvent event) {//保存ボタンを押したら
        System.out.println("Save：" + termComboBox.getValue());
        Jikanwari.saving(termComboBox.getValue());
    }

    public void termComboBoxCoiced(ActionEvent e ){//セメスターを選択したら
        System.out.println( "Select:"+(String)getTermComboBox().getValue() ) ;
        Jikanwari.load(termComboBox.getValue());
    }    

    public void kamokuAction(ActionEvent event) {//時間割コマを押すと
        Button b =(Button)event.getSource();//add
        String sid = b.getId();//add
        int id = Integer.parseInt(sid);//add
        Jikanwari.ckoma = id/5;//add
        Jikanwari.cyoubi = id%5;//add
        System.out.println("Kamoku select");
        KamokuController.initialize(termComboBox.getValue(),Jikanwari.ckoma,Jikanwari.cyoubi);
    }    

    public void checkTani(ActionEvent event) {//単位取得確認ボタンを押すと
        KeisanController.initialize();
    } 

    public static void reStart() {
        System.out.println("reStart");
        Jikanwari.jikanwariStart();
        initialize();
    }

}
