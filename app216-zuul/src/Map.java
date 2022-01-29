
/**
 * This class is responsible for creating and linking all the Locations in the game to form a 2D or 3D network.
 *
 *                    [Storage Room]
 *                          |
 *    [Kitchen] <----> [Cell Block] <----> [Archive Room]
 *                          |
 * [Staff Room] <----> [Reception] <----> [Security Office]
 *                          |
 *                      [Outside]
 *
 * @author Derek Peacock and Nicholas Day (1.0). Modified by Leighton Burgoyne (2.0)
 * @version 22/08/2021 (1.0), 10/12/2021 (2.0)
 */
public class Map
{
    private Location outside, staffRoom, reception, securityOffice, kitchen, cellBlock, archiveRoom, storageRoom; // Location Names

    private Location playerLocation; // Current Location

    // private Boolean isLocked; // Determines whether the Location is Locked (Access Card Required if TRUE)

    public Player player; // Player Object

    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        player = new Player(0,0,false); // Constructor for Player (it fixes the null errors)
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together. Set the current location to the outside.
     * Both locations need to have been created before their exists are linked.
     */
    private void createLocations()
    {
        outside = new Location("outside the Main Entrance of the Prison. \n You see a big revolving glass door, behind it is a busy Reception & Lobby area, which is full of people");
        reception = new Location("in Reception. \n Around you are several locked doors and Reception is extremely busy, the door to the west of you has been left slightly ajar and is unlocked");
        staffRoom = new Location("in the Staff Room. \n There is a big table in the middle and some cupboards around the room, one of these is open and you see an Access Card inside");
        securityOffice = new Location("in the Security Office. \n This room is occupied by a lone security guard who is asleep, it is full of CCTV Screens. You see some Keys hung up on the wall");
        cellBlock = new Location("in the Cell Block. \n There are Jail Cells all around you, bustling with Inmates. You see rooms in all directions, all with locked doors");
        kitchen = new Location("in the Kitchen \n There is a Cook preparing food for the Inmates. She has not heard you enter, but you should probably leave before she turns around and calls Security");
        archiveRoom = new Location("in the Archive Room \n You see walls and walls of Filing Cabinets, each one has an individual number assigned to it, the records are in one of these. \n Which Filing Cabinet do you wish to search? Type: unlock <code>");
        storageRoom = new Location("in the Storage Room \n There are boxes everywhere, but hung up on a Coat Hanger you see some Staff Uniform, you should wear it to reduce the risk of being caught");

        createOutside(); // Outside Location
        createReception(); // Reception Location
        createStaffRoom(); // Staff Room Location
        createSecurityOffice(); // Security Office Location
        createCellBlock(); // Cell Block Location
        createKitchen(); // Kitchen Location
        createArchiveRoom(); // Archive Room Location
        createStorageRoom(); // Storage Room Location

        playerLocation = outside;  // Start Game in the 'Outside' Location
    }

    /**
     * Create the Outside and link it to Reception.
     */
    private void createOutside()
    {
        // Outside --> Reception
        outside.setExit("north", reception);

        // Reception --> Outside
        reception.setExit("south", outside);

    }

    /**
     * Create Reception and link it to the Outside, Staff Room, Cell Block, and Security Office.
     */
    private void createReception()
    {
        reception.setItem(ItemList.NOTEPAD); // Assign Item 'Notepad' to Reception
        //isLocked = false; // Access Not Restricted

        // Reception --> Outside
        reception.setExit("south", outside);

        // Outside --> Reception
        outside.setExit("north", reception);

        // Reception --> Staff Room
        reception.setExit("west", staffRoom);

        // Staff Room --> Reception
        staffRoom.setExit("east", reception);

        // Reception --> Cell Block
        reception.setExit("north", cellBlock);

        // Cell Block --> Reception
        cellBlock.setExit("south", reception);

        // Reception --> Security Office
        reception.setExit("east", securityOffice);

        // Security Office --> Reception
        securityOffice.setExit("west", reception);
    }

    /**
     * Create the Staff Room and link it to Reception.
     */
    private void createStaffRoom()
    {
        //isLocked = false; // Access Not Restricted
        staffRoom.setItem(ItemList.CARD); // Assign Item 'Card' to Staff Room

        // Staff Room --> Reception
        staffRoom.setExit("east", reception);

        // Reception --> Staff Room
        reception.setExit("west", staffRoom);
    }

    /**
     * Create the Cell Block and link it to the Storage Room, Kitchen, Archive Room, and Reception.
     */
    private void createCellBlock()
    {
        //isLocked = true; // Access Restricted
/*        if(player.inventory.contains(ItemList.CARD)) // Not Implemented yet (future proofed locking functionality for locations)
        {
            System.out.println(ConsoleColours.ANSI_BG_GREEN + "Access Granted" + ConsoleColours.ANSI_RESET);
        }
        else
        {
            System.out.println(ConsoleColours.ANSI_BRIGHT_BG_RED + "Access Denied" + ConsoleColours.ANSI_RESET);
            System.out.println("You need an Access Card to enter this area, please find one and come back.");

        }*/

        // Cell Block --> Storage Room
        cellBlock.setExit("north", storageRoom);

        // Storage Room --> Cell Block
        storageRoom.setExit("south", cellBlock);

        // Cell Block --> Kitchen
        cellBlock.setExit("west", kitchen);

        // Kitchen --> Cell Block
        kitchen.setExit("east", cellBlock);

        // Cell Block --> Archive Room
        cellBlock.setExit("east", archiveRoom);

        // Archive Room --> Cell Block
        archiveRoom.setExit("west", cellBlock);

        // Cell Block --> Reception
        cellBlock.setExit("south", reception);

        // Reception --> Cell Block
        reception.setExit("north", cellBlock);
    }

    /**
     * Create the Security Office and link it to Reception.
     */
    private void createSecurityOffice()
    {
        //isLocked = true; // Access Restricted
        securityOffice.setItem(ItemList.KEYS); // Assign Item 'Keys' to Security Office

        // Security Office --> Reception
        securityOffice.setExit("west", reception);

        // Reception --> Security Office
        reception.setExit("east", securityOffice);
    }

    /**
     * Create the Kitchen and link it to the Cell Block.
     */
    private void createKitchen()
    {
        //isLocked = true; // Access Restricted

        // Kitchen --> Cell Block
        kitchen.setExit("east", cellBlock);

        // Cell Block --> Kitchen
        cellBlock.setExit("west", kitchen);
    }

    /**
     * Create the Archive Room and link it to the Cell Block.
     */
    private void createArchiveRoom()
    {
        //isLocked = true; // Access Restricted
        archiveRoom.setItem(ItemList.RECORDS); // Assign Item 'Records' to Archive Room

        // Archive Room --> Cell Block
        archiveRoom.setExit("west", cellBlock);

        // Cell Block --> Archive Room
        cellBlock.setExit("east", archiveRoom);
    }

    /**
     * Create the Storage Room and link it to the Cell Block.
     */
    private void createStorageRoom()
    {
        //isLocked = true; // Access Restricted
        storageRoom.setItem(ItemList.UNIFORM); // Assign Item 'Uniform' to Storage Room

        // Storage Room --> Cell Block
        storageRoom.setExit("south", cellBlock);

        // Cell Block --> Storage Room
        cellBlock.setExit("north", storageRoom);
    }

    public Location getCurrentLocation() // Returns the Players Current Location
    {
        return playerLocation;
    }

    public void enterLocation(Location nextLocation) // Handles changing the Players Current Location when they move in a new direction
    {
        playerLocation = nextLocation;
    }
}