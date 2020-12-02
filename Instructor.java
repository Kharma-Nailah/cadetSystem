package theUsers;

import java.util.ArrayList;
import java.util.Random;

public class Instructor extends User
{
	
	public static void main(String[] args)
	{
		User InstUser=new User();
		final int InstID;
		final int InstID2;
		
//generate Instructor type ID (even#)	
	int userID = (new Random().nextInt(9999-1000)+1000);
	if ((userID%2)==0)
		{
		InstID=userID;
				//System.out.println(InstID);
				User.getList().add(0,String.valueOf(InstID));
				ArrayList<String>even2=User.getList();
				even2.add(0,String.valueOf(InstID));
				System.out.print(even2);
		}//end while
	
	else 
		//if((userID%2)==1)
		{
		InstID= (new Random().nextInt(9999-1000)+1000);	
	
		ArrayList<String>odd2=User.getList();
		odd2.add(0,String.valueOf(InstID));
		System.out.print(odd2);
		}
	
	}
}
