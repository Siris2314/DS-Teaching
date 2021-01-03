
import javax.management.RuntimeErrorException;

public class circularlinked{

    Node head;
    Node tail;

    public class Data {
        String data1;
        int data2;
        int data3;

        public Data(String d1, int d2,  int d3){
            this.data1 = d1;
            this.data2 = d2;
            this.data3 = d3;
        }
    }

    private class Node {
        Data data;
        Node next;

        public Node(Data d){
            d = new Data(d.data1, d.data2, d.data3);
            this.next = null;
            this.data = d;

        }
    }

    public void add(Data data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }

    public void delete(Data data){
        if(head == null){
            throw new RuntimeException("Empty List");
        }
        Node cursor = head;
        if(cursor.data.data1 == data.data1){
            head = head.next;
            tail.next = head;
        }
        else{
            Node next = null;
            while(cursor.next != head){
                if(cursor.data.data1 == data.data1){
                    cursor.next = cursor.next.next;
                }

            }
            cursor = next;
        }
    }

    public void modify(Data data){

        if(head == null){
            throw new RuntimeException("Empty List");
        }
        else{
            Node cursor = head;
          while(cursor!= null){
            if(cursor.data.data1 == data.data1){
                cursor.data.data2 = data.data2;
                break;
            
            }
            cursor = cursor.next;
        }
        }
    }

    public void print(){
        if(head == null){
            throw new RuntimeException("Empty List");
        }
        else{
            Node cursor = head;

            while(cursor !=null){
                System.out.println("Data 1: " + cursor.data.data1);
                System.out.println("Data 2: " + cursor.data.data2);
                System.out.println("Data 3: " + cursor.data.data3);

                cursor = cursor.next;

            }
        }
    }
}