
/**
 * This is the code for StaffHire class.
 * StaffHire is the Superclass for the RecruitmentSystem.
 * It has total 8 attributes.
 * @author (Sumaiya Kadir Akhy)
 * @version (11/03/2025)
 */

public class StaffHire
{
    //Attributes
    private int vacancyNumber;
    private String designationType;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined=false;
    
    //Constructor method for StaffHire
    public StaffHire(int theVacancyNumber, String theDesignation, String theJobType, String theStaffName, String theJoiningDate, String theQualification, String theAppointedBy, boolean theJoined)
    {
        vacancyNumber= theVacancyNumber;
        designationType = theDesignation; 
        jobType = theJobType;
        staffName = theStaffName;
        joiningDate = theJoiningDate;
        qualification = theQualification;
        appointedBy = theAppointedBy;
        joined = theJoined;
    }
    
    // Accessor method also known as Getters
    public int getVacancyNumber()
    { 
        return vacancyNumber;
    }
    
    public String getDesignationType()
    {
        return designationType;
    }
    
    public String getJobType()
    {
        return jobType;
    }
    
    public String getStaffName()
    {
        return staffName;
    }
    
    public String getJoiningDate()
    {
        return joiningDate;
    }
    
    public String getQualification()
    {
        return qualification;
    }
    
    public String getAppointedBy()
    {
        return appointedBy;
    }
    
    public boolean isJoined()
    {
        return joined;
    }
    
    //Mutator methods also known as Setters
    public void setVacancyNumber(int vacancy)
    {
        vacancyNumber = vacancy; 
    }
    
    public void setDesignationType(String designation)
    {
        designationType = designation;
    }
    
    public void setJobType(String job)
    {
        jobType = job;
    }
    
    public void setStaffName(String name)
    {
        staffName = name;
    }
    
    public void setJoiningDate(String joinDate)
    {
        joiningDate = joinDate;
    }
    
    public void setQualification(String qualified)
    {
        qualification = qualified;
    }
    
    public void setAppointedBy(String appointby)
    {
        appointedBy = appointby;
    }
    public void setJoined(boolean join)
    {
        joined = join;
    }
    
    //This is the display method to display all Staff Hire details:
    public void display()
    {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation Type: " + designationType);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: "+ qualification);
        System.out.println("Appointed By: "+ appointedBy);
        System.out.println("Joined: " +(joined ? "Yes" : "No"));
    }
    //this is the method to Update the joined status:
    public void AmmendJoinStatus(boolean newJoinStatus)
    {
            joined= newJoinStatus;
            System.out.println("Join Status Updated to: " + (newJoinStatus ? "Employed" : "Not Employed"));
        }
    } 
