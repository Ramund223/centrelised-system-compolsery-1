/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Be.PostIt;
import DAL.PostItDaoMOCK;

/**
 *
 * @author pgn
 */
public class DataManager
{

    private PostItDaoMOCK postItDao;

    public DataManager()
    {
        postItDao = new PostItDaoMOCK();
    }

    public PostIt getPostIt()
    {
        return postItDao.getPostIt();
    }

    
    
}
