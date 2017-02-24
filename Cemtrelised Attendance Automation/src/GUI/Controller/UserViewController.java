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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class UserViewController implements Initializable 
{
    @FXML
    private Button closeUser;
    
    @FXML
    private Label nameLabel;
    @FXML
    private Label className;
    
    private final ObservableList<Student> studentList;
    
    public UserViewController()
    {
        studentList = UserModel.getInstance().getStudents();
    }
    
    //This closes the user window window
    @FXML
    private void userClose(ActionEvent event) 
    {
        Stage stage = (Stage) closeUser.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        nameLabel.setText(studentList.get(1).getName());
        className.setText(studentList.get(1).getClassroom());
    }    
}
