/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import GUI.Model.UserModel;

/**
 *
 * @author Emil
 */
public class Users 
{
    private static Users INSTANCE;
    
    public static synchronized Users getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Users();
        }
        return INSTANCE;
    }
    
    public Users()
    {
        userModel = UserModel.getInstance();
    }
    
    private UserModel userModel;
    
    //This method creates the students.
    public void createUsers()
    {
//        userModel.createStudent(1, "None", "Teacher", "teacher", "Teacher");
        userModel.createStudent(2, "C20", "a", "a", "test");
        userModel.createStudent(3, "C20", "Carlos93", "password", "Carlos Abukat");
        userModel.createStudent(4, "C20", "MagicMike99", "password", "Magic Mike");
        userModel.createStudent(5, "C20", "IceFrog29", "password", "Ice Frog");
        userModel.createStudent(6, "C20", "LøgDrengen99", "password", "Løg Drengen");
        userModel.createStudent(7, "C20", "Treant6", "password", "Treant Six");
    }
}
