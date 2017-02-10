/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Be.Student;
import GUI.Controller.MainViewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Emil
 */
public class AuthenticationCheck 
{
    
    MainViewController mainViewController;
    //if((userField.getText(), passwprdField.getText()) != null)
    public void signIn()throws IOException
    {
//        nameField = userNameField.getText();
//        passwordInputField = passwordField.getText();
//        position = userList.indexOf(nameField);
//        System.out.println(position);
//        password = userList.get(position+1);
        
        for (Student s : mainViewController.getListStudents())
        {
            if (s.getUsername().equals(mainViewController.getUserNameField().getText()) && (s.getPassword().equals(mainViewController.getPasswordField().getText())))
            {
            System.out.println("Logged in!");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Logged in as " + mainViewController.getUserNameField().getText());
            stage.setScene(scene);
            stage.show();
//            userNameField.clear();
//            passwordField.clear();
            mainViewController.getPublicMessageLabel().setText("");
            break;
            }
            else if (mainViewController.getUserNameField().getText().isEmpty()) 
            {
            mainViewController.getPublicMessageLabel().setText("No Username Input!");
            break;
            }
            else if (mainViewController.getPasswordField().getText().isEmpty()) 
            {
            mainViewController.getPublicMessageLabel().setText("No Password Input!");
            break;
            }
            else if (s.getUsername().equals(mainViewController.getUserNameField().getText()) && !s.getPassword().equals(mainViewController.getPasswordField().getText()))
            {
            mainViewController.getPublicMessageLabel().setText("Wrong Password!");
            break;
            }
            else if (!s.getUsername().equals(mainViewController.getUserNameField().getText()))
            {
            mainViewController.getPublicMessageLabel().setText("No such user in the database!");
            }
            else
            {
                //DidNothing
            }
        }
    }
}
