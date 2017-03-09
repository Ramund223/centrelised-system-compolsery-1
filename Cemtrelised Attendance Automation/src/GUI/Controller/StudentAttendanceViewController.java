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
    private Calendar calendar;
    public int timeAtNewDay = 0;
    public long currentTimeInDays;
    public boolean newDay = true;
    public ArrayList<String> attendanceDate;
    public Date date = new Date();
    public final int dayInMilliseconds = 86400000;
    public final int startOfSchoolDay = 18000000;
    public final int endOfSchoolDay = 61200000;
    public long timeAtStartOfProgram;
    private static StudentAttendanceViewController INSTANCE;
    public Timer timer;
    
    public StudentAttendanceViewController() 
    {
        attendanceDate = new ArrayList<String>();
//        currentTimeInDays = (int)(System.currentTimeMillis()/86400000);
        timeAtStartOfProgram = System.currentTimeMillis()/dayInMilliseconds; // Run once at start of program
        currentUser = CurrentUser.getInstance();
//        timer = new Timer();
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
    
    public long totalTime;
    public long currentTime;
            
    @FXML
    private void testButton2(ActionEvent event) throws IOException
    {
//        currentTimeInDays = 1;
        
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            @Override
            public void run() 
            {
                System.out.print("I would be called every 1 second");
            }
        }, 0, 1000);
    }
    
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

      /**
       * Its take the current time in miliseconds(from aground when the mothos was invented)
       * and diverde it by the milisecounds it takes for a day to pass and the minus it
       * with oldDate which is all the days passed since jan 1 1970 and then check
       * if its the same as newDate which is 0 so when a day passed oldDate is changed to 1
       * which make the "if" statement true and that makes the newDay boolean true.
       */
        
//        timeAtStartOfProgram = System.currentTimeMillis()/dayInMilliseconds; // Run once at start of program
        currentTimeInDays = System.currentTimeMillis()/dayInMilliseconds;  //Run every secound
//        System.out.println(currentTimeInDays + "timeInDays");
        totalTime = currentTimeInDays * dayInMilliseconds;                 //Run every secound
//        System.out.println(totalTime + "totalTime");
        currentTime = System.currentTimeMillis()-totalTime;         //Run every secound
//        System.out.println(currentTime + "currentTime");
        
//        if(System.currentTimeMillis()/dayInMilliseconds-currentTimeInDays != timeAtNewDay && currentTime>startOfSchoolDay && currentTime<endOfSchoolDay) //need to check every secound to see if time has passed
        if(currentTimeInDays - timeAtStartOfProgram != timeAtNewDay)
        {
//            currentTimeInDays = (int)(System.currentTimeMillis()/dayInMilliseconds);
//            currentTimeInDays = System.currentTimeMillis()/dayInMilliseconds;          //Run at start of program
//            totalTime = currentTimeInDays*dayInMilliseconds;
//            currentTime = System.currentTimeMillis()-totalTime;

            newDay = true;
            timeAtStartOfProgram = System.currentTimeMillis()/dayInMilliseconds;
            System.out.println("not true");
        }
        else
        {
//            newDay = false;
            System.out.println("true");
        }
        
        /**
         * if newDay is true the student is registred in a arraylist and newDay
         * is set to false so he can only be registred once a day.
         */
        if(newDay == true) //Run everysecound
        {
            attendanceDate.add(currentUser.getCurrentUserName() + " signed in at school on " + date);
            newDay = false;
        }
        else
        {
            System.out.println("You are already registrered for this day!");
        }
        testLabel.setText(attendanceDate.get(0) + "");
        
        
//        currentTimeInDays = System.currentTimeMillis()/dayInMilliseconds;  //Run every secound
//        System.out.println(currentTimeInDays + "currentTimeInDays");
//        totalTime = currentTimeInDays * dayInMilliseconds;                 //Run every secound
//        System.out.println(totalTime + "totalTime");
//        currentTime = System.currentTimeMillis()-totalTime;         //Run every secound
//        System.out.println(currentTime + "currentTime");
        
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
        timer = new Timer();
    }    
}
