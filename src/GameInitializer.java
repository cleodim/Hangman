
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static javax.swing.UIManager.get;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cleod
 */
public class GameInitializer {
    DictionarySelection dictionary;
    Random rand = new Random();
    String selected_word;
    int points = 0;
    int guesses = 0;
    int wrong_guesses = 0;
    int wordsremaining;
    ArrayList<String> possible_words = new ArrayList<String>();
    int letters_remaining;
    int selected_place;
    ArrayList<String> letters_for_blank = new ArrayList<String>();

    public GameInitializer() throws FileNotFoundException {
        
        //choose random word
        dictionary = new DictionarySelection();
        selected_word = this.dictionary.words_list.get(rand.nextInt(this.dictionary.words_list.size()));
        System.out.println(selected_word); //auto na to vgalw apo dw
        wordsremaining = this.dictionary.words_list.size();
        
        for (String words_list : dictionary.words_list) {
            if(words_list.length() == selected_word.length()){
                possible_words.add(words_list);
            }
        }
        letters_remaining = selected_word.length();
        
                
    }
    
    public String culculate_pos(String id){
        this.letters_for_blank.clear();
        this.selected_place = Integer.valueOf(id.replaceAll("[^0-9]", ""));
        Map<String,Integer> possibility = new HashMap();
        String return_value = "The possible letters for this blank are:\n" + "**from the most possible to the least possible**" + "\n";
        System.out.println("pos words are: \n" + possible_words);
        for(int i = 0; i < possible_words.size(); i++){
            String letter = Character.toString(possible_words.get(i).charAt(this.selected_place));
            if(possibility.get(letter) == null){
                possibility.put(letter, 1);
                this.letters_for_blank.add(letter);
            }
            else{
                possibility.put(letter, possibility.get(letter)+1);
            }  
        }
        while(!possibility.isEmpty()){
                Map.Entry<String,Integer> max = null;
                for(Map.Entry<String,Integer> entry : possibility.entrySet()){
                    if(max == null || entry.getValue().compareTo(max.getValue()) > 0){
                        max = entry;
                    }
                }
                return_value = return_value + max.getKey().toUpperCase() + "\n";
                possibility.remove(max.getKey());
            }
        
        return return_value;
    }
}
