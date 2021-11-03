import java.util.*;
import java.util.Random; // Used within AwardTestMarks to issue a randomized mark to each module.
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @author Modified by Derek Peacock & Nicholas Day, Leighton Burgoyne
 * @version 2.0 26/10/2021
 */
public class Student
{
    // The student ID
    private int id;
    // The student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    // The marks awarded for the modules on the course
    private ArrayList<ModuleMark> marks;
    // The random generated marks for testing purposes
    private Random randomMark;
    /**
     * This constructor creates a new student with a
     * fixed name and id. 
     */
    public Student()
    {
        this("Leighton Burgoyne", 22045432);
    }
    
    /**
     * Create a new student with a given name and ID number.
     * 
     * @param String name
     * @param int id
     */
    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        randomMark = new Random();
        marks = new ArrayList<ModuleMark>();
    }

    /**
     * Associates the student with a specific ModuleMark entry.
     * 
     * @param ModuleMark mark
     */
    public void addMark(ModuleMark mark)
    {
        marks.add(mark);
    }
    
    /**
     * Find the module by the moduleCode and set its mark to the value
     * 
     * @param String moduleCode
     * @param int markInput
     */
    public void awardMark(String moduleCode, int markInput)
    {
        // Unsure if this Method is needed, due to it being similar to AddMark, and SetMark in ModuleMark
        // Due to Testing, the marks data is currently randomised by the awardTestMarks() method.
    }
    
    /**
     * Set the Student onto a specific course (enrol)
     * 
     * @param Course course
     */
    public void enrol(Course course)
    {
        this.course = course;
        awardTestMarks();
    }
    
    /**
     * Award a different pass mark for each of the modules on the enrolled course for testing purposes.
     */
    public void awardTestMarks()
    {   
        for(Module module : course.modules)
        {
           ModuleMark mark = new ModuleMark(module);
           mark.setMark(randomMark.nextInt(100));
           
           marks.add(mark);
        }
    }
    
    /**
     * Return the full name of this student.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the student ID of this student.
     * 
     * @return id
     */
    public int getID()
    {
        return id;
    }

        
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + ", " + name);
    }
    
    /**
     * Prints out Course Information from the course class, including modules and course codes.
     */
    public void printCourse()
    {
        this.print();
        course.print();
    }
    
    /**
     * Prints out Module Information, such as the Marks, Credits and Grades given for each module.
     */
    private void printModules()
    {
        for(ModuleMark moduleMark : marks)
        {
            moduleMark.print();
            System.out.println("\t" + course.convertToGrade(moduleMark.getValue()));
        }
    }
    
    /**
     * Prints the Student Transcript showing full course data and the associated modules and grade data on an individual basis.
     */
    public void printTranscript()
    {
        System.out.println(" ------------------------------------");
        System.out.println(" App21-02: Exam Board Transcript 2021");
        System.out.println("        by Leighton Burgoyne");
        System.out.println(" ------------------------------------");
        
        printCourse();
        
        System.out.println();
        System.out.println();
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        System.out.println(" Code \t Module \t Credit \t Mark \t Grade");
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        
        printModules();
       
        Grades finalGrade = course.calculateGrade(marks);
        
        System.out.println();
        System.out.println();
        
        if(finalGrade == Grades.NS)
        {
            System.out.println(" No Final Course Grade Available");
        }
        else
        {
            System.out.println(" Final Course Grade = " + finalGrade);
        }
    }
}