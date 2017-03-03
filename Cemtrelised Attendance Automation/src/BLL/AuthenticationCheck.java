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
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AuthenticationCheck {
    
    private static AuthenticationCheck INSTANCE;
    
    private ObservableList<Student> listStudents;
    
    private CurrentUser currentUser;
    
    public AuthenticationCheck()
    {
        listStudents = UserModel.getInstance().getStudents();
        currentUser = CurrentUser.getInstance();
    }
    
    public static synchronized AuthenticationCheck getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new AuthenticationCheck();
        }
        return INSTANCE;
    }
    
    public void signIn() throws IOException
    {
        for (Student s : listStudents)
        {   
            if (s.getUsername().equals(currentUser.getCurrentUserName()) && (s.getPassword().equals(currentUser.getCurrentPassword())) && ("Teacher".equals(currentUser.getCurrentUserName())))
            {
                System.out.println("works???");
                System.out.println("Warning teacher is in the gibson!");
                System.out.println("Logged in as " + currentUser.getCurrentUserName());
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/TeacherView.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Logged in as " + currentUser.getCurrentUserName());
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                break;
            }
                else if (s.getUsername().equals(currentUser.getCurrentUserName()) && (s.getPassword().equals(currentUser.getCurrentPassword())))
            {
                System.out.println("Logged in!");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
                Scene scene = new Scene(root);
                System.out.println("Logged in as " + currentUser.getCurrentUserName());
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                break;
            }
        }
    }
}
