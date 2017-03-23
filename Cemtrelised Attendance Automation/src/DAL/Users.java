/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import GUI.Model.UserModel;
import javafx.scene.image.Image;

/**
 *
 * @author Emil
 */
public class Users 
{
    Image image1 = new Image("/Pictures/stockphoto.jpg", true);
    
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
//        userModel.createStudent(0, "None", "Teacher", "teacher", "Teacher");
        userModel.createStudent(1, "C20", "a", "a", "test", false, image1);
        userModel.createStudent(2, "C20", "Carlos93", "password", "Carlos Abukat", false, image1);
        userModel.createStudent(3, "C20", "MagicMike27", "password", "Magic Mike", false, image1);
        userModel.createStudent(4, "C20", "IceFrog29", "password", "Ice Frog", false, image1);
        userModel.createStudent(5, "C20", "LøgDrengen99", "password", "Løg Drengen", false, image1);
        userModel.createStudent(6, "C20", "Treant6", "password", "Treant Six", false, image1);
    }
}
