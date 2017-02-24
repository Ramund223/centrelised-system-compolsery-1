/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Be.Student;
import GUI.Controller.MainViewController;
import GUI.Model.UserModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.ObservableList;
/**
 *
 * @author Emil
 */
public class AuthenticationCheck 
{
    
    private static MainViewController mainViewController;
    private ObservableList<Student> listStudents;
    
    public AuthenticationCheck()
    {
        listStudents = UserModel.getInstance().getStudents();
    }
    
    public void mango()
    {
        System.out.println("YOU GOT ME!");
    }
    
    public void pong()
    {
        System.out.println("PONG");
        mainViewController.ping();
    }
    
    public static synchronized MainViewController getInstance() throws FileNotFoundException
        {
            if(mainViewController == null)
            {
                mainViewController = new MainViewController();
            }
            return mainViewController;
        }
    
    public void signIn()throws IOException
    {
        for (Student s : listStudents)
        {
            if (s.getUsername().equals(mainViewController.getUserNameField().getText()) && (s.getPassword().equals(mainViewController.getPasswordField().getText())))
            {
                System.out.println("IF");
            }
            else
            {
                System.out.println("else");
            }
        }
    }
}
