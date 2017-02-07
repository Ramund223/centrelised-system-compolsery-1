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
//    Student(String name, int id, String classroom, String username, String password) 
    //This method create the teams and add the team to the team observablelist.
    public void createStudent(int id, String classroom, String username, String password, String name)
    {
//        ublic Team(int id, int goals, int points, String name) 
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
    
    public ObservableList<Student> getTeam()
    {
        return studentList;
    }
    
}
