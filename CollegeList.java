//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 30, 2024
//  Assign:                                                 A22: Inheritance Applied
//  Program: CollegeListDriver
//  Purpose:
//
//===============================================================================================
import  java.util.*;           
public class CollegeList
{
	//---- CLASS Variables ----------------------------------------------------------------
	public static Scanner keyboard = new Scanner(System.in);
	 	public static	int 		i 				= 0 ,
 				 	cntStaff 		= 0 ,
 					cntFaculty	 	= 0 ,
 					cntStudent 		= 0 ;


	//------------------------------------------------------------------------------------
	// 						main()
	//------------------------------------------------------------------------------------
	public static void main(String [] arg)
	{
 		Person[] personArray = new Person[14]; //instantiate array
 		
 		//---- Variables -----------------------------------------------------------------
 		String 		userSelection 	= "",
 					selection 		= "",
 				 	fName 			= "",
 			 		lName 			= "";	
 		int		 	cntStaff 		= 0 ,
 					cntFaculty	 	= 0 ,
 					cntStudent 		= 0 ;

 		boolean 	isValid 		= false;
 		
 		//---- welcome message -----------------------------------------------------------
		System.out.println("\n - - - Cool State College - - -  ");
		System.out.println("       Data Collection System      ");
		
		displayMenu()  ; //display menu
 		isValid = true ; //set flag
		
		//----- processing ---------------------------------------------------------------
 	  while (isValid) 
	  {
			System.out.print("\nData for (A, F, S) or Q (quit) : ");
			  userSelection = keyboard.next();

			switch (userSelection.toUpperCase()) 
			{
				case "A":
					if (cntStaff <= 3 && cntFaculty <= 2 && cntStudent <= 5) 
					{
						personArray[i] = processAdmin(personArray, "Admin Support's");
						if (personArray[i] != null) 
						{
							cntStaff++;
							i++;
						}
					} 
					else
					{
						System.out.println("\t > > > Error: Limit Reached < < < ");
						displayAll(personArray, i);
						isValid = false;
					}
					break;

				case "F":
					if (cntStaff <= 3 && cntFaculty < 2 && cntStudent <= 5) 
					{
						personArray[i] = processFaculty(personArray, "Faculty's");
						if (personArray[i] != null)
						{
							cntFaculty++;
							i++;
						}
					} 
					else 
					{
						System.out.println("\t > > > Error: Limit Reached < < < ");
						displayAll(personArray, i);
						isValid = false;
					}
					break;

				case "S":
					if (cntStaff <= 3 && cntFaculty <= 2 && cntStudent <= 5) 
					{
						personArray[i] = processStudent(personArray, "Student's");
						if (personArray[i] != null) 
						{
							cntStudent++;
							i++;
						}
					} 
					else 
					{
						System.out.println("\t > > > Error: Limit Reached < < < ");
						displayAll(personArray, i);
						isValid = false;
					}
					break;

				case "Q":
					displayAll(personArray, i);
					isValid = false;
					break;

				default:
					break;
			}
		}
 		//---- end message -------------------------------------------------------------------
		System.out.println("\n - - - Pgm Ended Successfully - - -  ");

	}//end main 
	
	//--------------------------------------------------------------------------------
	// 						displayMenu()
	//--------------------------------------------------------------------------------
	public static void displayMenu()
	{
		System.out.println("\nID each entry using the following: " +
						   "\n\t Admin Support  --> A " 		   +
						   "\n\t Faculty Member --> F "			   +
						   "\n\t Student        --> S " 		   +
						   "\n\t When finished  --> Q " 		  );
	}//end displayMenu()
	
	//--------------------------------------------------------------------------------
	// 						displayAll()
	//--------------------------------------------------------------------------------
	public static void displayAll(Person[] personArray , int cnt)
	{
	 	System.out.println("\n = = = Cool State College = = = "  + 
	 					   "\n    Current People on Campus "    );
	 					   
		//---- display summary for each person -------------------------------------------
		for(int i = 0; i < cnt; i++)
			System.out.println(personArray[i].toString() );
		
 	}//end displayAll()()
	
	//--------------------------------------------------------------------------------
	// 						processAdmin()
	//--------------------------------------------------------------------------------
	public static Person  processAdmin(Person[] personArray, String selection)
	{
 
		//--- display ----
  		System.out.println(selection + ". ."    );
  		
  		//---- instantiate -------
 		Person          person      = new Person()         ;
		Staff           staff 		= new Staff()          ;
		CollegeEmployee collegeEmp  = new CollegeEmployee();
		
  		//------ I/P -----------------------------------------------------------
 		person.getInfo()              ;
		collegeEmp.getCollegeEmpINFO();
 		staff.getSupLastNameINFO()    ;
 		String payType = "Hourly";
 		//--- create current object (tbhen added to PersonArray)
   		Staff newStaff =  new Staff(person.getFName(), person.getLName(), collegeEmp.getDprtmnt(), 
   								    collegeEmp.getSalary(), staff.getSprvsrLName()      , payType  );
   		
  		return newStaff;

	}//end processAdmin()
	
	//--------------------------------------------------------------------------------
	// 						processFaculty()
	//--------------------------------------------------------------------------------
	public static Person processFaculty(Person[] personArray, String selection)
	{
		//--- display ----
  		System.out.println(selection + ". ."    );
  		 
  		//---- instantiate -------
 		Person          person      = new Person()         ;
 		CollegeEmployee collegeEmp  = new CollegeEmployee();
		Faculty         faculty     = new Faculty()        ;
		
	//	if(cntFaculty<3)
		{
		//------ I/P -----------------------------------------------------------
 		person.getInfo()              ;
		collegeEmp.getCollegeEmpINFO();
 		faculty.getTenureINFO()       ;
 		} 
 		//else 
 		
 		 		String payType = "Yearly";

 		//--- create current object (then added to PersonArray)
  		Faculty faculty1 =  new Faculty(person.getFName() , person.getLName(), collegeEmp.getDprtmnt(), 
  								        collegeEmp.getSalary() , faculty.getTenure()   , payType              );
 
  		return faculty1;
 
 	}//end processFaculty()
 	
 
	//--------------------------------------------------------------------------------
	// 						processStudent()
	//--------------------------------------------------------------------------------
	public static Person processStudent(Person[] personArray, String selection)
	{
	 	//---- Variables ------------------------
		String	 	fName 				= "" ,
 			 		lName 				= "" ,
 			 		majorCode 			= "" ;
  		double		currentGPA 			= 0.0;

		//--- display ----
  		System.out.println(selection + ". ."    );
  
  		//---- instantiate -------
		Person person = new Person();
		
		//------ I/P -----------------------------------------------------------
		person.getInfo()            ;
		
 		System.out.print("\t Major Code      : ");
		majorCode 	= keyboard.next();
		
 		System.out.print("\t Current GPA     : ");
		currentGPA 	= keyboard.nextDouble()      ;
		
  		Student newStudent =  new Student( person.getFName(), person.getLName(), majorCode, currentGPA);
 
 		return newStudent;
				   
	}//end processStudent()
}// end CollegeListDriver


 