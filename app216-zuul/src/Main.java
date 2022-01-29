/**
 * The Main Class creates an instance of the Game and calls the relevant functions to run the app, it is critical to the
 * functioning of the program.
 *
 * @author Leighton Burgoyne
 * @version v1.0 (10/12/2021)
 */
public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
        game = new Game(); // Creates a new version of the Game
        game.play(); // Runs the Game for the Player
    }
}
