import java.util.ArrayList; // Imports the ArrayList Class used for the Inventory.

/**
 * The Player Class contains all the required variables and information for the Player to function correctly in the game,
 * this includes the Current Score, Bounty, Inventory Contents and Status Details used by other classes within the App.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0
 */

public class Player
{
    public int score; // Player Score
    public int bounty; // Player Bounty
    public boolean gameLost; // Player Status

    public ArrayList<ItemList> inventory; // Inventory ArrayList

    public Player(int score, int bounty, boolean gameLost)
    {
        this.score = 0; // Score Default Value as per Constructor
        this.bounty = 0; // Bounty Default Value as per Constructor
        this.gameLost = false; // GameLost Default Value as per Constructor

        inventory = new ArrayList<>(); // Creates new Inventory ArrayList
    }

    /**
     * Output the Player Statistics, including their Current Bounty and Score.
     */
    public String printStats()
    {
        return "\n" + ConsoleColours.ANSI_BG_BLACK + " PLAYER STATISTICS: " + ConsoleColours.ANSI_RESET + "\n" + "Bounty \t Score" + "\n" + bounty + " \t \t " + score;
    }

    /**
     * Increase the Player's Score by a specified value.
     * @param scoreValue The specified value of the Score
     */
    public void increaseScore(int scoreValue)
    {
        this.score += scoreValue;
    }

    /**
     * Increase the Bounty by a specified amount
     * @param bountyValue The specified value of the Bounty
     */
    public void increaseBounty(int bountyValue)
    {
        this.bounty += bountyValue;
    }

    public void setBounty(int bountyValue)
    {
        this.bounty = bountyValue;
    }

    /**
     * Return the Player's Current Score
     * @return score
     */
    public int getScore()
    {
       return this.score;
    }

    /**
     * Return the Player's Current Bounty
     * @return bounty
     */
    public int getBounty()
    {
        return this.bounty;
    }

    /**
     * Adds an Item to the Player's Inventory.
     * @param item The specified item.
     */
    public void addItemToInventory(ItemList item)
    {
        inventory.add(item); // Adds Item to the Player's Inventory ArrayList using the 'add' command.
    }
}