/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BLL.Time;
import GUI.Controller.StudentAttendanceViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author skole
 */
public class CentralisedAttendanceAutomation extends Application {

    private StudentAttendanceViewController studentAttendanceViewController;
    private Time time;
    
    public CentralisedAttendanceAutomation()
    {
        time = Time.getInstance();
        time.timer();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI/View/MainView.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("AttendanceSYS");
        stage.setResizable(true);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() 
        {
            @Override
            public void handle(WindowEvent we) 
            {
                time.timer.cancel();
                time.timer.purge();
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
