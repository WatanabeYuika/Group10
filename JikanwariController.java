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
        System.out.print("start");
    }
    
    public void kamokuAction(ActionEvent event) {
        System.out.print("Kamoku select");
        KamokuController.initialize();
    }
}
