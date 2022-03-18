
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cleod
 */
public class Solution {
    
    public static void display(){
        
        Stage popupwindow=new Stage();
      
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Create");
      
        Label label1= new Label("You lost! Here's the solution:");
        Label label2= new Label(HmMain.new_game.selected_word);
        Button button1= new Button("OK");
        button1.setOnAction(e -> popupwindow.close());

        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2, button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene1= new Scene(layout, 300, 250);
 
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
        }
}
