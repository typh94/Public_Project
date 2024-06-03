//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 30, 2024
//  Assign:                                                 A22: Inheritance Applied
//  Program: CollegeListDriver
//  Purpose:
//
//===============================================================================================
import  java.util.*;           
public class CollegeListV2
{
	//---- CLASS Variables ----------------------------------------------------------------
	public static Scanner keyboard = new Scanner(System.in);
 
	//------------------------------------------------------------------------------------
	// 						main()
	//------------------------------------------------------------------------------------
	public static void main(String [] arg)
	{
 		 //---- Variables -----------------------------------------------------------------
		Person[]    personArray     = new Person[14]; //create an array
 		
 		String 		userSelection 	= "";
 		
  		int		 	i				= 0 ,
 					cntStaff 		= 0 ,
 					cntFaculty	 	= 0 ,
 					cntStudent 		= 0 ;

 		boolean 	isValid 		= false;
 		
 		//---- welcome message -----------------------------------------------------------
		System.out.println("\n - - - Cool State College - - -  ");
		System.out.println("       Data Collection System      ");
		
		displayMenu()  ; //display menu
 		isValid = true ; //set flag
		
        Scanner scanner = new Scanner(System.in);
    
    	//----- processing ---------------------------------------------------------------
 	  	while (isValid) 
	  	{
			System.out.print("\nData for (A, F, S) or Q (quit) : ");
			userSelection = keyboard.next()						   ;

			switch (userSelection.toUpperCase()) 
			{
				case "A":
					if (cntStaff < 3) 
 					{
						personArray[i] = new Staff()  ;
						cntStaff++					  ;
						i++							  ;
					} 
					else 
					{
						displayError(personArray)	  ;
						isValid = false			 	  ;
					}
					break							  ;
					
				case "F":
					if (cntFaculty < 2 ) 
					{
						personArray[i] = new Faculty();
						cntFaculty++				  ;
						i++							  ;
					} 
					else 
					{
						displayError(personArray)	  ;
						isValid = false				  ;
					}
					break							  ;
					
				case "S":
					if (cntStudent < 5) 
					{
						personArray[i] = new Student();
						cntStudent++				  ;
						i++						      ;
					} 
					else 
					{
						displayError(personArray)	  ;
						isValid = false				  ;
					}
					break							  ;
					
				case "Q":
					System.out.println("\n = = = Cool State College = = = \n  "    +
									   "  Current People on Campus            "   );
					displayAll(personArray)               	 					   ;
					isValid = false												   ;
					break											   			   ;
					
				default:
					break;
					
			}//end switch
		}//end while 
		
 		//---- end message -------------------------------------------------------------------
		System.out.println("\n - - - Pgm Ended Successfully - - -  ");

	}//end main 
	
	//--------------------------------------------------------------------------------
	// 						FUNCTIONS 
	//--------------------------------------------------------------------------------
	
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
	public static void displayAll(Person[] personArray )
	{
	 	for(int i = 0; i < personArray.length; i++)
	 	
			if (personArray[i] != null) 
				System.out.println(personArray[i].toString() );
 	}//end displayAll()()
 	
 	//--------------------------------------------------------------------------------
	// 						displayError()
	//--------------------------------------------------------------------------------
	public static void displayError(Person[] personArray  )
	{
		System.out.println("\n> > >   Error: Limit Reached   < < < " +
					       "\n = = = Cool State College = = = "  + 
	 					   "\n    Current People on Campus "    );
    	displayAll(personArray);
 	}//end displayError()()
 	
}//. . end CollegeListDriver . .
 