/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

import GUI.Controller.MainViewController;
import GUI.Model.UserModel;
import java.awt.SystemColor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


/**
 *
 * @author pgn
 */
public class PostIt
{
    private MainViewController mainViewController;
    
    private String image;

    private String text = "test";
    
    private ObservableList<Student> listStudents;
//    private String text = "lolcats";

//    public PostIt(Image image, String text)
//    {
//        
//    }
    private int indexCounter = 0; 

    private static int indexNr = 0;
    
    public PostIt(String image, String textSC) throws IOException, SQLException 
    {
        mainViewController = MainViewController.getInstance();
        listStudents = UserModel.getInstance().getStudents();
//        System.out.println(mainViewController.getIndexNr());
//        this.text = listStudents.get(mainViewController.getIndexNr()).getName();
        this.text = listStudents.get(indexNr).getName();
//        this.text = listStudents.get(indexCounter).getName();
//        this.text = listStudents.get(1).getName();
//        this.text = text;
//        this.image = image;
        this.image = listStudents.get(indexNr).getImage();
//        this.image = listStudents.get(mainViewController.getIndexNr()).getImage();
//        mainViewController.setIndexNr(+1);

        indexNr = indexNr + 1;
//        System.out.println(indexNr);
    }

    


    /**
     * Get the value of text
     *
     * @return the value of text
     */
    public String getText()
    {
        return text;
    }

    /**
     * Set the value of text
     *
     * @param text new value of text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * Get the value of titel
     *
     * @return the value of titel
     */
    public String getImage()
    {
        return image;
    }

    /**
     * Set the value of titel
     *
     * @param image
     */
    public void setImage(String image)
    {
        this.image = image;
    }
    
    public void initialize(URL url, ResourceBundle rb) throws IOException, SQLException
    {
        mainViewController = MainViewController.getInstance();
//        listStudents = UserModel.getInstance().getStudents();
    }

}
