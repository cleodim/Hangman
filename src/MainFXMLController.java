/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cleod
 */
public class MainFXMLController implements Initializable {

    @FXML
    private MenuBar menu_bar;
    @FXML
    private Menu menu_app;
    @FXML
    private MenuItem start;
    @FXML
    private MenuItem load;
    @FXML
    private MenuItem create;
    @FXML
    private MenuItem exit;
    @FXML
    private Menu menu_det;
    @FXML
    private MenuItem dictionary;
    @FXML
    private MenuItem rounds;
    @FXML
    private MenuItem solution;
    @FXML
    private Button b1;
    @FXML 
    private Button b2;
    @FXML
    private Label possibilities_list;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button b10;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b13;
    @FXML
    private Button b14;
    @FXML
    private Button b15;
    @FXML
    private Button b16;
    @FXML
    private Button b17;
    @FXML
    private Button b18;
    @FXML
    private Button b19;
    @FXML
    private Button b20;
    @FXML
    private Button b21;
    @FXML
    private Button b22;
    @FXML
    private Button b23;
    @FXML
    private Button b24;
    @FXML
    private Button b25;
    @FXML
    private Button b26;
    @FXML
    private HBox word_letters;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit_game(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void load_dict(ActionEvent event) throws FileNotFoundException {
        Load_Popup.display();
    }

    @FXML
    private void create_dict(ActionEvent event) {
        CreatePopup.display();
    }
    
    private void show_solution(ActionEvent event) {
        Solution.display();
    }
    
    private void start_new_game(ActionEvent event) throws FileNotFoundException{
        possibilities_list.setText("");
        HmMain.new_game = new GameInitializer();
        ArrayList <Button> buttonlist = new ArrayList<Button>();
        word_letters.getChildren().clear();
        Map<String, Button> letter_buttons = new HashMap();
        letter_buttons.put("A", b1);
        letter_buttons.put("B", b2);
        letter_buttons.put("C", b3);
        letter_buttons.put("D", b4);
        letter_buttons.put("E", b5);
        letter_buttons.put("F", b6);
        letter_buttons.put("G", b7);
        letter_buttons.put("H", b8);
        letter_buttons.put("I", b9);
        letter_buttons.put("J", b10);
        letter_buttons.put("K", b11);
        letter_buttons.put("L", b12);
        letter_buttons.put("M", b13);
        letter_buttons.put("N", b14);
        letter_buttons.put("O", b15);
        letter_buttons.put("P", b16);
        letter_buttons.put("Q", b17);
        letter_buttons.put("R", b18);
        letter_buttons.put("S", b19);
        letter_buttons.put("T", b20);
        letter_buttons.put("U", b21);
        letter_buttons.put("V", b22);
        letter_buttons.put("W", b23);
        letter_buttons.put("X", b24);
        letter_buttons.put("Y", b25);
        letter_buttons.put("Z", b26);
        
        
        for(Map.Entry<String,Button> entry : letter_buttons.entrySet()){
            entry.getValue().setDisable(true);
        }
        
        for (int i = 0; i < HmMain.new_game.selected_word.length(); i++) {
            buttonlist.add(new Button());
            buttonlist.get(i).setText("  ");
            buttonlist.get(i).setId("button" + Integer.toString(i));
            word_letters.getChildren().add(buttonlist.get(i));
        }
        
        while(HmMain.new_game.letters_remaining != 0){  
            Button blank;
            for (Button buttonlist1 : buttonlist) {
                buttonlist1.setOnAction(e -> {
                    possibilities_list.setText(HmMain.new_game.culculate_pos(buttonlist1.getId()));
                    /*for (Map.Entry<String,Button> entry : letter_buttons.entrySet()){
                        if(HmMain.new_game.letters_for_blank.contains(entry.getKey())){
                            entry.getValue().setDisable(false);
                        }
                        else{
                            entry.getValue().setDisable(true);
                        }
                    }*/
                });
            }
            for (Map.Entry<String,Button> entry2 : letter_buttons.entrySet()){
                entry2.getValue().setOnAction(e -> {
                    if(Character.toString(HmMain.new_game.selected_word.charAt(HmMain.new_game.selected_place)).equals(entry2.getKey())){
                        buttonlist.get(HmMain.new_game.selected_place).setText(entry2.getKey());
                        buttonlist.get(HmMain.new_game.selected_place).setDisable(true);
                        for(int i = 0; i < HmMain.new_game.possible_words.size(); i++){
                            if(!Character.toString(HmMain.new_game.possible_words.get(i).charAt(HmMain.new_game.selected_place).equals(entry2.getKey()))){
                                HmMain.new_game.possible_words.remove(i);
                                
                            }
                        }
                    }
                });
            }
            
            break;
           
        }
        
    }
    
    

    
}
