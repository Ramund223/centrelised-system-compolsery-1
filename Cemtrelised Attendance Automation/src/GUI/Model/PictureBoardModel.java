/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BLL.CreateUsers;
import Be.PostIt;
import Be.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 *
 * @author pgn
 */
public class PictureBoardModel
{
    Image image;

    private static PictureBoardModel INSTANCE;

    private ObservableList<StudentProfileModel> allPostIts;
    
    private CreateUsers users;

//    private MainViewController studentPictureBoardController;
    
    public static synchronized PictureBoardModel getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PictureBoardModel();
        }
        return INSTANCE;
    }

    private PictureBoardModel()
    {
        users = new CreateUsers();
        allPostIts = FXCollections.observableArrayList();
//        studentPictureBoardController = MainViewController.getInstance();
    }

//    public void CreateNewPostIt()
//    {
//        allPostIts.add(new StudentProfileModel(new PostIt(image, text)));
//     
//    }
    
//    public void CreateNewPostIt()
//    {
//        allPostIts.add(new StudentProfileModel(new PostIt(image, text)));
//     
//    }

    public ObservableList<StudentProfileModel> getAllPostIts()
    {
        return allPostIts;
    }

    public void removePostIt(int i)
    {
        //TODO Drag n drop!!! Gives you access to the MODEL!!!
    }
    
    public void TeacherLogin()
    {
        //TODO Drag n drop!!! Gives you access to the MODEL!!!
    }
    
    public void loadAllStudents() throws SQLException, IOException
    {
        List<Student> students = users.getUsers();
        for (Student student : students) {
            allPostIts.add(new StudentProfileModel(new PostIt(student.getImage(), student.getName())));   
        }
    }

}
