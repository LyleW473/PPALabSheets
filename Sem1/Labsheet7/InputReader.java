import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getInput()
    {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine();

        // Remove repeated words
        removeRepeatedWords(inputLine);
        return inputLine;
    }

    public String removeRepeatedWords(String input)
    {   
        // Add all unique words to a hashset
        HashSet<String> uniqueWords = new HashSet<String>();
        for (String word: input.split(" "))
        {
            // System.out.println(word);
            uniqueWords.add(word.toLowerCase());
        }
        
        // Construct the input again, using only the unique words
        String newInput = "";
        for (String word: uniqueWords)
        {
            // System.out.println("here   " + word);
            newInput += word + " ";
        }
        // System.out.println(newInput);
        return newInput;
    }
}
