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
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author skole
 */
public class MainViewController implements Initializable {

    @FXML
    private ImageView Logo;
    @FXML
    private Button SignIn;
    @FXML
    private PasswordField Password;
    @FXML
    private Button testButton;

    ArrayList<String> list = new ArrayList<String>();
    
    public MainViewController() throws FileNotFoundException
    {
//        try (Scanner s = new Scanner(new File("user.home")+"\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\UserNames.txt")) 
//        try (Scanner s = new Scanner(new File("user.home")+"\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\UserNames.txt")) 
//        {
//            while (s.hasNext())
//            {
//                list.add(s.next());
//            }   
//        }
//    }
//        try (Scanner scanner = new Scanner(new File("C:\\Users\\EmilArentoft\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\UserNames.txt"))) {
        try (Scanner scanner = new Scanner(new File((System.getProperty("user.home"))+"\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\UserNames.txt"))) {

            while (scanner.hasNext())
            {
                list.add(scanner.next());
            }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 }
    
    @FXML
    private void testButton(ActionEvent event) 
    {
        System.out.println(list);
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
