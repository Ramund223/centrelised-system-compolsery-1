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
    Image image1 = new Image("/Pictures/1.png", true);
    Image image2 = new Image("/Pictures/2.png", true);
    Image image3 = new Image("/Pictures/3.png", true);
    Image image4 = new Image("/Pictures/4.png", true);
    Image image5 = new Image("/Pictures/5.png", true);
    Image image6 = new Image("/Pictures/6.png", true);
    
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
        userModel.createStudent(1, "EASV","C3", "Test", false, image1);
        userModel.createStudent(2, "EASV","C3", "Carlos Abukat", false, image2);
        userModel.createStudent(3, "EASV","C3", "Magic Mike", false, image3);
        userModel.createStudent(4, "EASV","C3", "Ice Frog", false, image4);
        userModel.createStudent(5, "EASV","C3", "Løg Drengen", false, image5);
        userModel.createStudent(6, "EASV","C3", "Treant Six", false, image6);
    }
}
