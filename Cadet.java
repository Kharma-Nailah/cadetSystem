package theUsers;

//libraries needed
import java.util.Random;

public class Cadet extends User
{
	public static void main(String[] args)
	{
	//private String viewScore;
	//final User user;
	User cadetUser=new User();
	final int cdtID;
	//super (String Rank, String fName, String lName,String mName,String unit,String StarLev,String registrationNum);
	
	//generate id number for cadet
	//cadet types will be odd 
	int userID = (new Random().nextInt(9999-1000)+1000);
			if ((userID%2)==1)
				{
					 cdtID=userID;
						System.out.println(cdtID);

				}//end while
			
			else
				{
				cdtID = (new Random().nextInt(9999-1000)+1000);	
				System.out.println(cdtID);
				}
	
	}//end static

}//end Cadet