import java.util.ArrayList;
/**
 * The Class HelpCommand provides a range of useful help and support information to a Player if they are unable to
 * play the game correctly, or are unsure what to do.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0 05/01/2022
 */
public class HelpCommand extends ZuulCommand
{
    public HelpCommand(Game zuul)
    {
        super(zuul);
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and
     * a list of the command words.
     */
    public void execute()
    {
        System.out.println("You are walking around the Prison looking for items that will lead you to find the Records wanted by the BBC for their Documentary.");
        zuul.printInstructions();
        System.out.println("Available Commands:");
        for(CommandWords command : CommandWords.values())
        {
            System.out.println(command.word + ": \t" + command.description);
        }   
        System.out.println();
        System.out.println("e.g. go north, take keys, open notepad");
        System.out.println();
        System.out.println("Your Current Location:");
        System.out.println(zuul.MAP.getCurrentLocation().getLongDescription());
    }
}
