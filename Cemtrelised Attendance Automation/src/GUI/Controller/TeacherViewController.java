/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import Be.Student;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nicolai
 */
public class TeacherViewController implements Initializable {

    @FXML
    private TableView<Student> TableAttedance;
    @FXML
    private TableColumn<Student, String> TableStudent;
    @FXML
    private TableColumn<Student, String> TablePresent;
    private UserModel userModel;
    
    private ObservableList<Student> studentList;
    
    public TeacherViewController()
    {
        studentList = userModel.getInstance().getStudents();
        userModel = UserModel.getInstance();
    }
   
    @FXML
    private void mousePressedOnTableView(MouseEvent event) throws IOException
    {
        if(event.isPrimaryButtonDown() && event.getClickCount()==2)
        {
            Student selectedStudent = TableAttedance.getSelectionModel().getSelectedItem();
            studentAttendanceView(selectedStudent);
        }
    }
    
    private void studentAttendanceView(Student student) throws IOException
    {
        Stage primStage = (Stage)TableAttedance.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/StudentAttendanceView.fxml"));
        Parent root = loader.load();
        StudentAttendanceViewController studentAttendanceViewController = loader.getController();
        studentAttendanceViewController.setStudent(student);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Student: " + TableAttedance.getSelectionModel().getSelectedItem());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        TableAttedance.setItems(userModel.getStudents());
        TableStudent.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getName()));
    }    
    
}
