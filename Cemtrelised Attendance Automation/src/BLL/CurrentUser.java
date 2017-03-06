/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Emil
 */

public class CurrentUser 
{
    private static CurrentUser INSTANCE;
    private String currentUserName;
    private String currentPassword;
    private String currentSelectedUser;

    public String getCurrentSelectedUser() {
        return currentSelectedUser;
    }

    public void setCurrentSelectedUser(String currentSelectedUser) {
        this.currentSelectedUser = currentSelectedUser;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
    
    public static synchronized CurrentUser getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new CurrentUser();
        }
        return INSTANCE;
    }
}
