
/**
 * Write a description of class Program here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Program
{
    private static StockApp app;

    /**
     * This class contains the main method which
     * is called first, it creates a new StockApp
     * and calls the main run method
     *
     * @param args No args needed
     */
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
