import java.util.Random;
public class User {
   

    private String Fname;
    private String Mname;
    private String Lname;
    private String DOB;
    private String Rank;
    private String Unit;
    private String Starlvl;
    private int id;
    private String password;
    Random rand = new Random();
    
    
    

    public User(String Fname, String Mname,String Lname,String DOB, String Rank, String Unit, String Starlvl, String password){
        this.Fname=Fname;
        this.Mname=Mname;
        this.Lname=Lname;
        this.DOB=DOB;
        this.Rank=Rank;
        this.Unit=Unit;
        this.Starlvl=Starlvl;
        int cdtID=0;
        if(Starlvl.equals("4")){
            int userID = (new Random().nextInt(9999-1000)+1000);
            while((userID%2)!=0){
                userID = (new Random().nextInt(9999-1000)+1000);
            }
            cdtID=userID;

        }else{
            int userID = (new Random().nextInt(9999-1000)+1000);
            while((userID%2)!=1){
                userID = (new Random().nextInt(9999-1000)+1000);
            }
            cdtID=userID;
            
        }
        
        this.id = cdtID;
        this.password=password;
    }

    public String getFname(){
        return this.Fname;
    }
    public String getMname(){
        return this.Mname;
    }
    public String getLname(){
        return this.Lname;
    }
    public String getDOB(){
        return this.DOB;
    }
    public String getRank(){
        return this.Rank;
    }
    public String getUnit(){
        return this.Unit;
    }
    public String getStarlvl(){
        return this.Starlvl;
    }
    public int getid(){
        return this.id;
    }
    public String getpassword(){
        return this.password;
    }
}



