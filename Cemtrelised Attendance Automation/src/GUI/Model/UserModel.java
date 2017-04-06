/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.Student;
import DAL.StudentDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;
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
    public String image;
    
private static UserModel INSTANCE;
    
    private final ObservableList<Student> studentList;

    private StudentDAO studentDAO;
    
    private UserModel() throws SQLException, IOException 
    {
        studentDAO = StudentDAO.getInstance();
//        studentList = FXCollections.observableArrayList();
//        userModel = FXCollections.observableArrayList(allStudents);
        studentList = FXCollections.observableArrayList(studentDAO.getAllStudents());
    }

    //This method create the student and add the student to the student observablelist.
    public void createStudent(int id, String school, String classroom, String name, boolean present, String image)
    {
        Student student = new Student(name, id, school ,classroom, present, image);
        studentList.add(student);
    }
    
    public static synchronized UserModel getInstance() throws IOException, SQLException
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
    
    public String getImage ()
    {
        return image;
    }
    
    public void setImage (String image)
    {
        this.image = image;
    }
}
