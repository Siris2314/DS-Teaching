import java.lang.Exception;
public class MyQueue{

    public class Data {
        String name;
        int age;

        public Data(String name, int age){
            this.name = name;
            this.age = age;
        }

    }

    private class Node {
        Data data;
        Node next;

        public Node(String name, int age){
            this.data = new Data(name,age);
            this.next = null;
        }

    }

    Node head = null;
  

    public void enqueue(String name, int age){
        Node newNode = new Node(name, age);
        
      
        if(head == null){
            head = newNode;
        }
        else{
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;

            }
            cursor.next = newNode;
        }



        
    }

    public void print(){

        Node cursor = head;
        while(cursor !=null){
            System.out.println("Name: " + cursor.data.name);
            System.out.println("Age: " + cursor.data.age);
            cursor = cursor.next;
        }
        
    }

    public Data dequeue(){
        if(head != null){
            Data data = new Data(head.data.name, head.data.age);
            head = head.next;
            return data;
        }
        else{
            throw new RuntimeException("Empty Stack");
        }
    }
    public static void main(String[] args) {
        MyQueue check = new MyQueue();
        check.enqueue("John", 30);
        // check.push("Chess", 40);
        // check.push("Zed", 50);
        check.print();
        // System.out.println("==============================");
        // check.pop();
        // check.pop();
        // check.pop();
        // check.pop();
        // check.print();
    }

   

    

    
}