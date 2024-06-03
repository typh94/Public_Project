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
	public  static 	int 	cntRun     		= 1  ;                      //class variable
	public  static  Scanner keyboard        = new Scanner(System.in);  //class variable
	
	private 		String 	fName 			= "" ;
	private	 		String	lName 			= "" ;
	private 		String 	tenure 			= "" ;
	private 		String 	dprtmnt 		= "" ;
	private 		String 	sprvsrLName	 	= "" ;
	private 		String 	majorCode 		= "" ;
	private 		double 	currentGPA 		= 0.0;
	private 		double 	payRate 		= 0.0;

	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
	//---- default constructor  ----------------------------------------------------------
	public Person()
	{
	}
	
	//---- defined constructor : PERSON --------------------------------------------------
	public Person(String fName, String lName)
	{
 		this.fName 		  = fName	  ;
		this.lName 		  = lName     ;
	}
	
	//---- defined constructor : FACULTY -------------------------------------------------
	public Person(String fName, String lName, String dprtmnt, double payRate, String tenure)
	{
		this.tenure 	  = tenure    ;
  		this.dprtmnt 	  = dprtmnt   ;
		this.payRate 	  = payRate   ;
 	}
 	
	//---- defined constructor : STUDENT -------------------------------------------------
 	public Person( String majorCode, double currentGPA)
	{
  		this.majorCode	  = majorCode ;
		this.currentGPA   = currentGPA;
 	}

	//---- defined constructor: STAFF ---------------------------------------------------
 	public Person(String dprtmnt, String sprvsrLName, double payRate)
	{
  		this.dprtmnt	 = dprtmnt    ;
		this.payRate 	 = payRate    ;
		this.sprvsrLName = sprvsrLName;
 	}

	//------------------------------------------------------------------------------------ 
	//			 SETS 
	//------------------------------------------------------------------------------------ 
	public void setFName(String fName)
	{
		this.fName = fName;
	}
	
	public void setLName(String lName)
	{
		this.lName = lName;
	}
	
	//------------------------------------------------------------------------------------ 
	//			 GETS 
	//------------------------------------------------------------------------------------ 
	public String getFName()
	{
		return fName;
	}
	
	public String getLName()
	{
		return lName;
	}

	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS 
	//------------------------------------------------------------------------------------ 
	
	//------------------------------------------------------------------------------------ 
	//			 getInfo()  
	//------------------------------------------------------------------------------------ 
	public void getInfo() 
	{	
		System.out.print("\t First Name      : ");
		this.fName = keyboard.next();

		System.out.print("\t Last  Name      : ");
		this.lName = keyboard.next();
		
	}//end getInfo()
	
	//------------------------------------------------------------------------------------ 
	//			 validate()  
	//------------------------------------------------------------------------------------ 
    public boolean validate(double num, double inLow, double inHigh) 
    {
        return num >= inLow && num <= inHigh;
    }    
    
	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";
		
		msg        = "\n[" + ( cntRun++ )    + "] \t "   + 
				     lName.toUpperCase()     + ", "      + " "               + 
				     fName.substring(0,1).toUpperCase()  + fName.substring(1);
 
 		return msg;
	
	}//end toString()
} // end Person class

//===============================================================================================
//				subclass1 : Student
//===============================================================================================
  class Student  extends Person
{
	//------------------------------------------------------------------------------------ 
	//			 VARIABLES
	//------------------------------------------------------------------------------------ 
 	public          String    majorCode      = "";
	private         double    currentGPA     = 0 ;

	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
	//---- default constructor  ----------------------------------------------------------
	public Student() 
	{
	    super()  ; 
		getInfo();  
	}
	
	//---- defined constructor  ----------------------------------------------------------
	public Student(String fName, String lName, String majorCode, double currentGPA) 
	{
		super(fName, lName)         ;  
   	    this.majorCode  = majorCode ;
 		setGpa(currentGPA)	        ;
	}
	
	//------------------------------------------------------------------------------------
	//			 SET & GET : gpa
	//------------------------------------------------------------------------------------
 	public void setGpa(double currentGPA)
	{
	    while (!validate(currentGPA, 0.0, 4.0)) 
	    {
            System.out.print("\t\t" + currentGPA + " is an incorrect value. \n\t\tValid values: 0.0 - 4.0: ");
             currentGPA = keyboard.nextDouble();  
        }//end while
        this.currentGPA = currentGPA;
 	}//end setGpa()
	
	public double getGpa()
	{
		return currentGPA;
	}
	
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS 
	//------------------------------------------------------------------------------------ 
	
	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg  = "";
		msg         = super.toString();
 
		msg        +=  "\n\t Major           : " +  majorCode.substring(0,1).toUpperCase() +
										            majorCode.substring(1)                 +
					   "\n\t GPA             : " + currentGPA                              ;
		return msg;
	
	}//end toString()
} // end Student class

//===============================================================================================
//								subclass2 : CollegeEmployee
//===============================================================================================
  class CollegeEmployee  extends Person
{
	//------------------------------------------------------------------------------------ 
	//			 VARIABLES
	//------------------------------------------------------------------------------------ 
	private  String    dprtmnt  = "" ;
	private  double    payRate  = 0.0;
	private   String    payType  = "" ;

	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
	//---- default constructor -----------------------------------------------------------
	public CollegeEmployee()
	{
	}
 
	//---- defined constructor: Faculty --------------------------------------------------
	public CollegeEmployee(double payRate, String fName, String lName,String dprtmnt , String payType)
	{
		super(fName, lName)    ;
		this.dprtmnt = dprtmnt ;
 		this.payRate = payRate ;
 		
		this.payType      = "Yearly" ;
	}
	
	//---- defined constructor: Staff ----------------------------------------------------
	public CollegeEmployee(String fName, String lName,String dprtmnt, double payRate, String payType)
	{
		super(fName, lName)    ;
		this.dprtmnt = dprtmnt ;
		this.payRate = payRate ;
		this.payType      =  "Hourly";
	}
	
	//------------------------------------------------------------------------------------ 
	//			 SETS 
	//------------------------------------------------------------------------------------ 
 	public void setSalary(double payRate)
	{
		this.payRate = payRate;
		
	}
 	public void setDprtmnt(String dprtmnt)
	{
		this.dprtmnt = dprtmnt;
		
	}
 	public void setPayType(String payType)
	{
	this.payType = payType;
		
	}
	
	//------------------------------------------------------------------------------------ 
	//			 GETS 
	//------------------------------------------------------------------------------------ 
	public double getSalary()
	{
		return payRate;
	}
	
	public String getDprtmnt()
	{
		return dprtmnt;
	}
	
	public String getPayType()
	{
		return payType;
	}
	
	//------------------------------------------------------------------------------------ 
	//			 FUNCTIONS 
	//------------------------------------------------------------------------------------ 
	
	//------------------------------------------------------------------------------------ 
	//			 getCollegeEmpINFO() 
	//------------------------------------------------------------------------------------ 
	public void getCollegeEmpINFO() 
	{	
 		System.out.print("\t Department      : ")    ;
		this.dprtmnt 	= keyboard.next()            ;
	
		if (this.payType.equals("Hourly")) 
		{
       	 	System.out.print("\t Hourly Rate     : ");
       	 	payRate 	= keyboard.nextDouble()      ;
 			setPayRate(payRate, 7.25, 18.00)		 ;
 		//	this.payRate = payRate;
    	}//end if 
    	else 
    	{
        	System.out.print("\t Annual Rate     : ");
 			payRate 	= keyboard.nextDouble()      ;
        	setPayRate(payRate, 10000.0, 70000.0)    ;
    	}//end else
    	
	}//end getCollegeEmpINFO() 
	
	//------------------------------------------------------------------------------------ 
	//			 setPayRate() 
	//------------------------------------------------------------------------------------ 
	public void setPayRate(double payRate, double inLow, double inHigh)
	{
	    while (!validate(payRate, inLow, inHigh)) 
	    {
            System.out.print("\t\t" + payRate + " is an incorrect value. \n\t\tValid values: " + 
            	     inLow + " - "  + inHigh  + "\n\t Re-Enter        : "                     );
             payRate = keyboard.nextDouble(); 
             
        }//end while loop
		this.payRate = payRate;
		
	}//end setPayRate()

	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";
		msg        = super.toString();
		
		msg       +=  "\n\t Department      : "        + dprtmnt.substring(0,1).toUpperCase() + 
					  dprtmnt.substring(1) +  "\n\t "  + payType                              + 
					  " Salary   : $"                  + payRate                              ;
		return msg;
	
	}//end toString()
} // end CollegeEmployee class

//===============================================================================================
//								subclass3 : Faculty
//===============================================================================================
  class Faculty  extends CollegeEmployee
{
	//------------------------------------------------------------------------------------
	//			 VARIABLES
	//------------------------------------------------------------------------------------
	private String    tenure            = "" ;
	//public  String    payType           = "Annual" ;
	//------------------------------------------------------------------------------------
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
	//----- default constructor ---------------------------------------------------------- 
	public Faculty( )
	{
	}
	
	//----- defined constructor ---------------------------------------------------------- 
	public Faculty(String fName, String lName, String dprtmnt, double annualRate, String tenure, String payType)
	{
		super(annualRate, fName, lName, dprtmnt, payType);
 		this.tenure = tenure;  
	}
	
	//------------------------------------------------------------------------------------
	//			 SET & GET : tenure
	//------------------------------------------------------------------------------------
 	public void setTenure(String tenure)
	{
		this.tenure = tenure;
	}
 	
 	public String getTenure()
	{
		return tenure;
	}

	//------------------------------------------------------------------------------------
	//			 FUNCTIONS 
	//------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------ 
	//			 getTenureINFO()  
	//------------------------------------------------------------------------------------ 
	public void getTenureINFO() 
	{	
 		System.out.print("\t Tenure          : ");
		this.tenure 		= keyboard.next()    ;
 		
	}//end getTenureINFO()
	
	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = ""              ;
		msg        = super.toString();
		
		msg       +=   "\n\t Tenure          : " + tenure ;
 
 		return msg;
	
	}//end toString()
} // end Faculty class

//===============================================================================================
//								subclass4 : Staff
//===============================================================================================
  class Staff  extends CollegeEmployee
{
	//------------------------------------------------------------------------------------
	//			 VARIABLES
	//------------------------------------------------------------------------------------
	private String sprvsrLName = "";
 
 	//------------------------------------------------------------------------------------ 
	//			 CONSTRUCTORS
	//------------------------------------------------------------------------------------ 
	//----- default constructor ---------------------------------------------------------- 
	public Staff( )
	{
	}
	
	//----- defined constructor ---------------------------------------------------------- 
	public Staff(String fName, String lName, String dprtmnt, double hourlyRate , String sprvsrLName, String payType)
	{
 		super(fName, lName, dprtmnt, hourlyRate, payType);
 		this.sprvsrLName = sprvsrLName          ;
	}

	//------------------------------------------------------------------------------------
	//			 SET & GET : supervisor last name 
	//------------------------------------------------------------------------------------
	public void setSprvsrLName(String sprvsrLName)
	{
		this.sprvsrLName = sprvsrLName;
	}
	
 	public String getSprvsrLName()
	{
		return sprvsrLName;
	}
	
	//------------------------------------------------------------------------------------
	//			 FUNCTIONS 
	//------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------ 
	//			 getSupLastNameINFO() 
	//------------------------------------------------------------------------------------ 
	public void getSupLastNameINFO() 
	{
 		System.out.print("\t Supervisor      : ");
		this.sprvsrLName = keyboard.next()       ;
		
	}//end getSupLastNameINFO()

	//------------------------------------------------------------------------------------ 
	//			 toString()
	//------------------------------------------------------------------------------------ 
	public String toString()
	{
		String msg = "";
		msg        = super.toString();
		
		msg       +=   "\n\t Supervisor      : " +  sprvsrLName.substring(0,1).toUpperCase() + 
												    sprvsrLName.substring(1  )               ;
 		return msg;
	
	}//end toString()
 } // end Faculty class