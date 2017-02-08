/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Emil
 */

public class UserModel 
{
private static UserModel INSTANCE;
    
    private final ObservableList<Student> studentList;

    private UserModel() 
    {
        studentList = FXCollections.observableArrayList();
    }

    public void createStudent(int id, String classroom, String username, String password, String name)
    {
        Student student = new Student(name, id, classroom, username, password);
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
}
