/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.CurrentUser;
import Be.Student;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * FXML Controller class
 *
 * @author Emil
 */
public class StudentAttendanceViewController implements Initializable {
    
    @FXML
    private Label labelName;
    @FXML
    private Label testLabel;
    @FXML
    private Button testButten;
    
    private CurrentUser currentUser;
    private Student student;
    public ArrayList<String> attendanceDate;
    private static StudentAttendanceViewController INSTANCE;
    
    public StudentAttendanceViewController() 
    {
        attendanceDate = new ArrayList<String>();
        currentUser = CurrentUser.getInstance();
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
        labelInfoFromTeacherView();
    }

//    public Student getStudent() {
//        return student;
//    }
    
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
    
    public static synchronized StudentAttendanceViewController getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new StudentAttendanceViewController();
        }
        return INSTANCE;
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
