/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;



/**
 *
 * @author pgn
 */
public class PostIt
{

    private String image;

    private String text;

    public PostIt(String image, String text)
    {
        this.image = image;
        this.text = text;
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

}
