
/**
 * This command transfers the player from
 * one location to another location provided the
 * two locations are linked by a valid exit
 *
 * @author Derek Peacock & Nicholas Day (1.0), Modified by Leighton Burgoyne (2.0)
 * @version 23/08/2021 (1.0), 10/12/2021 (2.0)
 */
public class GoCommand extends ZuulCommand
{
    String direction; // Direction String
    
    public GoCommand(Game zuul, String direction)
    {
        super(zuul);
        this.direction = direction;
    }    

    public void execute()
    {
        if(direction == null) // If no second word (Direction) specified by Player in command usage
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        Map map = zuul.MAP; // Map Object via Zuul
        
        // Try to leave current room.
        Location currentLocation = map.getCurrentLocation();
        Location nextLocation = currentLocation.getExit(direction);

        if (nextLocation == null) // If Next Location does not exist in specified direction
        {
            System.out.println("There is no exit in this direction!");
        }
        else // If Next Location does exist in specified direction
        {
            map.enterLocation(nextLocation); // Enters the Player into the new Location
            System.out.println(map.getCurrentLocation().getLongDescription()); // Prints out Current Location and Description message to Player
        }
    }
}
