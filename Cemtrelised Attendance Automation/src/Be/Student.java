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
    private String school;
    private String classroom;
    private boolean present;
    private String image;

    public Student(String name, int id, String school, String classroom, boolean present, String image) 
    {
        this.name = name;
        this.id = id;
        this.school = school;
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
    
    public String getSchool() 
    {
        return school;
    }
    
    public void setSchool(String school) 
    {
        this.school = school;
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
    
    public String getImage() 
    {
        return image;
    }
    
    public void setImage(String image) 
    {
        this.image = image;
    }
    
}
