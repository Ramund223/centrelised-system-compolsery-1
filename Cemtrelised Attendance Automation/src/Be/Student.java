/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Nicolai
 */
public class Student 
{
    private final StringProperty name = new SimpleStringProperty();
    private int id;
    private final StringProperty classroom = new SimpleStringProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();

    public Student(String name, int id, String classroom, String username, String password) 
    {
        this.name.set(name);
        this.id = id;
        this.classroom.set(classroom);
        this.username.set(username);
        this.password.set(password);
    }
    
    public String getName() 
    {
        return name.get();
    }
    
    public void setName(String value) 
    {
        name.set(value);
    }

    public StringProperty nameProperty() 
    {
        return name;
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
        return classroom.get();
    }
    
    public void setClassroom(String value) 
    {
        classroom.set(value);
    }

    public StringProperty classroomProperty() 
    {
        return classroom;
    }
    
    public String getUsername() 
    {
        return username.get();
    }
    
    public void setUsername(String value) 
    {
        username.set(value);
    }

    public StringProperty nameUsername() 
    {
        return username;
    }
    
    public String getPassword() 
    {
        return password.get();
    }
    
    public void setPassword(String value) 
    {
        password.set(value);
    }

    public StringProperty passwordProperty() 
    {
        return password;
    }
    
    @Override
    public String toString() 
    {
        return name.get();
        return classroom.get();
        return username.get();
        return password.get();
    }
}
