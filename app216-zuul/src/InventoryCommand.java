/**
 * The Class InventoryCommand displays the contents of the Player's Inventory on execution.
 *
 * @author Modified by Leighton Burgoyne
 * @version v1.0
 */
public class InventoryCommand extends ZuulCommand
{
    public Player player;
    public InventoryCommand(Game zuul)
    {
        super(zuul);
        player = new Player(0,0,false);
    }

    public void execute() {
        System.out.println("Inventory Contents:");
        if (player.inventory.isEmpty()) // If Inventory is Empty
        {
            System.out.println("Your Inventory is empty!");
        }
        else // If Inventory has Contents
        {
            System.out.println(player.inventory);
        }
    }
}
