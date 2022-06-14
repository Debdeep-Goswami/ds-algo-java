package ts.week1.myLinkedList;

public class MyLinkedList {

    //  Node structure
    private class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    //  Head node of the list
    private Node head;

    //  Constructor
    public MyLinkedList(){
        head = new Node("Head Node\n");
    }

    //  Methods for the linkedlist
    public void add(String data){
        Node newNode = new Node(data);
        Node currentNode = head;
        while (currentNode.getNext() != null){
            currentNode= currentNode.getNext();
        }
        currentNode.setNext(newNode);
    }

    public void add(String data, int position){
        Node newNode = new Node(data);
        Node current = head;
        int counter =-1;
        while(current!=null){
            counter++;
            if(counter==position-1){
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            }
            current = current.getNext();
        }
    }

    public void append(String data){
        Node currentNode = head;
        while(currentNode.getNext()!=null){
            currentNode=currentNode.getNext();
        }
        Node newNode = new Node(data);
        currentNode.setNext(newNode);
    }

    public void removeLast(){
//        Node currentNode = head;
//        while(currentNode.getNext() != null){
//            currentNode = currentNode.getNext();
//        }
    }
    public void display(){
        Node currentNode = head;
        while(currentNode!=null){
            System.out.println(currentNode.getData());
            currentNode= currentNode.getNext();
        }
    }
}
