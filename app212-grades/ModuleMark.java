
/**
 * Write a description of class ModuleMark here.
 *
 * @author Derek Peacock and Nicholas Day
 * @author Modified by Leighton Burgoyne
 * @version 2.0 26/10/2021
 */
public class ModuleMark
{
    private int mark;
    private Module module;
    
    /**
     * Constructor for objects of class ModuleMark
     * 
     * @param Module module
     */
    public ModuleMark(Module module)
    {
        mark = 0;
        this.module = module;
    }
    
    /**
     * Retrieves the Value of a ModuleMark by returning the mark within it to the user
     * 
     * @return mark
     */
    public int getValue()
    {
        return mark;
    }
    
    /**
     * If the mark is 40% or more then the student is awarded the module's credit.
     * 
     * @return 0
     * @return Module.CREDIT
     */
    public int getCredit()
    {
        if(mark <= Grades.F.getValue())
        {
            return 0;
        }
        else
        {
            return Module.CREDIT;
        }
    }
    
    public void setMark(int mark)
    {
        this.mark = mark;
    }
    
    /**
     * Retrieves the Module Information
     * 
     * @return module
     */
    public Module getModule()
    {
        return module;
    }
    
    /**
     * Print the module details and any credit that has been awarded.
     */
    public void print()
    {
        module.print();
        System.out.print("\t  " + getCredit() + "\t" + mark);
    }
}
