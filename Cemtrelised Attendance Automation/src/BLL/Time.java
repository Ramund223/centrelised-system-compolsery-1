/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Emil
 */

public class Time 
{
    private static Time INSTANCE;
    public Timer timer;
    public final int dayInMilliseconds = 86400000;
    public final int startOfSchoolDay = 21600000;
    public final int endOfSchoolDay = 64800000;
    public final int oneHourInMilliseconds = 3600000;
    public int timeAtNewDay = 0;
    public long timeAtStartOfProgram;
    public long totalTime;
    public long currentTime;
    public long currentTimeInDays;
    public boolean startOfProgram = true;
    public boolean newDay = false;
    public ArrayList<String> attendanceDate;
    private CurrentUser currentUser;
    public Date date;
    public TimerTask timerTask;
    
    public Time() 
    {
        timer = new Timer();
        date = new Date();
        currentUser = CurrentUser.getInstance();
        attendanceDate = new ArrayList<String>();
        
        timeAtStartOfProgram = (System.currentTimeMillis() + oneHourInMilliseconds)/dayInMilliseconds;
    }
    
    public static synchronized Time getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Time();
        }
        return INSTANCE;
    }
   
    public void timer()
    {
        timer.scheduleAtFixedRate(timerTask = new TimerTask() 
        {
            public void run() 
            {
                timeCheck();
                checkIfNewDay();
            }
        }, 0, 1000);
    }
    
    public void timeCheck()
    {
        currentTimeInDays = (System.currentTimeMillis() + oneHourInMilliseconds)/dayInMilliseconds;  //Run every secound
//        System.out.println(currentTimeInDays + " timeInDays");
        totalTime = currentTimeInDays * dayInMilliseconds;                 //Run every secound
//        System.out.println(totalTime + " totalTime");
        currentTime = (System.currentTimeMillis() + oneHourInMilliseconds)-totalTime;         //Run every secound
//        System.out.println(currentTime + " currentTime");
    }
    
    public void checkIfNewDay()
    {
        if (startOfProgram == true && currentTime>startOfSchoolDay && currentTime<endOfSchoolDay)
        {
            newDay = true;
            startOfProgram = false;
        }
        
        if(currentTimeInDays - timeAtStartOfProgram != timeAtNewDay && currentTime>startOfSchoolDay && currentTime<endOfSchoolDay) //need to check every secound to see if time has passed
        {
            newDay = true;
        }
        
        if (newDay == true)
        {
            Date nate = new Date();
            System.out.println(nate);
            
            timeAtStartOfProgram = (System.currentTimeMillis() + 3600000)/dayInMilliseconds;
            
            newDay = false;
        }
    }
    
//    public void newDay()
//    {
//        if(newDay == true) //Run everysecound
//        {
//            attendanceDate.add(currentUser.getCurrentUserName() + " signed in at school on " + date);
//            newDay = false;
//        }
//        else
//        {
//            System.out.println("You are already registrered for this day!");
//        }
//    }
    
    public void initialize(URL url, ResourceBundle rb) 
    {
    }
}
