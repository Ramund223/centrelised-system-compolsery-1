/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

import javafx.scene.image.Image;

/**
 *
 * @author Nicolai
 */
public class Student 
{
    private String name;
    private int id;
    private String classroom;
    private String username;
    private String password;
    private boolean present;
    private Image image;

    public Student(String name, int id, String classroom, boolean present, Image image) 
    {
        this.name = name;
        this.id = id;
        this.classroom = classroom;
        this.present = present;
        this.image = image;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getClassroom() 
    {
        return classroom;
    }
    
    public void setClassroom(String classroom) 
    {
        this.classroom = classroom;
    }
    
    public String getPresent()
    {
        if (present == true)
        {
            return "Ja";
        }
            else
        {
            return "Nej";
        }    
    }
    
    public void setPresent(boolean present)
    {
        this.present = true;
    }
    
    public Image getImage() 
    {
        return image;
    }
    
    public void setImage(Image image) 
    {
        this.image = image;
    }
    
}
