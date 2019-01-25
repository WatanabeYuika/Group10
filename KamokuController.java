import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class KamokuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public static void initialize() {
        System.out.println("科目入力画面になります");
        Jikanwari.kamokuStart();
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

    public void upAbsenceAction(ActionEvent event) {

    }

    public void downAbsenceAction(ActionEvent event) {

    }

    public void getTani(ActionEvent event) {

    }
}
