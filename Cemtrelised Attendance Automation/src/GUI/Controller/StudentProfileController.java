/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.StudentProfileModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    private Label lblPicture;
    

    public StudentProfileModel getModel()
    {
        return model;
    }

    public void setModel(StudentProfileModel model)
    {
        this.model = model;
        lblPicture.textProperty().bind(model.textProperty());
        lblText.textProperty().bind(model.textProperty());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}