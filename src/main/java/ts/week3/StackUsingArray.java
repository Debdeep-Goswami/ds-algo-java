package ts.week3;

import java.util.Arrays;
import java.util.Scanner;

public class StackUsingArray {
    int size;
    int[] store;
    int top;

    StackUsingArray(int size){
        this.size = size;
        this.store= new int[size];
        this.top = -1;
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public boolean isFull(){
        return (size-1 == top);
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
        return this.store[top];
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        this.store[++top]=data;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return this.store[top--];
    }

    public void displayStack(){
        for(int i=top;i>=0;i--){
            System.out.print(" "+store[i]);
        }
    }

    public static void run(StackUsingArray stackUsingArray){
        while(true){
            int option = 0;
            int data;
            System.out.println("\nOptions\n1. Push\n2. Pop\n3. Display\n4. Show Peek element\n0. Exit\n\t = ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            switch (option){
                case 0:
                    return;
                case 1:
                    System.out.println("Enter data");
                    data = sc.nextInt();
                    stackUsingArray.push(data);
                    break;

                case 2:
                    data = stackUsingArray.pop();
                    if(data!=Integer.MIN_VALUE){
                        System.out.println("Data popped is "+data);
                    }
                    break;

                case 3:
                    System.out.println("The Stack is");
                    stackUsingArray.displayStack();
                    break;

                case 4:
                    System.out.println("The peek element is "+ stackUsingArray.peek());
                    break;

                default:
                    System.out.println("Invalid selection");
            }
        }
    }

    public static void main(String[] args){
        StackUsingArray stackUsingArray = new StackUsingArray(10);
        run(stackUsingArray);
    }
}
