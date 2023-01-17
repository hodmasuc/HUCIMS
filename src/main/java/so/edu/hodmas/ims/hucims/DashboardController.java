package so.edu.hodmas.ims.hucims;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label students_lbl;
    @FXML
    private Label depart_lbl;
    @FXML
    private Label courses_lbl;
    @FXML
    private Label instructors_lbl;
    @FXML
    public void OpenNewStage(ActionEvent event) throws IOException {
        Button btn = ((Button)event.getSource());
        Stage stage = (Stage) btn.getScene().getWindow();
        String namefx = btn.getText().toLowerCase();
        FXMLLoader fxmlLoader = new FXMLLoader(HUCIMSApplication.class.getResource("views/"+namefx+".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);
        stage.setTitle(btn.getText() + " HUC-IMS");
        stage.setScene(scene);
    }

    private void getCount(){
        // Connection
        try {
            Database db = new Database("huc","Password123!","myuniversity");
            Connection conn =  db.connect();
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT count(dept_name) as count from department;");
            if(rst.next()){
                String count = String.valueOf(rst.getInt(1));
                depart_lbl.setText(count);
            }
            rst = stm.executeQuery("SELECT count(name) as count from student;");
            if(rst.next()){
                String count = String.valueOf(rst.getInt(1));
                students_lbl.setText(count);
            }
            rst = stm.executeQuery("SELECT count(title) as count from course;");
            if(rst.next()){
                String count = String.valueOf(rst.getInt(1));
                courses_lbl.setText(count);
            }

            rst = stm.executeQuery("SELECT count(name) as count from instructor;");
            if(rst.next()){
                String count = String.valueOf(rst.getInt(1));
                instructors_lbl.setText(count);
            }
        }catch (SQLException exp){
            System.out.println("ERROR:");
            System.out.println(exp.getMessage());
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCount();
    }
}