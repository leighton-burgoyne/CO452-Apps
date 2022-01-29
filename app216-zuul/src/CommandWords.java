
/**
 * This contains all the possible command words for the game of Zuul
 *
 * @author Derek Peacock & Nicholas Day (1.0), Modified by Leighton Burgoyne (2.0)
 * @version 25/08/2021 (1.0), 10/12/2021 (2.0)
 */
public enum CommandWords
{
    GO   ("go","Exit Location in <direction>"), // Go Command Word
    TAKE ("take", "Take <item> from Location"), // Take Command Word
    NOTEPAD ("notepad", "View Notepad Contents"), // Notepad Command Word
    INVENTORY("inventory","View Inventory"), // Inventory Command Word
    UNLOCK("unlock","Unlock an Item with the Keys"), // Unlock Command Word
    HELP ("help", "List all Available Commands"), // Help Command Word
    QUIT ("quit", "End the Game"); // Quit Command Word
    
    public final String word;
    public final String description;
    
    CommandWords(String word, String description)
    {
        this.word = word;
        this.description = description;
    }
}
