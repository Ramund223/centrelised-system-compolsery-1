/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.PostIt;
import GUI.Controller.MainViewController;
import java.awt.SystemColor;
import static java.awt.SystemColor.text;
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
        allPostIts = FXCollections.observableArrayList();
//        studentPictureBoardController = MainViewController.getInstance();
    }

    public void CreateNewPostIt()
    {
        allPostIts.add(new StudentProfileModel(new PostIt(image, text)));
     
    }
    
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

}
