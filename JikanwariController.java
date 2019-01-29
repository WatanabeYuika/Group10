import java.net.URL;
import javafx.application.Platform;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class JikanwariController implements Initializable {
    @FXML private ComboBox<String> termComboBox;
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
        System.out.println("Kamoku select");
        KamokuController.initialize();
    }    

    public static void initialize() {
        System.out.println("start");
    }

     public static void reStart() {
        System.out.println("reStart");
        Jikanwari.jikanwariReStart();
    }



    public Label getMon1Subject() {
        return mon1Subject;
    }
    public void setMon1Subject(Label mon1Subject) {
        this.mon1Subject = mon1Subject;
    }
    public Label getMon1Teacher() {
        return mon1Teacher;
    }
    public void setMon1Teacher(Label mon1Teacher) {
        this.mon1Teacher = mon1Teacher;
    }
    public Label getMon1ClassRoom() {
        return mon1ClassRoom;
    }
    public void setMon1ClassRoom(Label mon1ClassRoom) {
        this.mon1ClassRoom = mon1ClassRoom;
    }
    public Label getMon1Memo() {
        return mon1Memo;
    }
    public void setMon1Memo(Label tue1Memo) {
        this.tue1Memo = tue1Memo;
    }

    public Label getTue1Subject() {
        return tue1Subject;
    }
    public void setTue1Subject(Label tue1Subject) {
        this.tue1Subject = tue1Subject;
    }
    public Label getTue1Teacher() {
        return tue1Teacher;
    }
    public void setTue1Teacher(Label tue1Teacher) {
        this.tue1Teacher = tue1Teacher;
    }
    public Label getTue1ClassRoom() {
        return tue1ClassRoom;
    }
    public void setTue1ClassRoom(Label tue1ClassRoom) {
        this.tue1ClassRoom = tue1ClassRoom;
    }
    public Label getTue1Memo() {
        return tue1Memo;
    }
    public void setTue1Memo(Label tue1Memo) {
        this.tue1Memo = tue1Memo;
    }

    public Label getWed1Subject() {
        return wed1Subject;
    }
    public void setWed1Subject(Label wed1Subject) {
        this.wed1Subject = wed1Subject;
    }
    public Label getWed1Teacher() {
        return wed1Teacher;
    }
    public void setWed1Teacher(Label wed1Teacher) {
        this.wed1Teacher = wed1Teacher;
    }
    public Label getWed1ClassRoom() {
        return wed1ClassRoom;
    }
    public void setWed1ClassRoom(Label wed1ClassRoom) {
        this.wed1ClassRoom = wed1ClassRoom;
    }
    public Label getWed1Memo() {
        return wed1Memo;
    }
    public void setWed1Memo(Label mon1Memo) {
        this.wed1Memo = wed1Memo;
    }

    public Label getTur1Subject() {
        return tur1Subject;
    }
    public void setTur1Subject(Label tur1Subject) {
        this.tur1Subject =tur1Subject;
    }
    public Label getTur1Teacher() {
        return tur1Teacher;
    }
    public void setTur1Teacher(Label tur1Teacher) {
        this.tur1Teacher = tur1Teacher;
    }
    public Label getTur1ClassRoom() {
        return tur1ClassRoom;
    }
    public void setTur1ClassRoom(Label tur1ClassRoom) {
        this.tur1ClassRoom = tur1ClassRoom;
    }
    public Label getTur1Memo() {
        return tur1Memo;
    }
    public void setTur1Memo(Label tur1Memo) {
        this.tur1Memo = tur1Memo;
    }

    public Label getFri1Subject() {
        return fri1Subject;
    }
    public void setFri1Subject(Label fri1Subject) {
        this.fri1Subject = fri1Subject;
    }
    public Label getFri1Teacher() {
        return fri1Teacher;
    }
    public void setFri1Teacher(Label fri1Teacher) {
        this.fri1Teacher = fri1Teacher;
    }

    public Label getFri1ClassRoom() {
        return fri1ClassRoom;
    }
    public void setFri1ClassRoom(Label fri1ClassRoom) {
        this.fri1ClassRoom = fri1ClassRoom;
    }
    public Label getFri1Memo() {
        return fri1Memo;
    }
    public void setFri1Memo(Label fri1Memo) {
        this.fri1Memo = fri1Memo;
    }

    public Label getMon2Subject() {
        return mon2Subject;
    }
    public void setMon2Subject(Label mon2Subject) {
        this.mon2Subject = mon2Subject;
    }
    public Label getMon2Teacher() {
        return mon2Teacher;
    }
    public void setMon2Teacher(Label mon2Teacher) {
        this.mon2Teacher = mon2Teacher;
    }
    public Label getMon2ClassRoom() {
        return mon2ClassRoom;
    }
    public void setMon2ClassRoom(Label mon2ClassRoom) {
        this.mon2ClassRoom = mon2ClassRoom;
    }
    public Label getMon2Memo() {
        return mon2Memo;
    }
    public void setMon2Memo(Label mon2Memo) {
        this.mon2Memo = mon2Memo;
    }

    public Label getTue2Subject() {
        return tue2Subject;
    }
    public void setTue2Subject(Label tue2Subject) {
        this.tue2Subject = tue2Subject;
    }
    public Label getTue2Teacher() {
        return tue2Teacher;
    }
    public void setTue2Teacher(Label tue2Teacher) {
        this.tue2Teacher = tue2Teacher;
    }
    public Label getTue2ClassRoom() {
        return tue2ClassRoom;
    }
    public void setTue2ClassRoom(Label tue2ClassRoom) {
        this.tue2ClassRoom = tue2ClassRoom;
    }
    public Label getTue2Memo() {
        return tue2Memo;
    }
    public void setTue2Memo(Label tue2Memo) {
        this.tue2Memo = tue2Memo;
    }

    public Label getWed2Subject() {
        return wed2Subject;
    }
    public void setWed2Subject(Label wed2Subject) {
        this.wed2Subject = wed1Subject;
    }
    public Label getWed2Teacher() {
        return wed2Teacher;
    }
    public void setWed2Teacher(Label wed2Teacher) {
        this.wed2Teacher = wed1Teacher;
    }
    public Label getWed2ClassRoom() {
        return wed2ClassRoom;
    }
    public void setWed2ClassRoom(Label wed2ClassRoom) {
        this.wed2ClassRoom = wed2ClassRoom;
    }
    public Label getWed2Memo() {
        return wed2Memo;
    }
    public void setWed2Memo(Label wed2Memo) {
        this.wed2Memo = wed2Memo;
    }

    public Label getTur2Subject() {
        return tur2Subject;
    }
    public void setTur2Subject(Label tur2Subject) {
        this.tur2Subject =tur1Subject;
    }
    public Label getTur2Teacher() {
        return tur2Teacher;
    }
    public void setTur2Teacher(Label tur2Teacher) {
        this.tur2Teacher = tur2Teacher;
    }
    public Label getTur2ClassRoom() {
        return tur2ClassRoom;
    }
    public void setTur2ClassRoom(Label tur2ClassRoom) {
        this.tur2ClassRoom = tur2ClassRoom;
    }
    public Label getTur2Memo() {
        return tur2Memo;
    }
    public void setTur2Memo(Label tur2Memo) {
        this.tur2Memo = tur2Memo;
    }

    public Label getFri2Subject() {
        return fri2Subject;
    }
    public void setFri2Subject(Label fri2Subject) {
        this.fri2Subject = fri2Subject;
    }
    public Label getFri2Teacher() {
        return fri2Teacher;
    }
    public void setFri2Teacher(Label fri2Teacher) {
        this.fri2Teacher = fri2Teacher;
    }

    public Label getFri2ClassRoom() {
        return fri2ClassRoom;
    }
    public void setFri2ClassRoom(Label fri2ClassRoom) {
        this.fri2ClassRoom = fri2ClassRoom;
    }
    public Label getFri2Memo() {
        return fri2Memo;
    }
    public void setFri2Memo(Label fri2Memo) {
        this.fri2Memo = fri2Memo;
    }

    public Label getMon3Subject() {
        return mon3Subject;
    }
    public void setMon3Subject(Label subject) {
        mon3Subject = subject;
    }
    public Label getMon3Teacher() {
        return mon3Teacher;
    }
    public void setMon3Teacher(Label teacher) {
        mon3Teacher = teacher;
    }
    public Label getMon3ClassRoom() {
        return mon3ClassRoom;
    }
    public void setMon3ClassRoom(Label classRoom) {
        mon3ClassRoom = classRoom;
    }
    public Label getMon3Memo() {
        return mon3Memo;
    }
    public void setMon3Memo(Label memo) {
        mon3Memo =memo;
    }

    public Label getTue3Subject() {
        return tue3Subject;
    }
    public void setTue3Subject(Label tue3Subject) {
        this.tue3Subject = tue3Subject;
    }
    public Label getTue3Teacher() {
        return tue3Teacher;
    }
    public void setTue3Teacher(Label tue3Teacher) {
        this.tue3Teacher = tue3Teacher;
    }
    public Label getTue3ClassRoom() {
        return tue3ClassRoom;
    }
    public void setTue3ClassRoom(Label tue3ClassRoom) {
        this.tue3ClassRoom = tue3ClassRoom;
    }
    public Label getTue3Memo() {
        return tue3Memo;
    }
    public void setTue3Memo(Label tue3Memo) {
        this.tue3Memo = tue3Memo;
    }

    public Label getWed3Subject() {
        return wed3Subject;
    }
    public void setWed3Subject(Label wed3Subject) {
        this.wed3Subject = wed3Subject;
    }
    public Label getWed3Teacher() {
        return wed3Teacher;
    }
    public void setWed3Teacher(Label wed3Teacher) {
        this.wed3Teacher = wed3Teacher;
    }
    public Label getWed3ClassRoom() {
        return wed3ClassRoom;
    }
    public void setWed3ClassRoom(Label wed3ClassRoom) {
        this.wed3ClassRoom = wed3ClassRoom;
    }
    public Label getWed3Memo() {
        return wed3Memo;
    }
    public void setWed3Memo(Label mon3Memo) {
        this.wed3Memo = wed3Memo;
    }

    public Label getTur3Subject() {
        return tur3Subject;
    }
    public void setTur3Subject(Label tur3Subject) {
        this.tur3Subject =tur3Subject;
    }
    public Label getTur3Teacher() {
        return tur3Teacher;
    }
    public void setTur3Teacher(Label tur3Teacher) {
        this.tur3Teacher = tur3Teacher;
    }
    public Label getTur3ClassRoom() {
        return tur3ClassRoom;
    }
    public void setTur3ClassRoom(Label classRoom) {
        tur3ClassRoom = classRoom;
    }
    public Label getTur3Memo() {
        return tur3Memo;
    }
    public void setTur3Memo(Label memo) {
        tur3Memo = memo;
    }

    public Label getFri3Subject() {
        return fri3Subject;
    }
    public void setFri3Subject(Label subject) {
        fri3Subject = subject;
    }
    public Label getFri3Teacher() {
        return fri3Teacher;
    }
    public void setFri3Teacher(Label Teacher) {
        fri3Teacher = Teacher;
    }

    public Label getFri3ClassRoom() {
        return fri3ClassRoom;
    }
    public void setFri3ClassRoom(Label classRoom) {
        fri3ClassRoom = classRoom;
    }
    public Label getFri3Memo() {
        return fri3Memo;
    }
    public void setFri3Memo(Label memo) {
        fri3Memo = memo;
    }
    
    public Label getMon4Subject() {
        return mon4Subject;
    }
    public void setMon4Subject(Label subject) {
        mon4Subject = subject;
    }
    public Label getMon4Teacher() {
        return mon4Teacher;
    }
    public void setMon4Teacher(Label teacher) {
        mon4Teacher = teacher;
    }
    public Label getMon4ClassRoom() {
        return mon4ClassRoom;
    }
    public void setMon4ClassRoom(Label classRoom) {
        mon4ClassRoom = classRoom;
    }
    public Label getMon4Memo() {
        return mon4Memo;
    }
    public void setMon4Memo(Label memo) {
        mon4Memo =memo;
    }

    public Label getTue4Subject() {
        return tue4Subject;
    }
    public void setTue4Subject(Label subject) {
        tue4Subject = subject;
    }
    public Label getTue4Teacher() {
        return tue4Teacher;
    }
    public void setTue4Teacher(Label teacher) {
        tue4Teacher = teacher;
    }
    public Label getTue4ClassRoom() {
        return tue4ClassRoom;
    }
    public void setTue4ClassRoom(Label classRoom) {
        tue4ClassRoom = classRoom;
    }
    public Label getTue4Memo() {
        return tue4Memo;
    }
    public void setTue4Memo(Label memo) {
        tue4Memo =memo;
    }

    public Label getWed4Subject() {
        return wed4Subject;
    }
    public void setWed4Subject(Label subject) {
        wed4Subject = subject;
    }
    public Label getWed4Teacher() {
        return wed4Teacher;
    }
    public void seWwed4Teacher(Label teacher) {
        wed4Teacher = teacher;
    }
    public Label getWed4ClassRoom() {
        return wed4ClassRoom;
    }
    public void setWed4ClassRoom(Label classRoom) {
        wed4ClassRoom = classRoom;
    }
    public Label getWed4Memo() {
        return wed4Memo;
    }
    public void setWed4Memo(Label memo) {
        wed4Memo =memo;
    }
    
    public Label getTur4Subject() {
        return tur4Subject;
    }
    public void setTur4Subject(Label subject) {
        tur4Subject = subject;
    }
    public Label getTur4Teacher() {
        return tur4Teacher;
    }
    public void setTur4Teacher(Label teacher) {
        tur4Teacher = teacher;
    }
    public Label getTur4ClassRoom() {
        return tur4ClassRoom;
    }
    public void setTur4ClassRoom(Label classRoom) {
        tur4ClassRoom = classRoom;
    }
    public Label getTur4Memo() {
        return tur4Memo;
    }
    public void setTur4Memo(Label memo) {
        tur4Memo =memo;
    }

    public Label getFri4Subject() {
        return fri4Subject;
    }
    public void setFri4Subject(Label subject) {
        fri4Subject = subject;
    }
    public Label getFri4Teacher() {
        return fri4Teacher;
    }
    public void setFri4Teacher(Label teacher) {
        fri4Teacher = teacher;
    }
    public Label getFri4ClassRoom() {
        return fri4ClassRoom;
    }
    public void setFri4ClassRoom(Label classRoom) {
        fri4ClassRoom = classRoom;
    }
    public Label getFri4Memo() {
        return fri4Memo;
    }
    public void setFri4Memo(Label memo) {
        fri4Memo =memo;
    }

    public Label getMon5Subject() {
        return mon5Subject;
    }
    public void setMon5Subject(Label subject) {
        mon5Subject = subject;
    }
    public Label getMon5Teacher() {
        return mon5Teacher;
    }
    public void setMon5Teacher(Label teacher) {
        mon5Teacher = teacher;
    }
    public Label getMon5ClassRoom() {
        return mon5ClassRoom;
    }
    public void setMon5ClassRoom(Label classRoom) {
        mon5ClassRoom = classRoom;
    }
    public Label getMon5Memo() {
        return mon5Memo;
    }
    public void setMon5Memo(Label memo) {
        mon5Memo =memo;
    }

    public Label getTue5Subject() {
        return tue5Subject;
    }
    public void setTue5Subject(Label subject) {
        tue5Subject = subject;
    }
    public Label getTue5Teacher() {
        return tue5Teacher;
    }
    public void setTue5Teacher(Label teacher) {
        tue5Teacher = teacher;
    }
    public Label getTue5ClassRoom() {
        return tue5ClassRoom;
    }
    public void setTue5ClassRoom(Label classRoom) {
        tue5ClassRoom = classRoom;
    }
    public Label getTue5Memo() {
        return tue5Memo;
    }
    public void setTue5Memo(Label memo) {
        tue5Memo =memo;
    }

    public Label getWed5Subject() {
        return wed5Subject;
    }
    public void setWed5Subject(Label subject) {
        wed5Subject = subject;
    }
    public Label getWed5Teacher() {
        return wed5Teacher;
    }
    public void seWwed5Teacher(Label teacher) {
        wed5Teacher = teacher;
    }
    public Label getWed5ClassRoom() {
        return wed5ClassRoom;
    }
    public void setWed5ClassRoom(Label classRoom) {
        wed5ClassRoom = classRoom;
    }
    public Label getWed5Memo() {
        return wed5Memo;
    }
    public void setWed5Memo(Label memo) {
        wed5Memo =memo;
    }
    
    public Label getTur5Subject() {
        return tur5Subject;
    }
    public void setTur5Subject(Label subject) {
        tur5Subject = subject;
    }
    public Label getTur5Teacher() {
        return tur5Teacher;
    }
    public void setTur5Teacher(Label teacher) {
        tur5Teacher = teacher;
    }
    public Label getTur5ClassRoom() {
        return tur5ClassRoom;
    }
    public void setTur5ClassRoom(Label classRoom) {
        tur5ClassRoom = classRoom;
    }
    public Label getTur5Memo() {
        return tur5Memo;
    }
    public void setTur5Memo(Label memo) {
        tur5Memo =memo;
    }

    public Label getFri5Subject() {
        return fri5Subject;
    }
    public void setFri5Subject(Label subject) {
        fri5Subject = subject;
    }
    public Label getFri5Teacher() {
        return fri5Teacher;
    }
    public void setFri5Teacher(Label teacher) {
        fri5Teacher = teacher;
    }
    public Label getFri5ClassRoom() {
        return fri5ClassRoom;
    }
    public void setFri5ClassRoom(Label classRoom) {
        fri5ClassRoom = classRoom;
    }
    public Label getFri5Memo() {
        return fri5Memo;
    }
    public void setFri5Memo(Label memo) {
        fri5Memo =memo;
    }
}
