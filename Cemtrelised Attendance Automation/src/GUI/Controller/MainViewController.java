/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import Be.Student;
import DAL.Users;
import GUI.Model.UserModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
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
    private PasswordField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Label publicMessageLabel;
    @FXML
    private TableView<Student> tableView;
    
    private Users createUsers = new Users();
    
    private Student student;
    
    private ArrayList<String> userList = new ArrayList<String>();
    
    private ObservableList<Student> listStudents;
    
    public MainViewController() throws FileNotFoundException
    {      
         listStudents = UserModel.getInstance().getStudents();
    }
    
    public ObservableList<Student> getListStudents()
    {
        return listStudents;
    }
    
    public PasswordField getPasswordField()
    {
        return passwordField;
    }
    
    public TextField getUserNameField()
    {
        return userNameField;
    }
    
    public Label getPublicMessageLabel()
    {
        return publicMessageLabel;
    }
    
    //This method use the signIn method when you press the "Enter" key.
    @FXML
    public void handleEnterPressed(KeyEvent event) throws IOException
    {
        if (event.getCode() == KeyCode.ENTER) 
        {
            signIn();
        }
    }
    
    @FXML
    private void signInButton(ActionEvent event) throws IOException 
    {
        signIn();
    }
    
    //This method is our signIn method which checks if there is user with the
    //user and password combination, and if there is it opens a new window for 
    //students.
    private void signIn()throws IOException
    {   
        for (Student s : listStudents)
        {
            if (s.getUsername().equals(userNameField.getText()) && (s.getPassword().equals(passwordField.getText())) && ("Teacher".equals(userNameField.getText())))
            {
                System.out.println("Warning teacher is in the gibson!");
                System.out.println("Logged in as " + userNameField.getText());
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/TeacherView.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Logged in as " + userNameField.getText());
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                userNameField.clear();
                passwordField.clear();
                publicMessageLabel.setText("");
                break;
            }
                else if (s.getUsername().equals(userNameField.getText()) && (s.getPassword().equals(passwordField.getText())))
            {
                System.out.println("Logged in!");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Logged in as " + userNameField.getText());
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                userNameField.clear();
                passwordField.clear();
                publicMessageLabel.setText("");
                break;
            }
                else if (userNameField.getText().isEmpty()) 
            {
                publicMessageLabel.setText("No Username Input!");
                break;
            }
                else if (passwordField.getText().isEmpty()) 
            {
                publicMessageLabel.setText("No Password Input!");
                break;
            }
                else if (s.getUsername().equals(userNameField.getText()) && !s.getPassword().equals(passwordField.getText()))
            {
                publicMessageLabel.setText("Wrong Password!");
                break;
            }
                else if (!s.getUsername().equals(userNameField.getText()))
            {
                publicMessageLabel.setText("No such user in the database!");
            }
            else
            {
                //DidNothing
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createUsers.createUsers();
    }   
}
