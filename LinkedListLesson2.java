public class LinkedListLesson2 {

    Node head;

    private class Node{

        String name;
        int id;
        int grade;

        Node next;

        public Node(String name, int id, int grade){
            this.name = name;
            this.id = id;
            this.grade = grade;
            this.next = null;
        }


    }

    public void add(String name, int id, int grade){

        Node newNode = new Node(name, id, grade);

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

    public void add(String name, int id, int grade, int position){
        Node newNode = new Node(name, id, grade);
        int counter = 0;
        boolean check = false;
        Node cursor = head;
        Node previous = cursor;
        
        if(head == null){
            head = newNode;
        }
        else{
       
            


            while(cursor!=null){
                previous = cursor;
                cursor = cursor.next;

                if(position >= counter){
                    check = true;
                    break;
                }
                counter++;
            }
            
        }

        if(check){
            previous.next = newNode;
            newNode.next = cursor.next;
        } else{
            cursor.next = newNode.next;
        }


    }

    public void delete(String name){

        if(head == null){
            throw new RuntimeException("Empty Database");
        }
        else{
            Node cursor = head;
            Node previous = cursor;

            while(cursor != null){

                

                if(cursor.name == name){
                    

                    if(cursor == head){
                        head = head.next;
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

    public void modify(String name,int id, int grade){

        if(head == null){
            throw new RuntimeException("Empty List");
        }
        else{
            Node cursor = head;
            while(cursor != null){
                if(cursor.name == name){
                    cursor.id = id;
                    cursor.grade = grade;
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
            while(cursor != null){
                System.out.println("Student name: " + cursor.name);
                System.out.println("Student ID: " + cursor.id);
                System.out.println("Student Grade: " + cursor.grade);
                cursor = cursor.next;
            }
        }
    }


    public static void main(String[] args) {

        LinkedListLesson2 check = new LinkedListLesson2();
        check.add("John", 123, 10);
        check.add("Sam", 345, 11);
        check.add("Johnson", 456, 12);
        check.print();
        System.out.println("++++++++++++++++++++++++++++");
        check.delete("John");
   
        check.add("Johhny", 123, 12);
        check.print();
        check.modify("Johhny", 890, 10);
        check.print();
    
        
    }

}