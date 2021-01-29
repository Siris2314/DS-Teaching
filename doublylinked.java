public class doublylinked {

    Node head;


    private class Node {
        String name;
        double price;
        double rating;
        Node next;
        Node prev;

        public Node(String name, double price, double rating){


            this.name = name;
            this.price = price;
            this.rating = rating;
            this.next = null;
            this.prev = null;

        }
    }


    public void add(String name, double price, double rating){

        Node addNode = new Node(name, price, rating);

        if(head == null){
            head = addNode;
        }
        else{
            Node cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = addNode;
            addNode.prev = cursor;
        }

    }

    
    
}
