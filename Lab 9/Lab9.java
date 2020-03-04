
/**
 * Reads in the words in a file and creates a summary file listing all 
 * unique words in that file along with all the pages on which the words are found.
 *
 * @author Martin Mueller
 * @version 04/25/2018
 */

import java.io.*;
import java.util.*;

public class Lab9 {
    public static void main(String args[]) {
        Scanner scanner = null;
        FileWriter writer = null;
        try {
            //create TreeMap to store all the words and their pages
            TreeMap<String, ArrayList<Integer>> wordList = new TreeMap<>();
            //create a scanner to read in the words in the input file
            scanner = new Scanner(new File(args[0]));
            scanner.useDelimiter("[^\\w\\d\\-\\']+");
            //create counters to keep track of the number of words scanned on the page...
            //...and the page number the scanner is currently on
            int scanned = 0;
            int page = 1;
            //iterate through the input file and create a word list
            while(scanner.hasNext()) {
                //increment page
                if(scanned == 500) {
                    scanned = 0;
                    page++;
                }
                //read next word
                String word = scanner.next().toLowerCase();
                if(!wordList.containsKey(word)) { //if the list doesn't have the word, make a new entry
                    ArrayList<Integer> pages = new ArrayList<>();
                    pages.add(page);
                    wordList.put(word, pages);
                } else { //...if it does, only add the page number if the entry doesn't already have it
                    ArrayList<Integer> pages = wordList.get(word);
                    if(!pages.contains(page)) {
                        pages.add(page);
                    }
                }
                //increment words scanned on the current page
                scanned++;
            }
            //create a FileWriter to make the output file
            writer = new FileWriter(new File(args[1]));
            //iterate through wordList and print out each word and its corresponding page number(s)
            for(Map.Entry<String, ArrayList<Integer>> entry : wordList.entrySet()) {
                StringBuilder string = new StringBuilder();
                ListIterator iterator = entry.getValue().listIterator();
                string.append(entry.getKey()+" ["+iterator.next());
                while(iterator.hasNext()) {
                    string.append(", "+iterator.next());
                }
                string.append("]\r\n");
                writer.write(string.toString());
            }
            //lastly, close the scanner and writer
            writer.close();
        } catch(NullPointerException e) {
            System.out.println("Invalid argument input");
            System.out.println("The correct format is: java [Program path] [input file] [output file]");
        } catch(IOException e) {
            System.out.println("Cannot create output file");
        } finally {
            scanner.close();
        }
    }
}
