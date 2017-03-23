/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author Emil
 */

public class UserModel 
{
    
    public String userName;
    public String password;
    public boolean present;
    public int id;
    public Image image;
    
private static UserModel INSTANCE;
    
    private final ObservableList<Student> studentList;

    private UserModel() 
    {
        studentList = FXCollections.observableArrayList();
    }

    //This method create the student and add the student to the student observablelist.
    public void createStudent(int id, String classroom, String username, String password, String name, boolean present, Image image)
    {
        Student student = new Student(name, id, classroom, username, password, present, image);
        studentList.add(student);
    }
    
    public static synchronized UserModel getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new UserModel();
        }
        return INSTANCE;
    }
    
    public ObservableList<Student> getStudents()
    {
        return studentList;
    }
    
    public void setUserName(String username) 
    {
        this.userName = userName;
    }
    
    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public String getUserName() 
    {
        return userName;
    }
    
    public String getPassword() 
    {
        return password;
    }
    
    public void setPresent (boolean present)
    {
        this.present = present;
    }
    
    public int getId ()
    {
        return id;
    }
    
    public void setId (int id)
    {
        this.id = id;
    }
    
    public Image getImage ()
    {
        return image;
    }
    
    public void setImage (Image image)
    {
        this.image = image;
    }
}
