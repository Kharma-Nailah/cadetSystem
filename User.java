package theUsers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class User
{//start class
	//attributes
	private String Rank;
	private String fName;
	private String lName;
	private String mName;
	//private String DOB;
	private String unit;
	private String StarLev;
	private String registrationNum;
	//private static String[] info;
	private char gender;
	
	
	User(String Rank, String fName, String lName,String mName,String registrationNum)
	{
		this.Rank=Rank;
		this.fName=fName;
		this.lName=lName;
		this.mName=mName;
		this.registrationNum=registrationNum;

	}
	
	public static void main (String[]args)
	{
		//take user info
		System.out.println("Welcome to the jccf E-Learning Platform.\n\n");
		//list to store user info
		ArrayList<String> info=new ArrayList<String>();
		
		System.out.println("Please enter your Rank.\n");
		Scanner Rank=new Scanner(System.in);		
		info.add(Rank.next());
		
		System.out.println("Please enter your first name.\n");
		Scanner fName=new Scanner(System.in);
		info.add(fName.next());
		
		System.out.println("Please enter your last name.\n");
		Scanner lName=new Scanner(System.in);
		info.add(lName.next());
		
		System.out.println("Please enter your middle name.\n");
		Scanner mName=new Scanner(System.in);
		info.add(mName.next());
		
		System.out.println("Please enter your Cadet Unit's name.\n");
		Scanner unit=new Scanner(System.in);
		info.add(unit.next());
		
		System.out.println("Please enter your current start level.\n");
		Scanner StarLev=new Scanner(System.in);
		info.add(StarLev.next());
					
				
		System.out.println(info);
				
		//id number generator
				/*if (Rank.equals("Cdt"))
						{
					    int odd[]= {1,3,5,7,9};
						UUID Id=UUID.randomUUID();
						
						}*/
	}
	
	//getter functions
	public String getFirstName()
	{
		return fName;
	}

			
		public String getMiddleName()
			{
				return mName;
			}
		public String getLastName()
			{
				return lName;
			}
		public String geUnit()
		{
			return unit;
		}
		
		public String getRank()
		{
			return Rank;
		}
			
		public char getGender()
		{
			return	gender;
		}
		
		/*public String IDnum()
		{
			return "id";
		}*/
		
			
}//end class
