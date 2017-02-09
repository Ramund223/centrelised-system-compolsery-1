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
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private MainViewController mainViewController;
    
    public UserViewController()
    {
//        TODO ADDD TEST BUUTON
    }

    @FXML
    private void testButton(ActionEvent event) 
    {   
//        try {
            //        System.out.println("LOl");
//        System.out.println(mainViewController.getUserName().toString());
//        if (mainViewController.getUserName().isEmpty())
//        {
//            System.out.println("WOLOLO");
//        }
//    mainViewController = new MainViewController();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(UserViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(mainViewController.getUserName());
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
