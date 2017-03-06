/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.CurrentUser;
import Be.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Emil
 */
public class StudentAttendanceViewController implements Initializable {
    
    @FXML
    private Label labelName;
    
    private CurrentUser currentUser;
    private Student student;

    public StudentAttendanceViewController() 
    {
        currentUser = CurrentUser.getInstance();
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
        labelInfoFromTeacherView();
    }

    public Student getStudent() {
        return student;
    }
    
    private void labelInfo()
    {
        if (!currentUser.getCurrentUserName().equals("t"))
        {
            labelName.setText("Student Username: " + currentUser.getCurrentUserName());
        }
    }
    
    private void labelInfoFromTeacherView()
    {
        labelName.setText("Student Name: " + student.getName());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelInfo();
    }    
}
