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
        initialize();
    }

    public static void initialize() {
        System.out.print("start");
        Jikanwari.kamokuStart();
    }
    
    public void backAction(ActionEvent event) {
        initialize();
    }

    public void selectAction(ActionEvent event) {
        System.out.print("select");
    }
}
