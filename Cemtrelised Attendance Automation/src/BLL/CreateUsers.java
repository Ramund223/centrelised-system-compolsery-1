/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Be.Student;
import DAL.Users;
import GUI.Model.UserModel;
import javafx.collections.ObservableList;

/**
 *
 * @author Emil
 */

public class CreateUsers 
{
    private Users createUsers;
    
    private static CreateUsers INSTANCE;
    
    private ObservableList<Student> listStudents;
    
    public CreateUsers()
    {
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
}
