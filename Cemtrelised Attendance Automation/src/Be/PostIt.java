/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

import java.awt.SystemColor;
import javafx.scene.image.Image;


/**
 *
 * @author pgn
 */
public class PostIt
{
    
    private Image image;

    private String text;

    public PostIt(Image image, String text)
    {
        
    }
    
//    public PostIt(Image image, String text)
//    {
//        
//    }

    public PostIt(Image image, SystemColor text) 
    {
        this.text = "test";
        this.image = image;
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

}
