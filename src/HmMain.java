/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;


/**
 *
 * @author Cleod
 */
public class HmMain extends Application {
    
    public static GameInitializer new_game;
    public static ArrayList <Round> rounds_5 = new ArrayList<Round>();
    Stage stage;
    Scene scene1;
            
    @Override
    public void start(Stage primaryStage) {
        try {
            //stage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
            scene1 = new Scene(root, 800, 600);
            
            primaryStage.setTitle("Medialab Hangman");
            primaryStage.setScene(scene1);
            primaryStage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(HmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        launch(args);
        
    }
    
}
