/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.AuthenticationCheck;
import Be.Student;
import DAL.Users;
import GUI.Model.UserModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
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
    private Label publicMessageLabel;
    
//    private String nameField = null;
    
//    private String passwordInputField = null;
    
//    private String password = null;
    
//    private int position = 0;
    
    private UserModel userModel;
    
    private Users createUsers = new Users();
    
    private Student student;
    
    private ArrayList<String> userList = new ArrayList<String>();
    
    private ObservableList<Student> listStudents;
    
    private String userName;
    
    @FXML
    private TableView<Student> tableView;
    
//    public String getUserName()
//    {
//        return nameField;
//    }
    
    private AuthenticationCheck authenticationCheck  = new AuthenticationCheck();
    
    @FXML
    private TableColumn<Student ,String> studentView;
    
    
    public MainViewController() throws FileNotFoundException
    {   
//        createUsers.createUsers();
        
         userModel = UserModel.getInstance();
         listStudents = UserModel.getInstance().getStudents();
         userName = UserModel.getInstance().getUserName();
        
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
    
    public void ping()
    {
        System.out.println("PING");
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
    
    @FXML
    public void handleEnterPressed(KeyEvent event) throws IOException
    {
        if (event.getCode() == KeyCode.ENTER) 
        {
            authenticationCheck.signIn();
        }
    }
            
    @FXML
    private void testButton(ActionEvent event) throws IOException 
    {   
//        userModel.getStudents().add(new Student(nameField, position, password, nameField, password)
//        userModel.getStudents().add(new Student("Carlos", 1, "21C", "Carlos99", "mango123"));
//        System.out.println(listStudents.get(0));
//        userModel.c
//        System.out.println(listStudents.toString());
//        System.out.println(student.getName());
//        authenticationCheck.mango();
//        authenticationCheck.pong();
        
        System.out.println(userModel.getUserName());
    } 
    
    @FXML
    private void signInButton(ActionEvent event) throws IOException 
    {
        userName = userNameField.getText();
//        nameField = userNameField.getText();
        userModel.setUserName(userName);
        
//        userModel.setPassword(passwordField.getText());
        
        
//       authenticationCheck.signIn();
    }
    
//    private void signIn()throws IOException
//    {
////        nameField = userNameField.getText();
////        passwordInputField = passwordField.getText();
////        position = userList.indexOf(nameField);
////        System.out.println(position);
////        password = userList.get(position+1);
//        
//        for (Student s : listStudents)
//        {
//            if (s.getUsername().equals(userNameField.getText()) && (s.getPassword().equals(passwordField.getText())))
//            {
//            System.out.println("Logged in!");
//            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/UserView.fxml"));
//            Scene scene = new Scene(root);
//            stage.setTitle("Logged in as " + userNameField.getText());
//            stage.setScene(scene);
//            stage.show();
////            userNameField.clear();
////            passwordField.clear();
//            publicMessageLabel.setText("");
//            break;
//            }
//            else if (userNameField.getText().isEmpty()) 
//            {
//            publicMessageLabel.setText("No Username Input!");
//            break;
//            }
//            else if (passwordField.getText().isEmpty()) 
//            {
//            publicMessageLabel.setText("No Password Input!");
//            break;
//            }
//            else if (s.getUsername().equals(userNameField.getText()) && !s.getPassword().equals(passwordField.getText()))
//            {
//            publicMessageLabel.setText("Wrong Password!");
//            break;
//            }
//            else if (!s.getUsername().equals(userNameField.getText()))
//            {
//            publicMessageLabel.setText("No such user in the database!");
//            }
//            else
//            {
//                //DidNothing
//            }
//        }
//    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        studentView.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getName()));
        tableView.setItems(userModel.getStudents());
        
//        userModel.createStudent(6, "C20", "a", "a", "test");
//        userModel.createStudent(1, "C20", "Carlos93", "password", "Carlos Abukat");
//        userModel.createStudent(2, "C20", "MagicMike99", "password", "Magic Mike");
//        userModel.createStudent(3, "C20", "IceFrog29", "password", "Ice Frog");
//        userModel.createStudent(4, "C20", "LøgDrengen99", "password", "Løg Drengen");
//        userModel.createStudent(5, "C20", "Treant6", "password", "Treant Six");

        createUsers.createUsers();
        
    }   
}
