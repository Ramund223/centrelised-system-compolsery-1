/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import GUI.Controller.MainViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class UserViewController implements Initializable {
    
    @FXML
    private Button testButton;
    
    private MainViewController MainViewController;
    
    public UserViewController()
    {
//        TODO ADDD TEST BUUTON
    }

    @FXML
    private void testButton(ActionEvent event) 
    {   
        System.out.println("LOl");
//        System.out.println(MainViewController.getUserName().toString());
//        if (MainViewController.getUserName().isEmpty())
//        {
//            System.out.println("WOLOLO");
//        }
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
