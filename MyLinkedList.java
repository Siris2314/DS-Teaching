public class MyLinkedList{
    
    Node head;
    private class Node {
        
        String name;
        int age;
        int grade;

        Node next;

    


        public Node(String name, int age, int grade){
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

        public void add(String name, int age, int grade){
            
            Node node = new Node(name, age, grade);
            node.next = null;

            if(head == null){
                head = node;
            } else {
                Node cursor = head;
                while(cursor.next != null){
                    cursor = cursor.next;
                }
                cursor.next = node;
            }
        }

        public void print(){

            if(head == null){
                System.out.println("No data exists");
            }
            else{
                Node cursor = head;
                int cc = 1;
                while(cursor != null){
                    System.out.println("Data# " + cc);
                    System.out.println("Name: " + cursor.name);
                    System.out.println("Age: " + cursor.age);
                    System.out.println("Grade: " + cursor.grade);
                    cc++;
                    cursor = cursor.next;
                }
            }

        }

        public boolean modify(String name, int age, int grade){

            Node cursor = head;

            boolean check = false;

            if(cursor == null){
                return false;

            }
            else{
            
                while(cursor != null){
                    if(cursor.name == name){
                        cursor.age = age;
                        cursor.grade = grade;
                        check = true;
                        break;
                    }
                    else {
                        cursor = cursor.next;

                    }

                }
            }

            return check;

        }

        public void delete(String name){

           

            if(head == null){
                System.out.println("List is empty");
            }
            else{
                if(head.name == name){
                    head = head.next;
                }
                else{
                Node cursor = head;
                Node previous = cursor;
                while(cursor != null){
                    if(cursor.name == name){
                        previous.next = cursor.next;
                        break;
                    } 
                    else{
                        previous = cursor;
                        cursor = cursor.next;
                    }
                }
            }
           }
    


            
            
        }

        public void reverse(){
            Node cursor = head;
            Node previous = null;
            Node next = null;

            while(cursor != null){
                next = cursor.next;
                cursor.next = previous;
                previous = cursor;
                cursor = next;

            }
            head = previous;
        }
        public boolean find(String name){

            Node cursor = head;
            boolean check = false;

            if(cursor == null){

                return false;

            } 
            else{
                while(cursor != null){
                    if(cursor.name == name){
                        check = true;
                        break;
                        
                    } 
                    else{
                        cursor = cursor.next;
                    }
                }
            }

            return check;
        }

        public boolean isEmpty(){

            boolean check = false;
            if(head == null){
                check = true;
            }
            
            return check;
        }
        
    

    public static void main(String[] args) {
        
        MyLinkedList ll = new MyLinkedList();

        ll.add("John", 15, 10);
        ll.add("Joe", 16, 11);
        ll.add("James", 17, 12);
        ll.modify("Joe", 19, 12);
        ll.add("Jill", 14, 9);
        ll.delete("Joe");
        // ll.delete("Jill");
        // ll.delete("James");
        // ll.delete("John");
        if(ll.find("James2") == true){
            System.out.println("James exists in database");
        }
        else{
            System.out.println("James is not currently in the database");
        }
        
        
        // ll.print();
        System.out.println(ll.isEmpty());
    
    }

}
