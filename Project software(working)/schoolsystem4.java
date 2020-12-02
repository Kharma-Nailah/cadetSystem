import java.util.Scanner;
import java.util.ArrayList;
import java.io.*; 



public class schoolsystem4 {
    
    public static void main(String [] args){
        Scanner keyboardInput= new Scanner(System.in);
        ArrayList<Question> list = new ArrayList<Question>();
        String prog="Run";
        String choose=null;
        String loginid;
        String loginpassword;
        String id=null;
        String testtopic="FieldCraft.txt";

        System.out.println("Please type 1 to login or 2 to register.");
        String log=keyboardInput.nextLine();

        if(log.equals("1")){
          System.out.println("Please enter your id number.");
          loginid=keyboardInput.nextLine();
          System.out.println("Please enter your password.");
          loginpassword=keyboardInput.nextLine();
          String file= "Accounts.txt";

          try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String curtLine;
            while ((curtLine = bufferedReader.readLine()) != null){
              //process the line as required
              String[] logininfo=curtLine.split(",");
              if (logininfo[1].equals(loginid)){
                  if(logininfo[6].equals(loginpassword)){
                    System.out.println("login succesfull");
                    id=loginid;
                  }else{
                      System.out.println("Password does not match any in the database");
                      System. exit(0);
                  }       
              }
              
            }
            bufferedReader.close();
          }catch(Exception e){
            System.out.println("gg");
          }

        }

        if(log.equals("2")){
            String Fname;
            String Mname;
            String Lname;
            String DOB;
            String Rank;
            String Unit;
            String Starlvl;
            String Password;
            System.out.println("Please do not place any commas (,)");
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
            id=Integer.toString(profile.getid());
            System.out.println("Please remember you id for future login");
            try { 

                // Creating a file and 
                // writing the data 
                // into a Textfile. 
                FileWriter w 
                    = new FileWriter( 
                        "Accounts.txt", true); 

                w.write(profile.getFname()+ " "+ profile.getMname()+" "+profile.getLname()+","+profile.getid()+","+profile.getDOB()+","+profile.getRank()+","+profile.getUnit()+","+profile.getStarlvl()+","+profile.getpassword()+"\n");
                w.close(); 
            } 
            catch (Exception ae) { 
                System.out.println(ae); 
            }

        }
        
        int y=Integer.parseInt(id);
        if(y%2==0){
            choose="2";
        }else{
            choose="1";
        }

        if (choose.equals("1")){
            
            System.out.println("press 1 to take test, 2 to view scores or type stop to end the program");
            while(prog != "stop"){
                choose=keyboardInput.nextLine();


                if (choose.equals("1")){
                    String test=null;
                    try{
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("TopicofTest.txt"));
                        String curLine;
                        while ((curLine = bufferedReader.readLine()) != null){
                            //process the line as required
                            testtopic=curLine;
                        }
                        bufferedReader.close();
                    }catch(Exception e){
                        System.out.println("gg");
                    }

                    int score=takeTest(testtopic);
                    try { 
                        if(testtopic.equals("Drill.txt")){
                            test="Drill test";
                        }
                        if(testtopic.equals("FieldCraft.txt")){
                            test="Field Craft test";
                        }
                        if(testtopic.equals("MapReading.txt")){
                            test="Map Reading test";
                        }
                        if(testtopic.equals("ServiceKnowledge.txt")){
                            test="Service Knowledge test";
                        }
                        // Creating a file and 
                        // writing the data 
                        // into a Textfile. 
                        FileWriter w = new FileWriter("StudentGrade.txt", true); 

                        w.write(id+","+score +"," +test+ "\n"); 
                            
                        w.close(); 
                    } 
                    catch (Exception ae) { 
                        System.out.println(ae); 
                    }

                }

                if (choose.equals("stop")){
                    System.out.println("closing program");
                    System. exit(0);
                }
                if (choose!="stop"){
                    System.out.println("press 1 to take test, 2 to view scores or type stop to end the program");
                }

            }

            
        }

        if (choose.equals("2")){
            System.out.println("press 1 to add question, 2 to administer test, 3 to generate report or type stop to end the program");
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

                if (choose.equals("2")){
                    System.out.println("Enter the number for the topic you wish to be the topic of the test");
                    System.out.println("1) Service Knowledge, 2) Drill, 3) Field Craft, 4) Map Reading");
                    String options=keyboardInput.nextLine();
                    
                    switch (options) {
                    case "1":
                        testtopic="ServiceKnowledge.txt";
                        try { 
                            // Creating a file and 
                            // writing the data 
                            // into a Textfile. 
                            FileWriter w 
                                = new FileWriter( 
                                    "TopicofTest.txt", false); 
                            w.write(testtopic + "\n"); 
                            w.close(); 
                        } 
                        catch (Exception ae) { 
                            System.out.println(ae); 
                        } 
                        break;
                    case "2":
                        testtopic="Drill.txt";
                        try { 
                            // Creating a file and 
                            // writing the data 
                            // into a Textfile. 
                            FileWriter w 
                                = new FileWriter( 
                                    "TopicofTest.txt", false); 
                            w.write(testtopic + "\n"); 
                            w.close(); 
                        }  
                        catch (Exception ae) { 
                            System.out.println(ae); 
                        } 
                        break;
                    case "3":
                        testtopic="FieldCraft.txt";
                        try { 
                            // Creating a file and 
                            // writing the data 
                            // into a Textfile. 
                            FileWriter w 
                                = new FileWriter( 
                                    "TopicofTest.txt", false); 
                            w.write(testtopic + "\n"); 
                            w.close(); 
                        } 
                        catch (Exception ae) { 
                            System.out.println(ae); 
                        } 
                        break;
                    case "4":
                        testtopic="MapReading.txt";
                        try { 
                            // Creating a file and 
                            // writing the data 
                            // into a Textfile. 
                            FileWriter w 
                                = new FileWriter( 
                                    "TopicofTest.txt", false); 
                            w.write(testtopic + "\n"); 
                            w.close(); 
                        } 
                        catch (Exception ae) { 
                            System.out.println(ae); 
                        } 
                        break;
                    }

                }
                if(choose.equals("3")){
                    System.out.println("These are the grades of the cadets:");
                    try{
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("StudentGrade.txt"));
                        String curLine;
                        while ((curLine = bufferedReader.readLine()) != null){
                            //process the line as required
                            System.out.println(curLine+"\n");
                        }
                        bufferedReader.close();
                        }catch(Exception e){
                            System.out.println("gg");
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



    public static int takeTest(String topic){
        int score = 0;
        int counter= 1;
        int questcount=1;
        String file= topic;
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
                questcount++;
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
        
        System.out.println("you score is "+score+"/"+questcount);
        
        return score;
    }
    
    
}