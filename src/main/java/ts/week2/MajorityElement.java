package ts.week2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class MajorityElement {
    public int[] generateData(int items,int range){
        int[] array = new int[items];
        for(int i =0;i<items;i++){
            array[i]= (int)(Math.random()*range);
        }
        return array;
    }

    public void findMajorityElemnt(int[] array){
        Instant start = Instant.now();
        int maxCount = 0;
        int index=-1;
        //  Traverse the entire array
        for(int i=0;i<array.length;i++){
            int count=0;
            //  Travse the array to get count of each element
            for(int j=0;j< array.length;j++){
                if(array[i]==array[j]){
                    count++;
                }
            }
            //  Upadte the count if current count is bigger than the old
            if(count>maxCount){
                maxCount=count;
                index = i;
            }
        }
        //  Majority condition check
        if(maxCount> array.length/2){
            System.out.println("The major element is "+array[index]);
        }else {
            System.out.println("No major element is found");
        }
        Duration timeElapsed = Duration.between(start,Instant.now());
        System.out.println("Time Taken is "+timeElapsed.toMillis()+" milliseconds");
    }

    public static void main(String[] args){
        MajorityElement majorityElement = new MajorityElement();
        //int[] array= majorityElement.generateData(7,3);
        int[] array = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        System.out.println("The elements in the array");
        System.out.println(Arrays.toString(array));
        majorityElement.findMajorityElemnt(array);
    }
}
