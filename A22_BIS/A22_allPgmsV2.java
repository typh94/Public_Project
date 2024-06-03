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
	//---- Variables ---------------------------------------------------------------------
	public  static 	int 	cntRun     		= 1 				    ;                      
    public  static  Scanner scanner         = new Scanner(System.in);

    private String firstName;
    private String lastName;

	//---- Constructors ---------------------------------------------------------------------
    public Person() 
    {
        getInfo();
    }
	
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
   	
	//----- getInfo() --------------------------------------------------------------- 
    public void getInfo() 
    {
        System.out.print("\t First Name      : ");
    	firstName = scanner.next();

 		System.out.print("\t Last  Name      : ");
    	lastName = scanner.next();
    	
    }//end getInfo()

	//----- toString() --------------------------------------------------------------- 
	public String toString()
	{
		String msg = "";

    	if (firstName.length() > 0) 
    	
       		msg = "\n[" + (cntRun++)        + "] \t " +
                this.lastName.toUpperCase() +   ", "  + " "  +
                this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1) ;
   
 		return msg;
	}//end toString()

}//end Person class

//===============================================================================================
//				subclass1 : Student
//===============================================================================================
class Student extends Person 
{
	//---- Variables ---------------------------------------------------------------------
    private String majorCode;
    private double GPA;

	//---- Constructors ---------------------------------------------------------------------
    public Student() 
    {
        super()         ;
        getStudentInfo();
    }
 
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
	
	//----- getStudentInfo() --------------------------------------------------------------- 
    public void getStudentInfo() 
    {

 		System.out.print("\t Major Code      : ");
        majorCode = scanner.next();
        
 		System.out.print("\t Current GPA     : ");
        GPA = scanner.nextDouble();
        
        // Add validation for GPA (0-4)
        while (GPA < 0 || GPA > 4) 
        {
            System.out.print("\t\t" + GPA + " is an incorrect value. \n\t\tValid values: 0.0 - 4.0: " +
            				 "\n\t Re-Enter GPA: "                                                   );
            GPA = scanner.nextDouble();
        }
    }//end getStudentInfo() 

 	//----- toString() --------------------------------------------------------------- 
	public String toString()
	{
		String msg  = ""                        ;
		msg         = super.toString()          ;
 
   		msg 	    += "\n\t Major           : ";
   		
		if (majorCode.length() > 0) 
     		msg     += majorCode.substring(0, 1).toUpperCase() + majorCode.substring(1) + 
    		           "\n\t GPA             : "               + GPA                    ;
   
		return msg;
	
	}//end toString()
}//end Student class 

//===============================================================================================
//				subclass2 : College Employee
//===============================================================================================
class CollegeEmployee extends Person 
{
	//---- Variables ---------------------------------------------------------------------
    private String departmentName;
    private double salary;

	//---- Constructors ---------------------------------------------------------------------
    public CollegeEmployee() 
    {
        super();
        getEmployeeInfo();
    }
    
	//------------------------------------------------------------------------------------ 
	//			 SETS & GETS
	//------------------------------------------------------------------------------------ 
	public void setDprtmnt(String departmentName)
	{
		this.departmentName = departmentName;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	//-------------------------------------------- 
	public String getDprtmnt( )
	{
		return departmentName;
	}
	public double getSalary( )
	{
		return salary;
	}
  
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
	
	//----- getEmployeeInfo() --------------------------------------------------------------- 
 	public void getEmployeeInfo() 
 	{
  		System.out.print("\t Department      : ")    ;
		setDprtmnt(scanner.next());
		
    }//end getEmployeeInfo() 
    
	//----- toString() --------------------------------------------------------------- 
	public String toString()
	{
		String msg = ""								;
		msg        = super.toString()				;

   		msg		  += "\n\t Department      : "      ;
		if (departmentName.length() > 0) 
     		msg   += departmentName.substring(0, 1).toUpperCase() + departmentName.substring(1) + 
             		 "\n\t     Salary      : $" 				  + salary						;

 		return msg;
	}//end toString()

}//end College Employee Class

//===============================================================================================
//				sub-subclass1 : Faculty
//===============================================================================================
class Faculty extends CollegeEmployee 
{
	//---- Variables ---------------------------------------------------------------------
    private boolean tenure;

	//---- Constructors ------------------------------------------------------------------
    public Faculty() 
    {
        super()         ;
        getFacultyInfo();
    }
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 
	
	//----- getFacultyInfo() --------------------------------------------------------------- 
    public void getFacultyInfo() 
    {
    	//---- get Input -----------------------------------------------------------------
    	System.out.print("         Annual rate     : ");
        setSalary(scanner.nextDouble()); // Use the setter method

        // Add validation for salary (10000-30000)
        while (getSalary() < 30000 || getSalary() > 70000) 
        {
            System.out.print("\t\t" + getSalary() + " is an incorrect value. \n\t\tValid values: " +
           					 "  30000.0 - 70000.0 \n\t Re-Enter        : "                        );
            setSalary(scanner.nextDouble()); // Use the setter method
        }//end while
        
 		System.out.print("\t Tenure          : ");
        char response = scanner.next().charAt(0) ;
        tenure = (response == 'Y' || response == 'y'); //assigns flag to tenure (true == Yes)
    } //end getFacultyInfo() 
    
 	//----- toString() --------------------------------------------------------------- 
	public String toString()
	{
		String msg  = ""              ;
		String msg2 = ""              ;
		msg         = super.toString();
		
		if(tenure)
			msg2    = "Tenure"		  ;
		else 
			msg2    = "Adjunct"		  ;
			
		msg        += "\n\t Faculty         : " + msg2 ;
 
 		return msg;
	
	}//end toString()
 }//end Faculty class
 
//===============================================================================================
//				sub-subclass2 : Staff
//===============================================================================================
class Staff extends CollegeEmployee 
{
   	//---- Variables ---------------------------------------------------------------------
    private String supervisorName;
	
	//---- Constructors ------------------------------------------------------------------
    public Staff() 
    {
        super();
        getStaffInfo();
    }
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS
	//------------------------------------------------------------------------------------ 

	//----- getStaffInfo() --------------------------------------------------------------- 
     public void getStaffInfo() 
    { 
        //---- get Input -----------------------------------------------------------------
        System.out.print("         Hourly rate     : ");
        setSalary(scanner.nextDouble()); // Use the setter method
       
        // Add validation for hourly rate (7.25-18)
        while (getSalary() < 7.25 || getSalary() > 18) 
        {
            System.out.print("\t\t" + getSalary() + " is an incorrect value. \n\t\tValid values: " +
            				 " 7.25 - 18 \n\t Re-Enter        : "                                 );
            setSalary(scanner.nextDouble()); // Use the setter method
        }//end while
        
    	//---- get Input -----------------------------------------------------------------
 		System.out.print("\t Supervisor      : ");
        supervisorName = scanner.next();
        
    }//end getStaffInfo() 

	//----- toString() --------------------------------------------------------------- 
	public String toString()
	{
		String msg = "";
		msg        = super.toString();
		
		msg 	  += "\n\t Supervisor      : "    ;
		   		
		if (supervisorName.length() > 0) 
     		msg   += supervisorName.substring(0, 1).toUpperCase() + supervisorName.substring(1) ;
    
  		return msg;
	
	}//end toString()
	
}//end Staff Class
//end ALL PROGRAMS