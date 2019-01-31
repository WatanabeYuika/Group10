import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KeisanController implements Initializable {
    @FXML private Label nowLabel;
    @FXML private Label leftLabel;
    @FXML private TextField needTextField;

    public Label getNowLabel(){
        return nowLabel;
    }
    
    public void setNowLabel(Label nowLabel){
        this.nowLabel = nowLabel;
    }

    public Label getLeftLabel(){
        return leftLabel;
    }
    
    public void setLeftLabel(Label leftLabel){
        this.leftLabel = leftLabel;
    }

    public void backAction(ActionEvent event) {//保存もしなきゃ
        System.out.println("Back");
        JikanwariController.reStart();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TaniKesan Start");
    }

    public static void initialize() {
        Jikanwari.keisanStart();
    }
}