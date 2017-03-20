/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.PictureBoardModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class SidebarController implements Initializable
{

    PictureBoardModel boardModel;

    public SidebarController()
    {
        boardModel = PictureBoardModel.getInstance();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void addNewPostIt(ActionEvent event)
    {
        boardModel.CreateNewPostIt();
    }

    @FXML
    private void removeSelectedPostIt(ActionEvent event)
    {
        boardModel.removePostIt(0);
    }
    
    @FXML
    private void TecherLogin(ActionEvent event) throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/MainView.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("AttendanceSYS");
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }
}
