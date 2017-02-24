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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class UserViewController implements Initializable {
    
    @FXML
    private Button testButton;
    
    private MainViewController mainViewController;
    @FXML
    private Label TestButton;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView Mogshot;
    
    private final ObservableList<Student> studentList;
    
    public UserViewController()
    {
        studentList = UserModel.getInstance().getStudents();
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
        TestButton.setText(studentList.get(5).getName());
    }    

}
