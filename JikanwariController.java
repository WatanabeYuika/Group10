import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JikanwariController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }

    public void initialize() {
        System.out.println("start");
    }
    
    public void kamokuAction(ActionEvent event) {//時間割コマを押すと
        System.out.println("Kamoku select");
        KamokuController.initialize();
    }
}
