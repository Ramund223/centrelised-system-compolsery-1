/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BLL.CreateUsers;
import Be.Student;
import GUI.Model.PictureBoardModel;
import GUI.Model.StudentProfileModel;
import GUI.Model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author pgn
 */
public class StudentPictureBoardController implements Initializable, ListChangeListener<StudentProfileModel>
{
    Image image = new Image("/Pictures/stockphoto.jpg", true);
    private static StudentPictureBoardController INSTANCE;
    
    private PictureBoardModel boardModel;

    @FXML
    private ScrollPane containerForPostItBoard;

    @FXML
    private TilePane postItBoard;
    
    private CreateUsers createUsers;

    private ObservableList<Student> listStudents;
    
    public static int indexNr;
    
    public StudentPictureBoardController()
    {
        boardModel = PictureBoardModel.getInstance();
        createUsers = CreateUsers.getInstance();
        listStudents = UserModel.getInstance().getStudents();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb)
//    {
//        //Bind the width of the flowpane to the width of the scrollpane: 
//        //(I do not bind the height because the flowpane should resize to it's content)
//        postItBoard.prefWidthProperty().bind(containerForPostItBoard.widthProperty());
//        boardModel.getAllPostIts().addListener(this);
//        getStudentsReady();
////        createUsers = CreateUsers.getInstance();
//    }

    public static synchronized StudentPictureBoardController getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StudentPictureBoardController();
        }
        return INSTANCE;
    }
    
    @Override
    public void onChanged(Change<? extends StudentProfileModel> c)
    {
        while (c.next())
        {
            if (c.wasAdded())
            {
                addNewPostItView(c);
            } else if (c.wasRemoved())
            {
                removeRemovedPostIts(c);
            } else
            {
                //TODO other
            }
        }
    }

    private void addNewPostItView(Change<? extends StudentProfileModel> c)
    {
        for (StudentProfileModel model : c.getAddedSubList())
        {
            try
            {
                postItBoard.getChildren().add(getPostItView(model));
            } catch (IOException ex)
            {
                System.out.println("BAD PRACTICE, YOUR DROWNING AN EXCEPTION!!!");
            }
        }
    }

    private Node getPostItView(StudentProfileModel model) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/StudentProfile.fxml"));
        AnchorPane postIt = loader.load();
        StudentProfileController singlePostItController = loader.getController();
        singlePostItController.setModel(model);
        return postIt;
    }

    private void removeRemovedPostIts(Change<? extends StudentProfileModel> c)
    {
        postItBoard.getChildren().remove(c.getFrom(), c.getTo());
    }
    
    private void getStudentsReady()
    {
        for (int i = 0; i < listStudents.size(); i++)
        {
            indexNr = i;
            System.out.println(listStudents.get(i).getName());
            boardModel.CreateNewPostIt();
            System.out.println(indexNr);
        }
    }

    public void setIndexNr(int indexNr) 
    {
        this.indexNr = indexNr;
    }
     

    public int getIndexNr() 
    {
        return indexNr;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Bind the width of the flowpane to the width of the scrollpane: 
        //(I do not bind the height because the flowpane should resize to it's content)
        postItBoard.prefWidthProperty().bind(containerForPostItBoard.widthProperty());
        boardModel.getAllPostIts().addListener(this);
        createUsers.createUsers();
        getStudentsReady();
    }
    
}
