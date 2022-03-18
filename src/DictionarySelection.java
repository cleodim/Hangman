
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cleod
 */
public class DictionarySelection {
    
    String dictionary_id = Load_Popup.dictID.getText();
    String path = "/Users/Cleod/OneDrive/Documents/NetBeansProjects/HangmanProject/medialab/" + dictionary_id + ".txt";
    File input_file = new File(path);
    Scanner scan;
    public List<String> words_list;
    
    public DictionarySelection() throws FileNotFoundException {
        words_list = new ArrayList <String>();
        this.scan = new Scanner(input_file);
        while(scan.hasNextLine()){
            this.words_list.add(scan.nextLine());
        }
        System.out.println(this.words_list);
    }
    
}
