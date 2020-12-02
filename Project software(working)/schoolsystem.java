import java.util.Scanner;
import java.util.ArrayList;
import java.io.*; 

public class schoolsystem {

    public static void main(String [] args){
        Scanner keyboardInput= new Scanner(System.in);
        String q1= "What color are apples?\n"
                 + "(a)red/green\n(b)Orange\n(c)Magenta\n";
        String q2= "What color are bananas?\n"
                 + "(a)red/green\n(b)Yellow\n(c)Blue\n";

        ArrayList<Question> list = new ArrayList<Question>();

        list.add(new Question(q1, "a"));
        list.add(new Question(q2, "b"));

        String choose="Run";
        System.out.println("press 1 if you are a cadet or 2 if you are a instructor or type stop to end the program");
        choose=keyboardInput.nextLine();


        if (choose.equals("1")){
            System.out.println("Please enter you cadet id number.");
            String id=keyboardInput.nextLine();
            System.out.println("press 1 to take test, 2 to view scores or type stop to end the program");
            while(choose != "stop"){
                choose=keyboardInput.nextLine();


                if (choose.equals("1")){
                    int score=takeTest(list);
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



    public static int takeTest(ArrayList<Question> list){
        int score = 0;
        Scanner keyboardInput= new Scanner(System.in);

            for(int i =0; i< list.size(); i++){
                System.out.println(list.get(i).prompt);
                String answer= keyboardInput.nextLine();
                if(answer.equals(list.get(i).answer)){
                    score++;
                }
            }
        System.out.println("You got "+ score+ "/" + list.size());
        return score;
    }
    
    
}
