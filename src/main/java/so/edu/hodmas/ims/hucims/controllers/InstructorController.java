package so.edu.hodmas.ims.hucims.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import so.edu.hodmas.ims.hucims.Database;
import so.edu.hodmas.ims.hucims.HUCIMSApplication;
import so.edu.hodmas.ims.hucims.models.Instructor;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InstructorController implements Initializable {


    private ArrayList<Instructor> instructors = new ArrayList<>();
    private ObservableList<Instructor> instructorsObList;

    @FXML
    private TableView<Instructor> instructor_table;

    @FXML
    private TableColumn<Instructor, String> dept_name;

    @FXML
    private TableColumn<Instructor, Long> id;

    @FXML
    private TableColumn<Instructor, String> name;

    @FXML
    private TableColumn<Instructor, Double> salary;
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

    private void getInstructors(){
        try {
            Database db = new Database("huc","Password123!","myuniversity");

            Connection conn =  db.connect();
            Statement stm = conn.createStatement();

            ResultSet rst = stm.executeQuery("SELECT * from instructor;");


            while(rst.next()){

                Instructor instructor = new Instructor(
                        rst.getLong("ID"),
                        rst.getString("name"),
                        rst.getString("dept_name"),
                        rst.getDouble("salary")
                );

                instructors.add(instructor);
            }


            instructorsObList =  FXCollections.observableArrayList(instructors);

            id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            dept_name.setCellValueFactory(new PropertyValueFactory<>("dept_name"));
            salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

            instructor_table.setItems(instructorsObList);

        }catch (SQLException exp){
            System.out.println("ERROR:");
            System.out.println(exp.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getInstructors();
    }
}
