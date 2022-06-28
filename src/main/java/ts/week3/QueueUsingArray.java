package ts.week3;

import java.util.Scanner;

public class QueueUsingArray {

    int size;
    int[] store;
    int rear;
    int front;

    QueueUsingArray(int size){
        this.size = size;
        front=rear=0;
        store = new int[size];
    }

    public boolean isFull(){
        return (size==rear);
    }

    public boolean isEmpty(){
        return (front==rear);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return (store[front]);
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        store[rear++]=data;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int data = store[front];
        //  Shifting the elements
        for(int i=0;i<rear-1;i++){
            store[i]=store[i+1];
        }
        rear--;
        return data;
    }

    public void displayQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=front;i<rear;i++){
            System.out.println(" "+store[i]);
        }
    }

    public static void run(QueueUsingArray queueUsingArray){
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
                    queueUsingArray.enqueue(data);
                    break;

                case 2:
                    data = queueUsingArray.dequeue();
                    if(data!=Integer.MIN_VALUE){
                        System.out.println("Data deleted "+data);
                    }
                    break;

                case 3:
                    System.out.println("The Queue is");
                    queueUsingArray.displayQueue();
                    break;

                case 4:
                    System.out.println("The peek element is "+ queueUsingArray.peek());
                    break;

                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    public static void main(String[] args){
        QueueUsingArray queueUsingArray = new QueueUsingArray(3);
        run(queueUsingArray);
    }
}
