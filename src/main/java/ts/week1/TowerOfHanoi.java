package ts.week1;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class TowerOfHanoi {

    private void display(int disk,char from,char to){
        System.out.println("Move the disk "+disk+" from "+from+" to "+to);
    }

    //  Recursive Solution
    public void towerOfHanoiRecursive(int discs, char source, char aux, char destination){
        if(discs==0){
            return;
        }
        towerOfHanoiRecursive(discs-1,source,destination,aux);
        display(discs,source,destination);
        towerOfHanoiRecursive(discs-1,aux,source,destination);
    }

    //  Iterative Solution
    private void towerOfHanoiIterative(int discs, char source, char auxiliary, char destination) {
        //  Concept Video   = https://www.youtube.com/watch?v=ZWNK34T0YKM

        //  Create and Filed the first stack with all discs
        Stack src = new Stack(discs);
        for(int i =discs;i>0;i--){
            src.push(i);
        }
        //  Created other two empty stacks
        Stack dst = new Stack(discs);
        Stack aux = new Stack(discs);

        // Step 1 -> Number of times the loop will run
        int numberOfTimes = (int) (Math.pow(2, discs) - 1);

        //  Step 2 -> If number of discs is even interchange destination and auxiliary pole
        if (discs % 2 == 0) {
            char temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }
        //  Step 3 ->
        for (int i = 1; i <= numberOfTimes; i++) {
            if (i % 3 == 1) {
                // Move between S and D
                move(src, dst,source,destination);
            }
            if (i % 3 == 2) {
                // Move between S and A
                move(src, aux,source,auxiliary);
            }
            if (i % 3 == 0) {
                //  Move between A and D
                move(aux,dst,auxiliary,destination);
            }
        }
    }

    class Stack {
        int top;
        int store[];

        public Stack(int size) {
            store = new int[size];
            top = -1;
        }

        public boolean isFull() {
            return (top == store.length - 1);
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public void push(int data) {
            if (isFull())
                return;
            store[++top] = data;
        }

        public int pop() {
            if (isEmpty())
                return Integer.MIN_VALUE;
            return store[top--];
        }
    }

    private void move(Stack src, Stack dst,char source,char destination){
        if(dst.isEmpty()){
            //  If destination pole is empty
            int disk =src.pop();
            dst.push(disk);
            display(disk,source,destination);
        } else if(src.isEmpty()){
            //  If source pole is empty
            int disk = dst.pop();
            src.push(disk);
            display(disk,destination,source);
        }else {
            //  To check which pole has bigger disk to interchange
            int disk1 = src.pop();
            int disk2 = dst.pop();
            if(disk1>disk2){
                src.push(disk1);
                src.push(disk2);
                display(disk2,destination,source);
            }else{
                dst.push(disk2);
                dst.push(disk1);
                display(disk1,source,destination);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TowerOfHanoi toh = new TowerOfHanoi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of discs");
        int numberOfDiscs = scanner.nextInt();

        Instant start = Instant.now();
        toh.towerOfHanoiRecursive(numberOfDiscs,'S','A','D');
        Duration timeElapsed = Duration.between(start, Instant.now());
        System.out.print("\nTime taken in recursive method: "+ timeElapsed.toMillis() +" milliseconds\n");

        //  Delay in seconds
        int delay = 2;

        //  Converting to milliseconds
        delay = delay*1000;

        //  Delay
        Thread.sleep(delay);

        start = Instant.now();
        toh.towerOfHanoiIterative(numberOfDiscs,'S','A','D');
        timeElapsed = Duration.between(start, Instant.now());
        System.out.print("\nTime taken in iterative method: "+ timeElapsed.toMillis() +" milliseconds\n");
    }
}
