/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Be.Student;
import DAL.Users;
import GUI.Model.UserModel;
import GUI.Controller.TeacherLoginController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Emil
 */

public class CreateUsers 
{
    private Users createUsers;
    
    private static CreateUsers INSTANCE;
    
    private ObservableList<Student> listStudents;
    
    private Users users;
    
    public CreateUsers()
    {
        users = new Users();
        createUsers = Users.getInstance();
        listStudents = UserModel.getInstance().getStudents(); 
    }
    
    public static synchronized CreateUsers getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new CreateUsers();
        }
        return INSTANCE;
    }
    
    public void createUsers()
    {
        createUsers.createUsers();
    }
    
    public List<Student> getUsers() throws SQLException, IOException
    {
        return users.getUsers();
    }
}
