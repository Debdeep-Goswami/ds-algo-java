package ts.week2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public int[] generateData(int items,int range){
        //  Old Way
        int[] array = new int[items];
        for(int i =0;i<items;i++){
            array[i]= (int)(Math.random()*range);
        }
        return array;

        //  New Way
//        int[] array = new int[items];
//        Random random = new Random();
//        for(int i =0;i<items;i++){
//            array[i]= random.nextInt()%range;
//        }
//        return array;
    }
    private void swap(int[] array , int index1, int index2){
        int temp = array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

    public void bubbleSort(int[] array){
        Instant start = Instant.now();
        for(int i = 0;i<array.length-1;i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Duration timeElapsed = Duration.between(start,Instant.now());
        System.out.println("Time Taken in Bubble Sort is "+timeElapsed.toMillis()+" milliseconds");
    }
    public void selectionSort(int[] array){
        Instant start = Instant.now();
        for(int i=0;i< array.length-1;i++){
            int min = i;
            for(int j=i+1;j< array.length;j++){
                if(array[min]>array[j]){
                    min=j;
                }
            }
            int temp = array[min];
            array[min]=array[i];
            array[i]=temp;
        }
        Duration timeElapsed = Duration.between(start,Instant.now());
        System.out.println("Time taken in Selection Sort = "+timeElapsed.toMillis()+" milliseconds");
    }
    public void insertionSort(int[] array){
        Instant start = Instant.now();
        for(int i=1;i<array.length;i++){
            int min = array[i];
            int j = i-1;
            while(j>=0 && array[j]>min){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]= min;
        }
        Duration timeElapsed = Duration.between(start,Instant.now());
        System.out.println("Time taken in Insertion Sort = "+timeElapsed.toMillis()+" milliseconds");
    }
    public void quickSort(int[] array){
        Instant start = Instant.now();
        quickSort(array,0,array.length-1);
        Duration timeElapsed = Duration.between(start,Instant.now());
        System.out.println("Time taken in Quick Sort = "+timeElapsed.toMillis()+" milliseconds");
    }
    private void quickSort(int[] array, int low, int high){
        if(low>=high)
            return;
        int partitionIndex = partition(array,low,high);
        quickSort(array,low,partitionIndex-1);
        quickSort(array,partitionIndex+1,high);
    }
    private int partition(int[] array,int low,int high){
        //  Pivot selection
        int pivot = array[high];

        int leftPointer = low;
        int rightPointer = high;

        while(leftPointer<rightPointer){
            while (array[leftPointer]<= pivot && leftPointer<rightPointer){
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer<rightPointer){
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,high);
        return leftPointer;
    }

    public static void main(String[] args){
        Sorting sorting = new Sorting();
        int[] unSortedArray = sorting.generateData(100,100);
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(unSortedArray));

        int [] array = unSortedArray.clone();
        sorting.bubbleSort(array);

        array = unSortedArray.clone();
        sorting.selectionSort(array);

        array = unSortedArray.clone();
        sorting.insertionSort(array);

        array = unSortedArray.clone();
        sorting.quickSort(array);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(array));
    }
}
