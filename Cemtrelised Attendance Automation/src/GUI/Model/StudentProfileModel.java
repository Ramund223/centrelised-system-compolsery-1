/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.PostIt;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pgn
 */
public class StudentProfileModel
{
    
    private final StringProperty image = new SimpleStringProperty();
    private final StringProperty text = new SimpleStringProperty();
    
    private final PostIt postIt;
    
    public StudentProfileModel(PostIt postIt)
    {
        this.postIt = postIt;
        image.set(postIt.getImage());
        text.set(postIt.getText());
    }
    
    public PostIt getPostIt()
    {
        return postIt;
    }
    
    public String getText()
    {
        return text.get();
    }
    
    public void setText(String value)
    {
        text.set(value);
        postIt.setText(value);
    }
    
    public StringProperty textProperty()
    {
        return text;
    }
    
    public String getImage()
    {
        return image.get();
    }
    
    public void setImage(String value)
    {
        image.set(value);
        postIt.setImage(value);
    }
    
    public StringProperty imageProperty()
    {
        return image;
    }
    
}
