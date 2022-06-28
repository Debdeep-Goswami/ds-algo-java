package ts.week3;

import java.util.Scanner;

public class QueueUsingLinkedList {
    private class Node{
        int data;
        Node next;
    }
    private Node front,rear;
    private int currentSize;

    QueueUsingLinkedList(){
        front = null;
        rear = null;
        currentSize =0;
    }

    public boolean isEmpty(){
        if(currentSize==0)
            return true;
        return false;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    //  Is full to be written

    public void enqueue(int data){
        Node oldRear = rear;
        rear = new Node();
        rear.data=data;
        rear.next=null;

        if(isEmpty()){
            front = rear;
        } else{
            oldRear.next=rear;
        }
        currentSize++;
    }

    public int dequeue(){
        if(isEmpty()){
            rear=null;
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int data = front.data;
        front= front.next;
        currentSize--;
        return data;
    }

    public void displayQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else {
            Node temp = front;
            while(temp!=null){
                System.out.print(" "+temp.data);
                temp=temp.next;
            }
        }
    }

    public static void run(QueueUsingLinkedList queueUsingLinkedList){
        while(true){
            int option = 0;
            int data;
            System.out.println("\nOptions\n1. Enqueue\n2. Dequeue\n3. Display\n4. Show Peek element\n0. Exit\n\t = ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option){
                case 0:
                    return;
                case 1:
                    System.out.println("Enter data");
                    data = sc.nextInt();
                    queueUsingLinkedList.enqueue(data);
                    break;

                case 2:
                    data = queueUsingLinkedList.dequeue();
                    if(data!=Integer.MIN_VALUE){
                        System.out.println("Data deleted "+data);
                    }
                    break;

                case 3:
                    System.out.println("The Queue is");
                    queueUsingLinkedList.displayQueue();
                    break;

                case 4:
                    System.out.println("The peek element is "+ queueUsingLinkedList.peek());
                    break;

                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    public static void main(String[] args){
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        run(queueUsingLinkedList);
    }
}
