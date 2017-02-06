/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

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

    public Student(String name, int id, String classroom, String username, String password) 
    {
        this.name = name;
        this.id = id;
        this.classroom = classroom;
        this.username = username;
        this.password = password;
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
    
    public String getUsername() 
    {
        return username;
    }
    
    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    public String getPassword() 
    {
        return password;
    }
    
    public void setPassword(String password) 
    {
        this.password = password;
    }
}
