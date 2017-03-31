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
import GUI.Controller.StudentAttendanceViewController;
import GUI.Controller.TeacherViewController;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AuthenticationCheck {
    
    private static AuthenticationCheck INSTANCE;
    
    private ObservableList<Student> listStudents;
    
    private CurrentUser currentUser;
    
    private UserModel userModel;
    
    
    private AuthenticationCheck authenticationCheck;
    
    private StudentAttendanceViewController studentAttendanceViewController;
    
    @FXML
    private TableView<Student> tableAttedance;
    
    public AuthenticationCheck()
    {
        listStudents = UserModel.getInstance().getStudents();
        currentUser = CurrentUser.getInstance();
        userModel = UserModel.getInstance();
        studentAttendanceViewController = StudentAttendanceViewController.getInstance();
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
//            if (s.getUsername().equals(currentUser.getCurrentUserName()) && (s.getPassword().equals(currentUser.getCurrentPassword())) && ("Teacher".equals(currentUser.getCurrentUserName())))
            if (currentUser.getCurrentUserName().equals("t") && (currentUser.getCurrentPassword().equals("t")))
            {
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
//                else if (s.getUsername().equals(currentUser.getCurrentUserName()) && (s.getPassword().equals(currentUser.getCurrentPassword())))
//            {
//                currentUser.setId(s.getId());
//                System.out.println("Logged in!");
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/StudentView.fxml"));
//                Scene scene = new Scene(root);
//                stage.setTitle("Logged in as " + currentUser.getCurrentUserName());
//                stage.setScene(scene);
//                stage.setResizable(false);
//                stage.show();
//                break;
//            }
        }
    }
    
    public void studentAttendanceView() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/StudentAttendanceView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student: " + currentUser.getCurrentUserName());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }
    
    public void teacherStudentAttendanceView (Student student) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/StudentAttendanceView.fxml"));
        Parent root = loader.load();
        StudentAttendanceViewController studentAttendanceViewController = loader.getController();
        studentAttendanceViewController.setStudent(student);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Student: " + currentUser.getCurrentSelectedUser());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
    
     /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) 
    {
        tableAttedance.setItems(userModel.getStudents());
    }
    
}
