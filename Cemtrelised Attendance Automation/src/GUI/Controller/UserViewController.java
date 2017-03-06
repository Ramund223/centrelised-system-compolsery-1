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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
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
    @FXML
    private TableView<Student> TableAttedance;
    
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
    
    @FXML
    private void studentAttendanceView(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/StudentAttendanceView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student Attendance View");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();   
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
