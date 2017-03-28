/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.CurrentUser;
import Be.Student;
import GUI.Model.StudentProfileModel;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author pgn
 */
public class MainViewStudentProfileController implements Initializable
{

    @FXML
    private Label lblText;

    private StudentProfileModel model;
    @FXML
    private ImageView lblPicture;
    @FXML
    private VBox StudentProfile;
    
    private ObservableList<Student> listStudents;
    
    private CurrentUser currentUser;
    
    public MainViewStudentProfileController()
    {
        currentUser = CurrentUser.getInstance();
        listStudents = UserModel.getInstance().getStudents();
    }
    
    public StudentProfileModel getModel()
    {
        return model;
    }

    public void setModel(StudentProfileModel model)
    {
        this.model = model;
        lblPicture.imageProperty().bind(model.imageProperty());
        lblText.textProperty().bind(model.textProperty());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    

    @FXML
    private void MousePressedOnImage(MouseEvent event) throws IOException
    {
        currentUser.setCurrentUserName(lblText.getText());
        for (Student a : listStudents)
        {
            if(event.isPrimaryButtonDown() && event.getClickCount()==1 && (a.getName().equals(currentUser.getCurrentUserName())))
            {
        currentUser.setId(a.getId());
        System.out.println("Logged in!");
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/StudentView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Logged in as " + currentUser.getCurrentUserName());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        break;
            }
       
        }
    }
    
    
    
    
    
    
    
   
        
}