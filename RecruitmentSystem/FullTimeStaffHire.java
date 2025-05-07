
/**
 *  This is the code of class FullTimeStaffHire here.
 * FullTimeStaffHire class is also one of the subclass of the StaffHire class.
 * It has total of 10 parameters where 2 new Attributes plus inherited 8 parameters from the SuperClass.
 *
 * @author (Sumaiya Kadir Akhy)
 * @version (11/03/2025)
 */
public class FullTimeStaffHire extends StaffHire
{
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int theVacancyNumber, String theDesignation, String theJobType, String theStaffName, String theJoiningDate, String theQualification, String theAppointedBy, boolean theJoined,double theSalary, int hours)
    {
        super (theVacancyNumber,theDesignation,theJobType,theStaffName,theJoiningDate,theQualification,theAppointedBy,theJoined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // here starts accessor methods:
    public double getSalary()
    {
        return salary;
    }

    public int getWeeklyFractionalHours()
    {
        return weeklyFractionalHours;
    }

    //this code will update salary if staff member has joined:
    public void setSalary(double newSalary)
    {
        if (super.isJoined()==true){
            this.salary = newSalary;
            System.out.println(super.getStaffName()+"'s salary has been updated successfully");
        }
        else{
            System.out.println("No Staff is appointed yet.");
        }
    }

    // this will update weekly working hours for the staff member:
    public void setWeeklyFractionalHours(int newHours)
    {
        if (super.isJoined()==true){
            this.weeklyFractionalHours = newHours;
            System.out.println("Working hours has been updated to "+ newHours);
        }
        else{
            System.out.println("No Staff is appointed yet.");
        }
    }

    //Displays all details including inherited attributes from StaffHire:
    @Override
    public void display()
    {
        super.display();
        //Salary details will only shown if staff has joined:
        if (super.isJoined()==true)
        {
            System.out.println("Salary: £" + salary);
            System.out.println("Weekly Hours: "+ weeklyFractionalHours);
        }
        else{
            System.out.println("No Staff is appointed yet.");
        }
    }
}
