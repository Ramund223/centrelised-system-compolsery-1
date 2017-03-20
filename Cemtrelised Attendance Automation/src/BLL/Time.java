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
    public final int timeAtNewDay = 0;
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
    
    // This method gets the instance of the time class and if it does not
    // exist it creates it
    public static synchronized Time getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Time();
        }
        return INSTANCE;
    }
   
    // This method is the timer class which runs every 60 secound.
    public void timer()
    {
        timer.scheduleAtFixedRate(timerTask = new TimerTask() 
        {
            public void run() 
            {
                timeCheck();
                checkIfNewDay();
            }
        }, 0, 60000);
    }
    
    /**
     This method updates the values of the variables, 
     currentTimeInDays checks how many days have passed since the 1. january 1970
     totalTime checks how many milliseconds have passed since 1. january 1970 up to today at 0:00
     currentTime checks how much time have passed in milliseconds this day only
    */
    public void timeCheck()
    {
        currentTimeInDays = (System.currentTimeMillis() + oneHourInMilliseconds)/dayInMilliseconds;  //Run every secound
//        System.out.println(currentTimeInDays + " timeInDays");
        totalTime = currentTimeInDays * dayInMilliseconds;                 //Run every secound
//        System.out.println(totalTime + " totalTime");
        currentTime = (System.currentTimeMillis() + oneHourInMilliseconds)-totalTime;         //Run every secound
//        System.out.println(currentTime + " currentTime");
    }
    
    /**
     This checks if a new school day have started and if we have just started the program
     If we just started the program the newDay boolean is set to true.
     If the time is between 6 am and 6 pm a new school day have started and people can sign in
    */
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
    
    
    // This checks if the newDay boolean is true and if it is the user is set as there that day
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
