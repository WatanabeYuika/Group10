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

public class KamokuController implements Initializable {
    private TextArea classroomTextArea;
    private TextArea teacherTextArea;
    private TextArea memoTextArea;
    private CheckBox taniCheck;
    private Label absenceLabel;
    @FXML
    private ComboBox<String> subjectGroupChoice;
    @FXML
    private ComboBox<String> subjectChoice;

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subjectGroupChoice.getItems().add("１");
        subjectGroupChoice.getItems().add("２");
        subjectGroupChoice.getItems().add("３");
        subjectGroupChoice.getItems().add("４");
        subjectGroupChoice.getItems().add("５");

        subjectGroupChoice.getSelectionModel().select(-1);
    }

    public void subjectGroupChoiced(ActionEvent event) {//科目群の選択をしたら
        ComboBox c = (ComboBox)event.getSource();
        System.out.println( "選択:"+(String)c.getValue() ) ;
        if(c.getValue().equals("１")){
            subjectChoice.getItems().add("１");
            subjectChoice.getItems().add("２");
            subjectChoice.getSelectionModel().select(-1);
        }
    }

    public void subjectChoiced(ActionEvent event) {//科目を選択したら
        ComboBox c = (ComboBox)event.getSource();
        System.out.println( "選択:"+(String)c.getValue() );
    }

    public void backAction(ActionEvent event) {//←のボタンを押すと
        initialize();
    }

    public void selectAction(ActionEvent event) {//メニューのセレクト
        System.out.println("select");
    }

    public void saveAction(ActionEvent event) {//OKボタンを押すと
        initialize();
    }

    public void deleteAction(ActionEvent event) {//削除ボタンを押すと
        initialize();
    }

    public void upAbsenceAction(ActionEvent event) {//欠席カウントup

    }

    public void downAbsenceAction(ActionEvent event) {//欠席カウントdown

    }

    public void getTani(ActionEvent event) {//単位取得のチェックしたら

    }
    
    public static void initialize() {
        System.out.println("科目入力画面になります");
        Jikanwari.kamokuStart();
    }
}
