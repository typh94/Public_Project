//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 30, 2024
//  Assign:                                                 A22: Inheritance Applied
//  Program: Person , Student, College Employee, 
//		     Faculty, Staff
//  Purpose:
//
//===============================================================================================
import java.util.*;
//===============================================================================================
//								superlevel : Person
//===============================================================================================

class Person 
{
	//------------------------------------------------------------------------------------ 
	//			 VARIABLES
	//------------------------------------------------------------------------------------ 
	public  static 	int 	cntRun     		= 1  ;                      
    public  static  Scanner scanner         = new Scanner(System.in);

    private String firstName;
    private String lastName;

	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
    public Person() 
    {
        firstName = ""; // Initialize firstName with an empty string

        getInfo();
    }
	
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
   	
   	//------------------------------------------------------------------------------------ 
	//			 getInfo()
	//------------------------------------------------------------------------------------ 
    public void getInfo() 
    {
 		System.out.print("\t Last  Name      : ");
    	lastName = scanner.next();
    }//end getInfo()

   	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";

		msg        = "\n[" + ( cntRun++ )       + "] \t "   + 
				     this.lastName.toUpperCase()     + ", "      + " "               + 
				     this.firstName.substring(0,1).toUpperCase()  + this.firstName.substring(1);
 
 		return msg;
	}//end toString()

}//end Person class

//===============================================================================================
//				subclass1 : Student
//===============================================================================================
class Student extends Person 
{
	//------------------------------------------------------------------------------------ 
	//			 VARIABLES
	//------------------------------------------------------------------------------------ 
    private String majorCode;
    private double GPA;

	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
    public Student() 
    {
        super()         ;
        getStudentInfo();
    }
 
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
	
	//------------------------------------------------------------------------------------ 
	//			 getStudentInfo()
	//------------------------------------------------------------------------------------ 
    public void getStudentInfo() {

 		System.out.print("\t Major Code      : ");
        majorCode = scanner.next();
 		System.out.print("\t Current GPA     : ");
        GPA = scanner.nextDouble();
        // Add validation for GPA (0-4)
        while (GPA < 0 || GPA > 4) 
        {
            System.out.print("\t\t" + GPA + " is an incorrect value. \n\t\tValid values: 0.0 - 4.0: ");
            System.out.print("\n\t Re-Enter GPA: ");
            GPA = scanner.nextDouble();
        }
    }

    // Override toString to display student info
	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg  = "";
		msg         = super.toString();
 
		msg        +=  "\n\t Major           : " +  majorCode.substring(0,1).toUpperCase() +
										            majorCode.substring(1)                 +
					   "\n\t GPA             : " + GPA                              ;
		return msg;
	
	}//end toString()
}//end Student class 

//===============================================================================================
//				subclass2 : College Employee
//===============================================================================================
class CollegeEmployee extends Person 
{
    private String departmentName;
    private double salary;

    // Constructor
    public CollegeEmployee() {
        super();
        getEmployeeInfo();
    }
    
	public void setDprtmnt(String departmentName)
	{
		this.departmentName = departmentName;
	
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	
	}
	public String getDprtmnt( )
	{
		return departmentName;
	
	}
	public double getSalary( )
	{
		return salary;
	
	}

    // Get info from user for CollegeEmployee
    public void getEmployeeInfo() {
     //   Scanner scanner = new Scanner(System.in);
 		System.out.print("\t Department      : ")    ;
        departmentName = scanner.nextLine();
    }
    
    
    //------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";
		msg        = super.toString();
		
		msg       +=  "\n\t Department      : "        + departmentName.substring(0,1).toUpperCase() + 
					  departmentName.substring(1) +  "\n\t     Salary      : $" + salary ;
		return msg;
	
	}//end toString()

}
//===============================================================================================
//				sub-subclass1 : Faculty
//===============================================================================================
class Faculty extends CollegeEmployee {
    private boolean tenure;

    // Constructor
    public Faculty() {
        super();
        getFacultyInfo();
    }

    // Get info from user for Faculty
    public void getFacultyInfo() {
        Scanner scanner = new Scanner(System.in);

        // Prompt for annual salary for Faculty
        System.out.print("         Annual rate     : ");
       
       
        setSalary(scanner.nextDouble()); // Use the setter method
      //  salary = scanner.nextDouble();
        // Add validation for salary (10000-30000)
        while (getSalary() < 30000 || getSalary() > 70000) 
        
         {
            System.out.print("\t\t" + getSalary() + " is an incorrect value. \n\t\tValid values:  30000.0 - 70000.0"+
            "\n\t Re-Enter        : "                     );
            setSalary(scanner.nextDouble()); // Use the setter method
        }

        scanner.nextLine(); // Consume newline character

 		System.out.print("\t Tenure          : ");
        char response = scanner.next().charAt(0);
        tenure = (response == 'Y' || response == 'y'); //assigns flag to tenure (true == Yes)
    }    
    // Override toString to display faculty info
	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = ""              ;
		String msg2 = ""              ;
		msg        = super.toString();
		if(tenure)
			msg2 = "Tenure";
		else 
			msg2 = "Adjunct";
		msg       +=   "\n\t Faculty         : " + msg2 ;
 
 		return msg;
	
	}//end toString()

 }
//===============================================================================================
//				sub-subclass2 : Staff
//===============================================================================================
class Staff extends CollegeEmployee {
    private String supervisorName;

    // Constructor
    public Staff() {
        super();
        getStaffInfo();
    }

    // Get info from user for Staff
    public void getStaffInfo() {
        Scanner scanner = new Scanner(System.in);

        // Prompt for hourly salary for Staff
        System.out.print("\n         Hourly rate     : ");
            setSalary(scanner.nextDouble()); // Use the setter method
        // Add validation for hourly rate (7.25-18)
        while (getSalary() < 7.25 || getSalary() > 18) {
            System.out.print("\t\t" + getSalary() + " is an incorrect value. \n\t\tValid values:  7.25 - 18"+
            "\n\t Re-Enter        : "                     );
            setSalary(scanner.nextDouble()); // Use the setter method
        }

        scanner.nextLine(); // Consume newline character

 		System.out.print("\t Supervisor      : ");
        supervisorName = scanner.nextLine();
    }

	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";
		msg        = super.toString();
		
		msg       +=   "\n\t Supervisor      : " +  supervisorName.substring(0,1).toUpperCase() + 
												    supervisorName.substring(1  )               ;
 		return msg;
	
	}//end toString()
}
