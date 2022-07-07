package ts.week3;

import java.util.Arrays;
import java.util.Scanner;

public class StackUsingLinkedList {
    //  Data structure to be used
    private class Node{
        int data;
        Node link;
    }
    //  Global top
    Node top;

    StackUsingLinkedList(){
        top = null;
    }

    public boolean isEmpty(){
        return (top==null);
    }

    //  how to write the logic for that
//    public boolean isFull(){
//
//    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return top.data;
    }

    public void push(int data){
        Node temp = new Node();
        if(temp==null){
            System.out.println("Heap Overflow");
            return;
        }
        temp.data = data;
        temp.link=top;
        top=temp;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int data = top.data;
        top= top.link;
        return data;
    }

    public void displayStack() {
        Node temp = top;
        if(temp==null){
            System.out.println();
        }
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.link;
        }
    }

    public static void run(StackUsingLinkedList stackUsingLinkedList) {
        while (true) {
            int option = 0;
            int data;
            System.out.println("\nOptions\n1. Push\n2. Pop\n3. Display\n4. Show Peek element\n0. Exit\n\t = ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter data");
                    data = sc.nextInt();
                    stackUsingLinkedList.push(data);
                    break;

                case 2:
                    data = stackUsingLinkedList.pop();
                    if (data != Integer.MIN_VALUE) {
                        System.out.println("Data popped is " + data);
                    }
                    break;

                case 3:
                    System.out.println("The Stack is");
                    stackUsingLinkedList.displayStack();
                    break;

                case 4:
                    System.out.println("The peek element is " + stackUsingLinkedList.peek());
                    break;

                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    public static void main(String[] args){
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        run(stackUsingLinkedList);
    }
}
