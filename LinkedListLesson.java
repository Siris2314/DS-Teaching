public class LinkedListLesson {

    Node head;
    int length = 0;

    private class Node {
        String dishName;
        int dishPrice;
        int dishRating;

        Node next;

        public Node(String dn, int dp, int dr){
            this.dishName = dn;
            this.dishPrice = dp;
            this.dishRating = dr;
            this.next = null;
     
        }
    }

    public void add(String dn, int dp, int dr){
        Node newNode = new Node(dn, dp,dr);
     
      

        if(head == null){
            head = newNode;
        } else{
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;

        }
        ++length;
    }

    public void add(String dn, int dp, int dr, int position){

       int counter = 0;
        Node node = new Node(dn, dp, dr);

        if(head == null){

            head = node;
        
        } 

        Node cursor = head;
        boolean valid = false;
        Node previous = cursor;

        while(cursor != null){
            
            previous = cursor;
            cursor = cursor.next;

            if(position >= counter){

                valid = true;
                break;

            }

            counter++;


        }
        if(valid == true){
            previous.next = node;
            node.next = cursor.next;


        } else {
            cursor.next = node.next;
        }

    
        



    }

    public void print(){

        if(head == null){
            throw new RuntimeException("Menu is empty");
        }
        else{
            Node cursor = head;
            while(cursor!= null){
                System.out.println("Dish: " + cursor.dishName);
                System.out.println("Price: " + cursor.dishPrice);
                System.out.println("Rating: " + cursor.dishRating);
                cursor = cursor.next;
            }
        }
        
    }

    public void modify(String dn, int dp, int dr ){

        
        
        if(head == null){
            throw new RuntimeException("Empty Menu");

        } else {
            Node cursor = head;

            while(cursor != null){
                if(dn.equalsIgnoreCase(cursor.dishName)){

                    cursor.dishPrice = dp;
                    cursor.dishRating = dr;
                    break;


                }

                cursor = cursor.next;
            }

            
        }
    }


    public void delete(String name) {
        if(head == null){
            throw new RuntimeException("Empty List");
        }
        else{
            Node cursor = head;
            Node previous = cursor;
           
              while(cursor!= null){
                if(cursor.dishName == name){
                    previous.next = cursor.next;
                    if(cursor == head){
                        head = cursor.next;
                        // cursor = previous;
                    }
                    
                } 
                else{
                    previous = cursor;
                    

                }
                cursor = cursor.next; 
            }
        

        }
        
    }


    public static void main(String[] args) {
        LinkedListLesson check = new LinkedListLesson();
        
        check.add("Pizza", 60,10);
        check.add("Pizza", 50, 10);
        check.add("Pizza", 40,9);
        check.add("Crepe", 10, 5);
        check.add("Ice Cream", 55, 100);
        check.add("Pizza", 20, 7);
        check.add("Pizza", 30,8);
        check.print();
        check.delete("Pizza");
        System.out.println("==============");
        check.print();

    }


    
}
