package ts.week1;

import java.util.Scanner;

public class TowerOfHanoi {
    public void towerOfHanoiRecursive(int discs, char source, char aux, char destination){
        if(discs==0){
            return;
        }
        towerOfHanoiRecursive(discs-1,source,destination,aux);
        System.out.println("Move disk "+discs+" from pole "+source+" to pole "+destination);
        towerOfHanoiRecursive(discs-1,aux,source,destination);
    }

    public static void main(String[] args){
        TowerOfHanoi toh = new TowerOfHanoi();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of discs");
        int numberOfDiscs = scanner.nextInt();
        toh.towerOfHanoiRecursive(numberOfDiscs,'1','2','3');
        //toh.towerOfHanoiIterative(numberOfDiscs,'1','2','3');
    }
}
