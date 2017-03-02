/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Emil
 */

import Be.Student;
import GUI.Controller.MainViewController;
import GUI.Model.UserModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthenticationCheck {
    
//    private MainViewController mainViewController;
    
    private static AuthenticationCheck INSTANCE;
    
    private ObservableList<Student> listStudents;
    
    private CurrentUser currentUser;
    
    public AuthenticationCheck()
    {
        listStudents = UserModel.getInstance().getStudents();
        currentUser = CurrentUser.getInstance();
        
//        mainViewController = MainViewController.getInstance();
    }
    
    public static synchronized AuthenticationCheck getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new AuthenticationCheck();
        }
        return INSTANCE;
    }
    
    public void signIn()
    {
//        mainViewController = MainViewController.getInstance();
        for (Student s : listStudents)
        {
//            System.out.println("heh");
            if (s.getUsername().equals(currentUser.getCurrentUserName()))
            {
                System.out.println("DUr det???");
            }
//            mainViewController = null;
            
//            if (s.getUsername().equals(mainViewController.getUserName()))
//                    {
//                        System.out.println("works??");
//                    }
            
//            if (s.getUsername().equals(mainViewController.getUserNameField()) && (s.getPassword().equals(passwordField.getText())) && ("Teacher".equals(userNameField.getText())))
//            {
//                System.out.println("Warning teacher is in the gibson!");
//                System.out.println("Logged in as " + userNameField.getText());
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/TeacherView.fxml"));
//                Scene scene = new Scene(root);
//                stage.setTitle("Logged in as " + userNameField.getText());
//                stage.setScene(scene);
//                stage.setResizable(false);
//                stage.show();
//                userNameField.clear();
//                passwordField.clear();
//                publicMessageLabel.setText("");
//                break;
//            }
//                else if (s.getUsername().equals(userNameField.getText()) && (s.getPassword().equals(passwordField.getText())))
//            {
//                System.out.println("Logged in!");
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
//                Scene scene = new Scene(root);
//                stage.setTitle("Logged in as " + userNameField.getText());
//                stage.setScene(scene);
//                stage.setResizable(false);
//                stage.show();
//                userNameField.clear();
//                passwordField.clear();
//                publicMessageLabel.setText("");
//                break;
//            }
//                else if (userNameField.getText().isEmpty()) 
//            {
//                publicMessageLabel.setText("No Username Input!");
//                break;
//            }
//                else if (passwordField.getText().isEmpty()) 
//            {
//                publicMessageLabel.setText("No Password Input!");
//                break;
//            }
//                else if (s.getUsername().equals(userNameField.getText()) && !s.getPassword().equals(passwordField.getText()))
//            {
//                publicMessageLabel.setText("Wrong Password!");
//                break;
//            }
//                else if (!s.getUsername().equals(userNameField.getText()))
//            {
//                publicMessageLabel.setText("No such user in the database!");
//            }
//            else
//            {
//                //DidNothing
//            }
        }
    }
    
        
    // MAKE Authcingthign thoudh this to Main viwn contorller -> AucnChenk it check for auth and takes that data from mainview ctrol
}
