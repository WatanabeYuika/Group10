import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class JikanwariController implements Initializable {
    @FXML
    private ComboBox<String> termComboBox;

    public ComboBox<String> getTermComboBox() {
        return termComboBox;
    }
 
    public void setTermComboBox(ComboBox<String> termComboBox) {
        this.termComboBox = termComboBox;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        termComboBox.getItems().add("1年前期");//コンボボックスリスト
        termComboBox.getItems().add("1年後期");
        termComboBox.getItems().add("2年前期");
        termComboBox.getItems().add("2年後期");
        termComboBox.getItems().add("3年前期");
        termComboBox.getItems().add("3年後期");
        termComboBox.getItems().add("4年後期");
        termComboBox.getItems().add("4年前期");
       
        termComboBox.getSelectionModel().select(-1);//0ならコンボボックスの1番上の表示(1年前期)

        initialize();
    }

    public void jikanwariSaveAction(ActionEvent event) {//保存ボタンを押したら
        Jikanwari.saving();
    }

    public void termComboBoxCoiced( ActionEvent e ){//セメスターを選択したら
        ComboBox c = (ComboBox)e.getSource();
        System.out.println( "選択:"+(String)c.getValue() ) ;

        if(c.getValue().equals("１年前期")){

        }else if(c.getValue().equals("１年後期")){

        }else if(c.getValue().equals("２年前期")){

        }else if(c.getValue().equals("２年後期")){

        }else if(c.getValue().equals("３年前期")){
        
        }else if(c.getValue().equals("3年後期")){

        }else if(c.getValue().equals("４年前期")){

        }else if(c.getValue().equals("４年後期")){

        }
    }
    
    public void kamokuAction(ActionEvent event) {//時間割コマを押すと
	Button b=(Button)event.getSource();
	String sid=b.getId();
	int id=Integer.parseInt(sid);
	Jikanwari.ckoma=id/5;
	Jikanwari.cyoubi=id%5;
        System.out.println("Kamoku select");
        KamokuController.initialize();
    }    

    public void initialize() {
        System.out.println("start");
    }

}
