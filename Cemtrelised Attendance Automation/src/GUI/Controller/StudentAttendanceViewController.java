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
    private Calendar calendar;
    public int newDate = 0;
    public int oldDate = 0;
    public boolean newDay = true;
    public ArrayList attendanceDate;
    public Date date = new Date();
    
    public StudentAttendanceViewController() 
    {
        attendanceDate = new ArrayList();
        oldDate = (int)(System.currentTimeMillis()/86400000);
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
     
    private boolean startUpday = true; 
    
    @FXML
    private void testButton(ActionEvent event) throws IOException
    {
//        attendanceDate.add(currentUser.getCurrentUserName() + " signed in at school on " + date);
//        System.out.println(attendanceDate);
//        attendanceDate.add(" signed in at school on ");
//        System.out.println(attendanceDate);
//        System.out.println();
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime());
//        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
//        System.out.println(timeStamp);
        
//        System.out.println(date);
        
        
//        System.out.println(System.currentTimeMillis());
        
//        System.out.println(System.currentTimeMillis()/86400000-17232);        

      
        
        if(System.currentTimeMillis()/86400000-oldDate != newDate)
        {
            newDay = true;
            oldDate = (int)(System.currentTimeMillis()/86400000);
            System.out.println("not true");
        }
        else
        {
//            newDay = false;
            System.out.println("true");
        }
        
        if(newDay == true)
        {
            attendanceDate.add(currentUser.getCurrentUserName() + " signed in at school on " + date);
            newDay = false;
        }
        else
        {
            System.out.println("You are already registrered for this day!");
        }
        
//        System.out.println(attendanceDate);
        
//        String datetime1 = "05:22:34";
//        String datetime2 = "05:23:28";
//
//        DateTimeFormatter format = DateTimeFormat.forPattern("HH:mm:ss");
//        DateTime time1 = format.parseDateTime(datetime1);
//        DateTime time2 = format.parseDateTime(datetime2);
//        Minutes Interval = Minutes.minutesBetween(time1, time2);
//        Minutes minInterval = Minutes.minutes(20);

//        System.out.println(DateTime.now());
//        if(Interval.isGreaterThan(minInterval))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
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
