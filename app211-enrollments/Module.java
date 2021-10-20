
/**
 * The Module Class includes a variety of information on the Modules and 
 * Individual Topics, which are associated with a specific course; this
 * includes the Module Code (Identifier), Module Title, and the Credits
 * Value associated with the specific Module.
 *
 * @author Leighton Burgoyne
 * @version 1.0 08/10/2021
 */
public class Module
{
    private int x;
    // A unique identifier for the Module
    private String code; 
    // The name for the Module
    private String title;
    // The credit value for the Module
    private int credit;

    /**
     * Constructor for objects of class Module
     * 
     * @param String code
     * @param String title
     */
    public Module(String code, String title)
    {
        // Initialise variables, and set parameters
        this.code = code;
        this.title = title;
        credit = 0;
    }

    /**
     * This method will return the value of 'code'
     *
     * @return code
     */
    public String getCode()
    {
        // Return code
        return this.code;
    }
    
    /**
     * This method will return the value of 'title'
     *
     * @return title
     */

        public String getTitle()
    {
        // Return title
        return this.title;
    }
    
    /**
     * This method will return the value of 'credit'
     *
     * @param
     * @return credit
     */

        public int getCredit()
    {
        // Return credit
        return this.credit;
    }
    
    /**
     * This method will set the value of credit
     * 
     * @param int credit
     * @return credit
     */
    
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print out the Module Details
     */
    
    public void printModule()
    {
        System.out.println("Module Code: " + code + ": " + title);
        System.out.println();
    }
    
    
}
