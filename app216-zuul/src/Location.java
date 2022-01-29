import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Location - a location on the map of an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Location" represents one place in the scenery of the game.  It is
 * connected to other locations via exits.  For each existing exit, the
 * location stores a reference to the neighboring locations.
 *
 * @author  Michael Kölling and David J. Barnes (1.0), Modified by Derek Peacock & Nicholas Day (2.0), Modified by Leighton Burgoyne (3.0)
 * @version 29/02/2016 (1.0), 25/08/2021 (2.0), 10/12/2021 (3.0)
 */

public class Location
{

    private String description; // Creates 'description' String
    private HashMap<String, Location> exits; // Stores Exit Locations for this room.
    private HashMap<String, ItemList> items; // Stores Allocated Items for this room.

    /**
     * Create a location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Location(String description)
    {
        this.description = description;
        exits = new HashMap<>(); // Creates a new HashMap for all Exits
        items = new HashMap<>(); // Creates a new HashMap for all Items
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Location neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north, west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return " You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }

    /**
     * Return a string describing the locations exits,
     * for example "Exits: north, west".
     */
    private String getExitString()
    {
        String returnString = " Exits:";
        Set<String> keys = exits.keySet();

        for(String exit : keys)
        {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return a string describing the locations items,
     * for example "Items: keys".
     */
    private String getItemString()
    {
        String returnString = " Items:";
        Set<String> keys = items.keySet();

        for(String item : keys)
        {
            returnString += " " + item;
        }
        return returnString;
    }

    /**
     * Return a list of all items associated with the 'items' HashMap.
     */
    public ItemList getItem(String name)
    {
        return items.get(name);
    }

    /**
     * Assigns an item to a Location, and adds to the 'items' HashMap accordingly.
     */
    public void setItem(ItemList item)
    {
        items.put(item.getName(), item);
    }


    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Location getExit(String direction)
    {
        return exits.get(direction);
    }
}

