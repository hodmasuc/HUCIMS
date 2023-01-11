package so.edu.hodmas.ims.hucims.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import so.edu.hodmas.ims.hucims.Database;
import so.edu.hodmas.ims.hucims.models.Student;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {

    private ArrayList<Student> students = new ArrayList<>();

    @FXML
    private TableView students_table;

    private void getStudentsData(){
        try {
            Database db = new Database("huc","Password123!","myuniversity");
            Connection conn =  db.connect();
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * as count from student limit 20;");
            while(rst.next()){
                Student student = new Student(
                        rst.findColumn("ID"),
                        String.valueOf(rst.findColumn("name")),
                        String.valueOf(rst.findColumn("dept_name")),
                        rst.findColumn("tot_cred")
                        );
                students.add(student);
            }

        }catch (SQLException exp){
            System.out.println("ERROR:");
            System.out.println(exp.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
