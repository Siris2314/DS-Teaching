public class GenericQueue<data> {

    Node<data> head;

    public class Node<data> {

        data d;
        Node<data> next;

        public Node(data d){
            this.d = d;
            this.next = null;
        }
    }


    public boolean isEmpty(){
        return head == null;
    }


    public void enqueue(data d){


        Node<data> newNode = new Node<data>(d);

        if(isEmpty()){
            head = newNode;
            
        }
        else{
            Node<data> cursor = head;

            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = newNode;

        }

    }


    public data dequeue(){

        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }

        Node<data> temp = head;
        head = head.next;

        return temp.d;
        

    }


    public void print(){
        if(isEmpty()){
            throw new RuntimeException("Empty Queue");
        }

        Node<data> cursor = head;

        while(cursor != null){
            System.out.println("Data at this node is " + cursor.d);
            cursor = cursor.next;
        }


    }

    public static void main(String[] args) {
      GenericQueue<Integer> check = new GenericQueue<Integer>();

      check.enqueue(10);
      check.enqueue(20);
      check.enqueue(30);
      check.enqueue(70);
      check.dequeue();
      check.print();
    }

    
    
}
