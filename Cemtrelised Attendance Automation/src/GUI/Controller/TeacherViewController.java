/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.AuthenticationCheck;
import BLL.CurrentUser;
import Be.Student;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nicolai
 */
public class TeacherViewController implements Initializable {

    @FXML
    private TableView<Student> tableAttedance;
    @FXML
    private TableColumn<Student, String> tableStudent;
    @FXML
    private TableColumn<Student, String> tablePresent;
    private UserModel userModel;
    private AuthenticationCheck authenticationCheck;
    private CurrentUser currentUser;
    
    private static TeacherViewController INSTANCE;
    
    private ObservableList<Student> studentList;
    
    public TeacherViewController()
    {
        studentList = userModel.getInstance().getStudents();
        userModel = UserModel.getInstance();
        authenticationCheck = AuthenticationCheck.getInstance();
        currentUser = CurrentUser.getInstance();
    }
   
    public static synchronized TeacherViewController getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new TeacherViewController();
        }
        return INSTANCE;
    }
    
    @FXML
    private void mousePressedOnTableView(MouseEvent event) throws IOException
    {
        if(event.isPrimaryButtonDown() && event.getClickCount()==2)
        {
            currentUser.setCurrentSelectedUser(tableAttedance.getSelectionModel().getSelectedItem().getName());
            Student selectedStudent = tableAttedance.getSelectionModel().getSelectedItem();
            authenticationCheck.teacherStudentAttendanceView(selectedStudent);
        }
    }

    public TableColumn<Student, String> getTableStudent() {
        return tableStudent;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        tableAttedance.setItems(userModel.getStudents());
        tableStudent.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getName()));
        tablePresent.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getPresent()));
    }    
    
}
