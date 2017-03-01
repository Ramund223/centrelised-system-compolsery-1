/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Users;

/**
 *
 * @author Emil
 */

public class AuthenticationCheck 
{
    private Users createUsers;
    
    private static AuthenticationCheck INSTANCE;
    
    public AuthenticationCheck()
    {
        createUsers = Users.getInstance();
    }
    
    public static synchronized AuthenticationCheck getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new AuthenticationCheck();
        }
        return INSTANCE;
    }
    
    public void createUsers()
    {
        createUsers.createUsers();
    }
    
}
