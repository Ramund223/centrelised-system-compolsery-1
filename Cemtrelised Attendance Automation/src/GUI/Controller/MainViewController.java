/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class MainViewController implements Initializable {

    @FXML
    private ImageView logoView;
    @FXML
    private Button signInButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button testButton;
    @FXML
    private TextField userNameField;

    private int position = 0;
    
    ArrayList<String> userList = new ArrayList<String>();
    
    public MainViewController() throws FileNotFoundException
    {
        try (Scanner scanner = new Scanner(new File((System.getProperty("user.home"))+"\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\UserNames.txt"))) 
        {

            while (scanner.hasNext())
            {
                userList.add(scanner.next());
            }

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
 }
    String nameField = null;
    
    String passwordInputField = null;
    
    String password = null;
    
    @FXML
    private void testButton(ActionEvent event) 
    {
//        System.out.println(userList);
//        position = userList.indexOf("MagicMike");
        System.out.println(position);
//        userNameField.getText();
        
         nameField = userNameField.getText();
         position = userList.indexOf(nameField);
//         System.out.println(userList.get(position+1));
        if (passwordInputField == userList.get(position+1))
        {
            //TODO
        }
    } 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void signin(ActionEvent event) {
    }
    
}