/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.StudentProfileModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class StudentProfileController implements Initializable
{

    @FXML
    private Label lblText;

    private StudentProfileModel model;
    @FXML
    private ImageView lblPicture;
    @FXML
    private VBox StudentProfile;
    

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
        if(event.isPrimaryButtonDown() && event.getClickCount()==1)
        {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("AttendanceSYS");

        stage.setScene(scene);
        stage.show();
        }
    }
    
}