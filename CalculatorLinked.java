import java.util.Scanner;

import javax.management.RuntimeErrorException;
public class CalculatorLinked {

    Node head;

    private class Node{
        Node next;

        String name;
        double percent;
        double weight;


        public Node(String name, double percent, double weight){

            this.name = name;
            this.percent = percent;
            this.weight = weight;
            this.next = null;
        }
    }


    public void add(String name, double percent, double weight){
        Node node = new Node(name, percent, weight);


        if(head == null){
            head = node;
        }
        else{
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = node;
        }

    }

    public double calculate(){

        double grade = 0;
        double percentconvert = 0;
        double gradeconvert = 0;

        if(head == null){
            throw new RuntimeException("Nothing to Calculate in this list");
        }
        else{
            Node cursor = head;
            while(cursor != null){

                percentconvert = cursor.weight / 100;
                gradeconvert = cursor.percent / 100;

                grade +=  gradeconvert * percentconvert;

                cursor = cursor.next;

            }
        }
        return grade;
    }

    public void delete(String name){
        if(head == null){

            throw new RuntimeException("No records founds");

        } else{
            Node cursor = head;
            Node previous = cursor;
            while(cursor != null){

              if(cursor.name == name){

                if(cursor == head){
                    head = cursor.next;
             
                }

                previous.next = cursor.next;
            }
            else{
                previous = cursor;
            }
            cursor = cursor.next;
          }
        }
    }

    public void modify(String name, double weight, double percent ){
        if(head == null){
            throw new RuntimeException("Empty Database");
        } else{
            Node cursor = head;
          while(cursor != null){
            if(cursor.name == name){

                cursor.percent = percent;
                cursor.weight = weight;
                break;

            }
            cursor = cursor.next;
            
        }
    }
   }

   public void print(){

    if(head == null){
        throw new RuntimeException("Empty Database");
    }
    else{
        Node cursor = head;
        while(cursor!=null){
            System.out.println("Assignment Name: " + cursor.name);
            System.out.println("Grade Received: " + cursor.percent);
            System.out.println("Percent Weight of Assignment: " + cursor.weight);
            cursor = cursor.next;
        }
    }

   }


   public static void main(String[] args) {

        CalculatorLinked checker = new CalculatorLinked();
    while(true){
        Scanner opt = new Scanner(System.in);
        System.out.println("Welcome to The Grade Calculator, you have 5 options, to either add new assignments, modify existing ones, delete existing ones, calculate your final grade, or print out the assignments you have inputted. If you wish to exit, simply type in exit");
        String option = opt.nextLine();
        int options = 0;

        if(option.equalsIgnoreCase("exit")){
            break;
        } else if(option.equalsIgnoreCase("add")){
            options = 1;
        } else if(option.equalsIgnoreCase("delete")){
            options = 2;
        } else if(option.equalsIgnoreCase("modify")){
            options = 3;
        } else if(option.equalsIgnoreCase("calculate")){
            options = 4;
        } else if(option.equalsIgnoreCase("print")){
            options = 5;
        }





    if(options == 1){           
        Scanner start = new Scanner(System.in);
        System.out.println("Assignment Adder:Would you like to add an assignment?");
        String checkmore = start.nextLine();
        Scanner check = new Scanner(System.in);
       

       while(checkmore.equalsIgnoreCase("YES")){

        System.out.println("Please enter the name of the assignment");
        String checker1 = start.nextLine();
        start.nextLine();
        System.out.print("Loading up Calculator......");
        System.out.println("\nPlease enter the grade you received on said assignment");
        double checker2 = start.nextDouble();
        
        System.out.println("Please enter the weight percentage of the said assignment");
        double checker3 = start.nextDouble();
        checker.add(checker1, checker2, checker3);

        
      
         System.out.println("Would you like to add another node");
         String more = check.nextLine();
         if(more.equalsIgnoreCase("no")){
             break;
         }else{
            checkmore = "YES";
         }

        }

        






       
   } else if(options == 2){

     Scanner del = new Scanner(System.in);
     System.out.println("Assignment Deleter, would you like to delete an assignment?");
     String deleter = del.nextLine();

     Scanner delinput = new Scanner(System.in);


     while(deleter.equalsIgnoreCase("YES")){

        System.out.println("Please State the Name of the assignment you want to delete");
        String name = delinput.nextLine();
        checker.delete(name);

        Scanner moredel = new Scanner(System.in);
        System.out.println("Would you like to delete more nodes");
        String del2 = moredel.nextLine();

        if(del2.equalsIgnoreCase("no")){
            deleter = "no";
        }







        
     }






   } else if(options == 3){

        Scanner modi = new Scanner(System.in);
        System.out.println("Assignment Modifier, would you like to modify an existing assignment");
        String modifier = modi.nextLine();

        Scanner newmodi = new Scanner(System.in);


        while(modifier.equalsIgnoreCase("YES")){

            System.out.println("Please enter the assignment you would like to modify");
            String name = newmodi.nextLine();
            newmodi.nextLine();
            System.out.println("Please enter in the new grade value");
            double newGrade = newmodi.nextDouble();
            System.out.println("Please enter in the new weight value");
            double newWeight = newmodi.nextDouble();
            


            checker.modify(name, newWeight, newGrade);


            Scanner moremodi = new Scanner(System.in);

            String moreM = moremodi.nextLine();

            if(moreM.equalsIgnoreCase("no")){
                modifier = "no";
            }









        }



           


   } else if(options == 4){
       double grade = checker.calculate();
       double grade2 = grade * 100;

       if(grade2 >= 95 && grade2<=100){
           System.out.println("You will be receiving an A in this class, your final grade is: " + grade2);
       }
       else if(grade2 >= 90 && grade2 < 95){
           System.out.println("You will be receiving an A- in this class, your final grade is: " + grade2);
       } else if(grade2 >= 85 && grade2 < 90){
           System.out.println("You will be receiving a B+ in this class, your final grade is: " + grade2);

       } else if(grade2 >= 80 && grade2 < 85){
           System.out.println("You will be receiving a B in this class, your final grade is: " + grade2);
       } else if(grade2 >= 75 && grade2 < 80){
           System.out.println("You will be receiving a B- in this class, your final grade is: " + grade2);

       } else if(grade2 >= 70 && grade2 < 75){
           System.out.println("You will be receiving a C+ in this class, your final grade is: " + grade2);
       } else if(grade2 >= 65 && grade2 < 70){
           System.out.println("You will be receiving a C in this class, your final grade is: " + grade2);
       } else if(grade2 >= 60 && grade2 < 65){
           System.out.println("You will be receiving a D+ in this class, your final grade is: " + grade2);
       } else if(grade >= 55 && grade < 60){
           System.out.println("You will be receiving a D in this class, your final grade is: " + grade2);
       } else if(grade >= 50 && grade < 55){
           System.out.println("You will be receiving a D- in this class, your final grade is: " + grade2);
       } else{
           System.out.println("You have received an F in this class, your final grade is: " + grade2);
       }
   } else if(options == 5){
       checker.print();
   } else{
       throw new RuntimeException("Invalid input");
   }
  }
}

  }


    

