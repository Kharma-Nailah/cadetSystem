import java.util.Scanner;
import java.util.ArrayList;
import java.io.*; 


public class schoolsystem3 {

    public static void main(String [] args){
        Scanner keyboardInput= new Scanner(System.in);
        ArrayList<Question> list = new ArrayList<Question>();
        String prog="Run";
        String choose;

        System.out.println("Please type 1 to login or 2 to register.");
        String log=keyboardInput.nextLine();

        if(log.equals("2")){
            String Fname;
            String Mname;
            String Lname;
            String DOB;
            String Rank;
            String Unit;
            String Starlvl;
            String Password;

            System.out.println("Please enter you first name.");
            Fname=keyboardInput.nextLine();
            System.out.println("Please enter you middle name.");
            Mname=keyboardInput.nextLine();
            System.out.println("Please enter you last name.");
            Lname=keyboardInput.nextLine();
            System.out.println("Please enter your date of birth.");
            DOB=keyboardInput.nextLine();
            System.out.println("Please enter your rank.");
            Rank=keyboardInput.nextLine();
            System.out.println("Please enter your unit.");
            Unit=keyboardInput.nextLine();
            System.out.println("Please enter your star level.");
            Starlvl=keyboardInput.nextLine();
            System.out.println("Please enter a password you would want to use.");
            Password=keyboardInput.nextLine();

            User profile= new User(Fname, Mname, Lname, DOB, Rank, Unit, Starlvl,Password);
            System.out.println("Your id is "+ profile.getid());
            System.out.println("Please remember you id for future login");
            try { 

                // Creating a file and 
                // writing the data 
                // into a Textfile. 
                FileWriter w 
                    = new FileWriter( 
                        "Accounts.txt", true); 

                w.write(profile.getFname()+ " "+ profile.getMname()+" "+profile.getLname()+"\n"); 
                w.write(profile.getid()+"\n");
                w.write(profile.getDOB()+"\n");
                w.write(profile.getRank()+"\n");
                w.write(profile.getUnit()+"\n");
                w.write(profile.getStarlvl()+"\n");
                w.write(profile.getpassword()+"\n");
                w.close(); 
            } 
            catch (Exception ae) { 
                System.out.println(ae); 
            }

        }



        System.out.println("press 1 if you are a cadet or 2 if you are a instructor or type stop to end the program");
        choose=keyboardInput.nextLine();


        if (choose.equals("1")){


            System.out.println("Please enter you cadet id number.");
            String id=keyboardInput.nextLine();
            
            System.out.println("press 1 to take test, 2 to view scores or type stop to end the program");
            while(prog != "stop"){
                choose=keyboardInput.nextLine();


                if (choose.equals("1")){
                    int score=takeTest();
                    try { 

                        // Creating a file and 
                        // writing the data 
                        // into a Textfile. 
                        FileWriter w 
                            = new FileWriter( 
                                "StudentGrade.txt", true); 

                        w.write( id+"  "+score + "\n"); 
                            
                        w.close(); 
                    } 
                    catch (Exception ae) { 
                        System.out.println(ae); 
                    }

                }

                if (choose.equals("stop")){
                    System.out.println("closing program");
                    choose="stop";
                }
                if (choose!="stop"){
                    System.out.println("press 1 to take test, 2 to view scores or type stop to end the program");
                }

            }

            
        }

        if (choose.equals("2")){
            System.out.println("press 1 to add question or type stop to end the program");
            while(choose!="stop"){
                choose=keyboardInput.nextLine();

                if (choose.equals("1")){
                    System.out.println("Type the question");
                    String question=keyboardInput.nextLine();
                    System.out.println("Enter the 3 options for the question seperated by a comma (the order will be a,b,c)");
                    String options=keyboardInput.nextLine();
                    String[] words=options.split(",");
                    String q3=question+"\n"+"(a)"+words[0]+"\n"+"(b)"+words[1]+"\n"+"(c)"+words[2];
                    System.out.println("Which option (a, b, or c) is the correct one?");
                    String correct= keyboardInput.nextLine();
                    Question q = new Question(q3, correct);
                    list.add(q);
                    try { 

                        // Creating a file and 
                        // writing the data 
                        // into a Textfile. 
                        FileWriter w 
                            = new FileWriter( 
                                "TestQuestions.txt", true); 

                        w.write(q3 + "\n"); 
                        w.write(correct+"\n");
                        w.close(); 
                    } 
                    catch (Exception ae) { 
                        System.out.println(ae); 
                    } 
                }

                if (choose.equals("stop")){
                    System.out.println("closing program");
                    choose="stop";
                }
                if (choose!="stop"){
                    System.out.println("press 1 to add question or type stop to end the program");
                }

            }
                
        }    
    }



    public static int takeTest(){
        int score = 0;
        int counter= 1;
        String file= "TestQuestions.txt";
        Scanner keyboardInput= new Scanner(System.in);
        try{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String curLine;
        while ((curLine = bufferedReader.readLine()) != null){
            //process the line as required
            if(counter!=5){
                System.out.println(curLine);
            }

            if (counter==5){
                System.out.println("this is "+curLine);
                System.out.println("this is counter "+counter);
                String answer=keyboardInput.nextLine();
                char x= answer.charAt(0);
                char y=curLine.charAt(0);
                if (x==y){
                    score++;
                }
                counter=0;
            }
            
            counter++;
        }
        bufferedReader.close();
        }catch(Exception e){
            System.out.println("gg");
        }
        
        System.out.println("you score is "+score);
        
        return score;
    }
    
    
}
