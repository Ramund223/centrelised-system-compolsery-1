/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.AuthenticationCheck;
import Be.Student;
import BLL.CreateUsers;
import BLL.CurrentUser;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    public Label publicMessageLabel;
    @FXML
    private TableView<Student> tableView;
    
    private CreateUsers createUsers;
    
    private Student student;
    
//    private ArrayList<String> userList = new ArrayList<String>();
    
    private ObservableList<Student> listStudents;
    
    private static MainViewController INSTANCE;
    
    private String userNameFieldName;
    
    private String passwordFieldName;
    
    private AuthenticationCheck authenticationCheck;
    
    private CurrentUser currentUser;
    
    public MainViewController()
    {      
         listStudents = UserModel.getInstance().getStudents();
         createUsers = CreateUsers.getInstance();
         currentUser = CurrentUser.getInstance();
         authenticationCheck = AuthenticationCheck.getInstance();
//         createUsers.createUsers();
    }
    
    public static synchronized MainViewController getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new MainViewController();
        }
        return INSTANCE;
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
    
    public String getUserName()
    {
        return userNameFieldName;
    }
    
    public String getPassword()
    {
        return passwordFieldName;
    }
    
    //This method is our signIn method which checks if there is user with the
    //user and password combination, and if there is it opens a new window for 
    //students.
    private void signIn()throws IOException
    {
        currentUser.setCurrentUserName(userNameField.getText());
        currentUser.setCurrentPassword(passwordField.getText());
        
        authenticationCheck.signIn();
        
        userNameField.clear();
        passwordField.clear();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createUsers.createUsers();
    }   
}
