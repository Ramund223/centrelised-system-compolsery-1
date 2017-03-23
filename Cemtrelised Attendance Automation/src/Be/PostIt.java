/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

import GUI.Controller.StudentPictureBoardController;
import GUI.Model.UserModel;
import java.awt.SystemColor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


/**
 *
 * @author pgn
 */
public class PostIt
{
    private StudentPictureBoardController studentPictureBoardController;
    
    private Image image;

    private String text = "test";
    
    private ObservableList<Student> listStudents;
//    private String text = "lolcats";

//    public PostIt(Image image, String text)
//    {
//        
//    }
    private int indexCounter = 0; 

    public PostIt(Image image, SystemColor textSC) 
    {
        studentPictureBoardController = StudentPictureBoardController.getInstance();
        listStudents = UserModel.getInstance().getStudents();
//        System.out.println(studentPictureBoardController.getIndexNr());
        this.text = listStudents.get(studentPictureBoardController.getIndexNr()).getName();
//        this.text = listStudents.get(indexCounter).getName();
//        this.text = listStudents.get(1).getName();
//        this.text = text;
        this.image = image;
//        studentPictureBoardController.setIndexNr(+1);
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
    public Image getImage()
    {
        return image;
    }

    /**
     * Set the value of titel
     *
     * @param image
     */
    public void setImage(Image image)
    {
        this.image = image;
    }
    
    public void initialize(URL url, ResourceBundle rb)
    {
        studentPictureBoardController = StudentPictureBoardController.getInstance();
//        listStudents = UserModel.getInstance().getStudents();
    }

}
