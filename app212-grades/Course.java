import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock and Nicholas Day
 * @author Modified by Leighton Burgoyne
 * @version 2.0 26/10/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("BT1CTG1", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     * 
     * @param String code
     * @param String title
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the modules list for testing purposes. 
     * These must be your four modules. This allows for quick testing, by creating
     * a method which will create all of our modules at once, instead of typing them
     * out on an individual basis, allowing us to focus on the testing element.
     */
    public void createModules()
    {
        // Define the Modules for Testing Purposes
        Module co450 = new Module("CO450", "Computer Architectures");
        Module co452 = new Module("CO452", "Programming Concepts  ");
        Module co454 = new Module("CO454", "Digital Technologies  ");
        Module co456 = new Module("CO456", "Website Development   ");
        
        // Add the Modules to the 'modules' ArrayList
        modules.add(co450);
        modules.add(co452);
        modules.add(co454);
        modules.add(co456);
    }
    
    /**
     * Adds the Module to the specified course code, allowing for them to be linked.
     * 
     * @param Module module
     */
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * Converts the collated Marks to a Grade based on the boundaries specified in the Grades Class.
     * 
     * @param int mark
     * @return Varied based on Data (Grades.F, Grades.D, Grades.C, Grades.B, Grades.A, Grades.NS)
     * 
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 1 && mark <= 39) // Grade F Boundary (Marks 1-39)
            return Grades.F;
            
        else if(mark >= 40 && mark <= 49) // Grade D Boundary (Marks 40-49)
            return Grades.D;
            
        else if(mark >= 50 && mark <= 59) // Grade C Boundary (Marks 50-59)
            return Grades.C;
            
        else if(mark >= 60 && mark <= 69) // Grade B Boundary (Marks 60-69)
            return Grades.B;
            
        else if(mark >= 70 && mark <= 100) // Grade A Boundary (Marks 70-100)
            return Grades.A;
            
        else // Grade NS Boundary (Mark 0 or Invalid Input not in specified range)
            return Grades.NS; 
    }
    
    /**
     * Calculate the average mark from the four module marks and convert that into a final grade.
     * 
     * @param ArrayList<ModuleMark> marks
     * @return finalGrade
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int markTotal = 0; // Temporary Variable for the combined total of all Module Marks.
        int finalMark = 0; // Temporary Variable for the Final Calculated Mark
        
        for(ModuleMark mark : marks)
        {
            markTotal = markTotal + mark.getValue();
        }
        
        finalMark = markTotal / MAXN_MODULES; // Split the combined total over the number of modules
        finalGrade = convertToGrade(finalMark);
        
        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the four modules associated with the course.
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's list of modules, in the requirements this is set to four, 
     * however by using a 'for' loop, there is no specific number, allowing for 
     * versatility and further scope for more modules if required.
     */
    public void printModules()
    {
        System.out.println("Course Modules:");
        for (Module module : modules)
        {
        module.print();
        module.printCredit();
        }
    }
}
