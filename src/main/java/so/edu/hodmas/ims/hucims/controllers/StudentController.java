package so.edu.hodmas.ims.hucims.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import so.edu.hodmas.ims.hucims.models.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    Student student;


    public StudentController(Student student){
        this.student = student;
    }


    @FXML
    Label stdname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       stdname.setText(student.getName());
    }
}
