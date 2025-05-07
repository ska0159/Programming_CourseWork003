
/**
 * This is the code of class PartTimeStaffHire here which represents Part time Staff members.
 * ParTimeStaffHire class is one of the subclass of the StaffHire class.
 * It has total of 11 parameters where 4 new Attributes plus inherited parameters from Superclass.
 * @author (Sumaiya Kadir Akhy)
 * @version (11/03/2025)
 */
public class PartTimeStaffHire extends StaffHire
{
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    //PartTimeStaffHire Constructor method
    public PartTimeStaffHire(int theVacancyNumber, String theDesignation, String theJobType, String theStaffName, String theJoiningDate, String theQualification, String theAppointedBy, boolean theJoined,int hours, double wages, String theShifts)
    {
        //calls superclass method
        super(theVacancyNumber,theDesignation,theJobType,theStaffName,theJoiningDate,theQualification,theAppointedBy,theJoined);
        //initialze subclass specific attributes
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }
    
    //Accessor methods below (Getters):
    public int getworkingHour()
    {
        return workingHour;
    }
    
    public double getWagesPerHour()
    {
        return wagesPerHour;
    }
    
    public String getShifts()
    {
        return shifts;
    }
    
    public boolean isTerminated()
    {
        return terminated;
    }
    
    //this will check if a staff member has joined and will update the work shift:
    public void setShifts(String newShift)
    {
        if (super.isJoined() && !terminated)
        {
            this.shifts = newShift;
            System.out.println("Shift has been updated to "+newShift);
        }
        else if (terminated) {
            System.out.println("Error- Staff already terminated.");
        }
        else{
            System.out.println("No Staff is appointed yet, shifts cannot be set");
        }
    }
    
    // this will terminate staff member and clear all personal data:
    public void terminateStaff()
    {
        if (terminated)
        {
            System.out.println("Error- Staff is already terminated");
        }
        else{
            super.setStaffName("");
            super.setJoiningDate("");
            super.setQualification("");
            super.setAppointedBy("");
            super.setJoined(false);
            terminated = true;
            System.out.println("Staff is successfully terminated");
        }
    }
    
    //Displays all details including inherited attributes from StaffHire:
    @Override
    public void display()
    {
        super.display(); //calling superclass diplay method.
        if(terminated){
           System.out.println("Staff already terminated");
        }
        else if(super.isJoined() && !terminated) {
            System.out.println("Working Hours: "+ workingHour);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts: "+ shifts);
            System.out.println("Daily Income: "+ (wagesPerHour*workingHour));
        }
        else{
            System.out.println("Staff details will be displayed after staff joining");
        }
    }
}
