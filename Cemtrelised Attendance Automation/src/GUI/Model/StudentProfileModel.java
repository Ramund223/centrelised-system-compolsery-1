/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import Be.PostIt;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author pgn
 */
public class StudentProfileModel
{
    
    //private final Image image = new Image("stockphoto.jpg");
    //ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/stockphoto.jpg")));
    //private final ImageView image = new ImageView();
    private final ObjectProperty<javafx.scene.image.Image> image = new SimpleObjectProperty<>();
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
    
    public Image getImage()
    {
        return image.get();
    }
    
    public void setImage(Image value)
    {
        image.set(value);
        postIt.setImage(value);
    }
    
    public ObjectProperty imageProperty()
    {
        return image;
    }
}
