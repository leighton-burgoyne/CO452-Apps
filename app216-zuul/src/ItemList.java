/**
 * Enum Class ItemList is provided to store a list of the different items within the Game, as well as associated
 * properties like the Name of these Items.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0
 */

public enum ItemList
{
    CARD("card"), // Access Card (for accessing all restricted areas)
    NOTEPAD("notepad"), // Notepad (for viewing important clues)
    KEYS("keys"), // Keys (for unlocking the Filing Cabinet)
    UNIFORM("uniform"), // Uniform (so the player does not lose as much bounty)
    RECORDS("records"); // Records (the final item to be collected, mission won on collection)

    public String name; // Item Name

    /*
     * Create the Item using its name
     */
    ItemList(String name)
    {
        this.name = name;
    }

    /**
     * Get the name of the Item
     * @return name
     */
    public String getName()
    {
        return this.name;
    }
}

