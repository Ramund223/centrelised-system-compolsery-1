/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.PictureBoardModel;
import GUI.Model.StudentProfileModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author pgn
 */
public class StudentPictureBoardController implements Initializable, ListChangeListener<StudentProfileModel>
{

    private PictureBoardModel boardModel;

    @FXML
    private ScrollPane containerForPostItBoard;

    @FXML
    private TilePane postItBoard;

    public StudentPictureBoardController()
    {
        boardModel = PictureBoardModel.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Bind the width of the flowpane to the width of the scrollpane: 
        //(I do not bind the height because the flowpane should resize to it's content)
        postItBoard.prefWidthProperty().bind(containerForPostItBoard.widthProperty());
        boardModel.getAllPostIts().addListener(this);
        getStudentsReady();
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
        for (int i = 0; i < 10; i++) 
        {
            boardModel.CreateNewPostIt();
        }
    }
}
