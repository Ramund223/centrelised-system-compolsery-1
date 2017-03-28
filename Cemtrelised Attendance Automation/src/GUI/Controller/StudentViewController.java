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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class StudentViewController implements Initializable 
{
    @FXML
    private Button closeUser;   
    @FXML
    private Label nameLabel;
    @FXML
    private Label className;
    
    private final ObservableList<Student> studentList;
    
    private UserModel userModel;
    
    private AuthenticationCheck authenticationCheck;
    
    private CurrentUser currentUser;
    @FXML
    private Label presentLabel;
    @FXML
    private ImageView profilePic;
    
    private Image profilePicture;
    
    public StudentViewController()
    {
        studentList = UserModel.getInstance().getStudents();
        userModel = UserModel.getInstance();
        authenticationCheck = AuthenticationCheck.getInstance();
        currentUser = CurrentUser.getInstance();
    }

    ImageView imageView = new ImageView();
    
    public void setProfilePicture()
    {
         profilePicture = new Image("/Pictures/" + currentUser.getId() + ".png");
         profilePic.setImage(profilePicture);
    }
//    currentUser.getId()
    
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
        authenticationCheck.studentAttendanceView();
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        nameLabel.setText(currentUser.getCurrentUserName());
        className.setText(studentList.get(1).getClassroom());
        setProfilePicture();
    }    

    @FXML
    private void MarkAsPresent(ActionEvent event) 
    {
        studentList.get(currentUser.getId()-1).setPresent(true);
        presentLabel.setText("You are now marked as present");
    }
}
