package so.edu.hodmas.ims.hucims.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ObservableList<Student> studentsList;

    @FXML
    private TableView<Student> students_table;

    @FXML
    private TableColumn<Student, Long> id;

    @FXML
    private TableColumn<Student, String> dept_name;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, Double> tot_cred;

    private void getStudentsData(){
        try {
            Database db = new Database("huc","Password123!","myuniversity");

            Connection conn =  db.connect();
            Statement stm = conn.createStatement();

            ResultSet rst = stm.executeQuery("SELECT * from student;");


            while(rst.next()){

                Student student = new Student(
                        rst.getLong("ID"),
                        String.valueOf(rst.getNString("name")),
                        String.valueOf(rst.getNString("dept_name")),
                        rst.getDouble("tot_cred")
                        );

                students.add(student);
            }


            studentsList =  FXCollections.observableArrayList(students);

            id.setCellValueFactory(new PropertyValueFactory<Student,Long>("id"));
            name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
            dept_name.setCellValueFactory(new PropertyValueFactory<Student,String>("dept_name"));
            tot_cred.setCellValueFactory(new PropertyValueFactory<Student,Double>("tot_cred"));

            students_table.setItems(studentsList);

        }catch (SQLException exp){
            System.out.println("ERROR:");
            System.out.println(exp.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getStudentsData();

    }
}
