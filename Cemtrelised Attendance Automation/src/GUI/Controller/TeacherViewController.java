/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import Be.Student;
import GUI.Model.UserModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    ObservableList<Student> studentList;
    
    public TeacherViewController()
    {
        studentList = userModel.getInstance().getStudents();
        userModel = UserModel.getInstance();
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
