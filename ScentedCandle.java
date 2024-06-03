//==============================================================================================
//  Author:   Typhene Benfriha                              csc-111   A
//  Date Due: April. 24, 2024
//  Assign:                                                 A21: Inheritance
//  Program: ScentedCandle
//  Purpose:
//
//===============================================================================================
import java.text.*;
public class ScentedCandle extends Candle
{
	//==================================================================================
	//               Variables
	//==================================================================================

	//----------   Class variables  --------------------------------------------------
	public static double     BEES_WAX = 3.50;
	public static double     CARNAUBA = 4.25;
	public static double     PARAFFIN = 3.00;

	//----------   Instance variables ------------------------------------------------
	private    String       scent    = "";
	private    int          waxType  = 0 ;
	private    int          theme    = 0 ;    

	//----------   NO constructor ---------------------------------------------------
	
	//================================================================================
	//               SETs
	//================================================================================
	public void setScent(String scent)
	{
		this.scent = scent;
	}

	public void setWaxType(int waxType)
	{
		this.waxType = waxType;
	}
	
	public void setColor(String color)  //child set color
	{
    	super.setColor("Dark " + color); // Use the setter method to set the color
 	}
 	
	public void setTheme(int theme)
	{
		this.theme = theme;
	}

	//================================================================================
	//               GETs
	//================================================================================
	public String getScent( )
	{
		return scent;
	}

	public int getWaxType( )
	{
		return waxType;
	}
	
	public int getTheme( )
	{
		return theme;
	}

	//==================================================================================
	//               Functions
	//==================================================================================
 
	public void setHeight( ) 
	{
     	super.price = (height * waxCost() ); 
	}
	public void setHeight(int height) 
	{
    	super.setHeight(height);  
    	super.price = (height * waxCost() ); 
	}
	
	public String waxTypeStr()
	{
		String  waxStr = "";
		
		if(waxType == 1)
			waxStr = "BeesWax";
			
		else if(waxType == 2)
			waxStr = "Carnauba";
			
		else
			waxStr = "Paraffin";
			
		return waxStr;
	}
	
	public double waxCost()
	{
		double  cost = 0 ;
    	
  		if      (waxType == 1) //BeesWax
   	      	cost =  BEES_WAX;  	

   		else if (waxType == 2) //Carnauba
   		   	cost =   CARNAUBA;     	

   		else  				   //default 
    		cost = PARAFFIN;   
			
		return cost;
	}
	
	public String themeStr()
	{
    	String stringTheme = "";
    	
  		if      (theme == 1)  
			stringTheme = "Bobidi-Boo";
			
   		else if (theme == 2)  
			stringTheme = "Snowy-Night";

   		else if (theme == 3)			  
			stringTheme = "Purple-Sunset";
			
		else
			stringTheme = "None :(";
    		   
		return stringTheme;
	}
	
	public String display()
	{                                         
		String msg = "";
		
		msg = super.display();		//get parent data then add on and concatenate
		msg +=  "\n\n\t Scent     = " + scent        +
		      	"\n\t Wax       = " + waxTypeStr() + " wax"  +
		      	"\n\t Theme     = " + themeStr()   ;
 
		return msg;
	}

	//------------------------------------------------------------------------------------
	// 						 ()
	//------------------------------------------------------------------------------------

}//end class


