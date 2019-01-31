import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KeisanController implements Initializable {
    @FXML private Label khissyu1;
    @FXML private Label khissyu2;
    @FXML private Label khissyu3;
    @FXML private Label ksentakuhissyu1;
    @FXML private Label ksentakuhissyu2;
    @FXML private Label ksentakuhissyu3;
    @FXML private Label ksentaku1;
    @FXML private Label ksentaku2;
    @FXML private Label ksentaku3;
    @FXML private Label shissyu1;
    @FXML private Label shissyu2;
    @FXML private Label shissyu3;
    @FXML private Label ssentakuhissyu1;
    @FXML private Label ssentakuhissyu2;
    @FXML private Label ssentakuhissyu3;
    @FXML private Label ssentaku1;
    @FXML private Label sksentaku2;
    @FXML private Label ssentaku3;

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