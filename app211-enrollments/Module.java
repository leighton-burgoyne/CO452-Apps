
/**
 * The Module Class includes a variety of information on the Modules and 
 * Individual Topics, which are associated with a specific course; this
 * includes the Module Code (Identifier), Module Title, and the Credits
 * Value associated with the specific Module.
 *
 * @author Leighton Burgoyne
 * @version 1.0 04/10/2021
 */
public class Module
{
    // A unique identifier for the Module
    private int moduleCode; 
    // The name for the Module
    private String moduleTitle;
    // The credit value specified for the Module
    private int moduleValue;

    /**
     * Constructor for objects of class Module
     */
    public Module()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
