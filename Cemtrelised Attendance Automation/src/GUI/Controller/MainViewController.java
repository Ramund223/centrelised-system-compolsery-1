/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


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
    @FXML
    private Label publicMessageLabel;
    
    private String nameField = null;
    
    private String passwordInputField = null;
    
    private String password = null;
    
    private int position = 0;
    
    ArrayList<String> userList = new ArrayList<String>();
    
    public MainViewController() throws FileNotFoundException
    {   
        try (Scanner scanner = new Scanner(new File((System.getProperty("user.home"))+"\\Documents\\GitHub\\centrelised-system-compolsery-1\\Cemtrelised Attendance Automation\\src\\DAL\\Users.txt"))) 
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
    
    @FXML
    public void handleEnterPressed(KeyEvent event) throws IOException
    {
        if (event.getCode() == KeyCode.ENTER) 
        {
            signIn();
        }
    }
            
    @FXML
    private void testButton(ActionEvent event) 
    {   
        
    } 
    
    @FXML
    private void signInButton(ActionEvent event) throws IOException 
    {
       signIn();
    }
    
    private void signIn()throws IOException
    {
        nameField = userNameField.getText();
        passwordInputField = passwordField.getText();
        position = userList.indexOf(nameField);
        System.out.println(position);
        password = userList.get(position+1);
        
        if (password.equals(passwordInputField) & !passwordInputField.equals("-") & !nameField.equals("-"))
        {
            System.out.println("Logged in!");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Logged in as " + userNameField.getText());
            stage.setScene(scene);
            stage.show();
            userNameField.clear();
            passwordField.clear();
        }
        else if (userNameField.getText().isEmpty()) 
        {
            publicMessageLabel.setText("No Username Input!");
            userNameField.clear();
            passwordField.clear();
        }
        else if (passwordField.getText().isEmpty()) 
        {
            publicMessageLabel.setText("No Password Input!");
        }
        else if (!userList.contains(userNameField.getText() + ""))
        {
            publicMessageLabel.setText("No such user in the database!");
            userNameField.clear();
            passwordField.clear();
        }
        else if (userList.contains(userNameField.getText() + ""))
        {
            publicMessageLabel.setText("Wrong Password!");
            passwordField.clear();
        }
        else
        {
            publicMessageLabel.setText("U BROKE IT DIDNT U?");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
