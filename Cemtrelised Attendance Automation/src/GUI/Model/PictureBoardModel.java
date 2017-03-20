/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.PostIt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author pgn
 */
public class PictureBoardModel
{

    private static PictureBoardModel INSTANCE;

    private ObservableList<StudentProfileModel> allPostIts;

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
    }

    public void CreateNewPostIt()
    {
        allPostIts.add(new StudentProfileModel(new PostIt("", "Hello")));
     
    }

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
