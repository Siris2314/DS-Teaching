import java.util.NoSuchElementException;

public class GenericLinked<data> implements Comparable<data>{

    Node<data> head;


   



    public class Node<data> {

        data d;
        Node<data> next;

        public Node(data d) {
            this.d = d;
            this.next = null;
        }

    }

    public data tail(){
        Node<data> cursor = head;
        data tail = null;

        while(cursor != null){
            if(cursor.next == null){
                tail = cursor.d;
                break;
                
            }
            cursor = cursor.next;
        }
        return tail;
    }

    public void add(data d) {

        Node<data> newNode = new Node<data>(d);

        if (head == null) {
            head = newNode;
        } else {
            Node<data> cursor = head;
            while (cursor.next != null) {
                cursor = cursor.next;

            }
            cursor.next = newNode;

        }

    }


    public int compareTo(data d){
        return 0;
    }

    public data delete(data d) throws NoSuchElementException{
        data deleter = null;
        if(isEmpty()){
            throw new NoSuchElementException("No existing nodes in list");
        } 
        
            Node<data> cursor = head;
            Node<data> previous = null;

            

            while(cursor!=null){
                if(d.equals(cursor.d)){
                    if(cursor.equals(head)){
                        deleter = head.d;
                        head = cursor.next;
                        

    
                       
                        
    
                    }


                   

                    previous.next = cursor.next;


                  

                    

                } 


                  previous = cursor;
                  cursor = cursor.next;

                }

                return deleter;

                  
                
            }


           
        
        

   
          
    

    



    public boolean isEmpty(){
        return head == null;
    }

    public data peek(){
        return head.d;
    }


   

    public void print() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        } else {
            Node<data> cursor = head;
            while (cursor != null) {
                System.out.println("Data: " + cursor.d);
                cursor = cursor.next;
            }

        }
    }

    public static void main(String[] args) {
        GenericLinked<Double> check = new GenericLinked<Double>();
        check.add(9000.0);
        check.add(1000.0);
        check.add(4000.0);
        check.add(6000.0);
        check.add(5000.0);  
    
        // check.delete(15000.0);
        // check.delete(6000.0);

       
        check.print();
    }


}
