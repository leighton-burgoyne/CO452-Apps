import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal and assists with validation of this data.
 * The text typed by a user is returned.
 * 
 * @author     Michael Kölling & David J. Barnes (1.0), Modified by Derek Peacock (2.0), Modified by Leighton Burgoyne (3.0)
 * @version    1.0 (29/02/2016), 2.0 (13/12/2020),  3.0 (26/11/2021)
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
    public String getString(String prompt)
    {
        reader = new Scanner(System.in);

        String inputLine = null;
        boolean isValid = false;
        
        while(!isValid)
        {
            System.out.print(prompt); // print prompt
            inputLine = reader.nextLine();
            
            if(!inputLine.isEmpty())
                isValid = true;
            else 
                System.out.println("\nYour input is blank!\n");
        }

        return inputLine;
    }
    
    /**
     * Read the next int from standard input (the text terminal), and return it as an integer.
     * 
     * @return Integer typed by user.
     */
    public int getInt(String prompt)
    {
        reader = new Scanner(System.in);

        int number = 0;
        boolean isValid = false;
        
        while(!isValid)
        {
            System.out.println(prompt);         // print prompt
            number = reader.nextInt();
            
            if(number > 0)
            {
                isValid = true;
            }
            else 
                System.out.println("Your value is less than zero!");
        }

        return number;
    }
}