/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.CurrentUser;
import Be.Student;
import GUI.Model.UserModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    @FXML
    private Label testLabel;
     
    private final ObservableList<Student> studentList;
    private CurrentUser currentUser;
    private Student student;
    public ArrayList<String> attendanceDate;
    private static StudentAttendanceViewController INSTANCE;
    private TeacherViewController teacherViewController;
    
    public StudentAttendanceViewController() 
    {
        studentList = UserModel.getInstance().getStudents();
        attendanceDate = new ArrayList<String>();
        currentUser = CurrentUser.getInstance();
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
        labelInfoFromTeacherView();
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

    @FXML
    private void SetAsPresent(ActionEvent event) 
    {
        studentList.get(currentUser.getId()-1).setPresent(true);
    }
}
