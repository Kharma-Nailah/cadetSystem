import java.util.Scanner;
import java.util.ArrayList;

public class TestBank{
    public static void main(String [] args){
        Scanner keyboardInput= new Scanner(System.in);
        String q1= "What color are apples?\n"
                 + "(a)red/green\n(b)Orange\n(c)Magenta\n";
        String q2= "What color are bananas?\n"
                 + "(a)red/green\n(b)Yellow\n(c)Blue\n";


        /*Question[] questions={
            new Question(q1, "a"),
            new Question(q2, "b")
        };*/

        ArrayList<Question> list = new ArrayList<Question>();

        list.add(new Question(q1, "a"));
        list.add(new Question(q2, "b"));

        String choose="Run";
        System.out.println("press 1 to take test or 2 to add questions or type stop to end the program");
        choose=keyboardInput.nextLine();

        while (choose!="stop"){
            if (choose.equals("1")){
                takeTest(list);
            }

            if (choose.equals("2")){
                System.out.println("Type the question");
                String question=keyboardInput.nextLine();
                System.out.println("Enter the 3 options for the question seperated by a space (the order will be a,b,c)");
                String options=keyboardInput.nextLine();
                String[] words=options.split("\\s");
                String q3=question+"\n"+"(a)"+words[0]+"\n"+"(b)"+words[1]+"\n"+"(c)"+words[2];
                System.out.println("Which option a, b, or c is the correct one?");
                String correct= keyboardInput.nextLine();
                Question q = new Question(q3, correct);
                list.add(q);
            }
            if (choose.equals("stop")){
                System.exit(0);
            }
            System.out.println("press 1 to take test or 2 to add questions or type stop to end the program");
            choose=keyboardInput.nextLine();
        }
        
    }

    public static void takeTest(ArrayList<Question> list){
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
    }




}
    