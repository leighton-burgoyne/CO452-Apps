/**
 * The Main Class creates the StockApp and calls the relevant functions to run the app, it is critical to the
 * functioning of the program.
 *
 * @author Leighton Burgoyne
 * @version v1.0 (26/11/2021)
 */
public class Main
{
    private static StockApp app;

    public static void main(String[] args)
    {
        app = new StockApp(); // Creates a new version of StockApp as 'app'
        app.run(); // Runs the App for the user
    }
}
