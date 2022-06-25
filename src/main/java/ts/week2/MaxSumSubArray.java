package ts.week2;

import java.util.Arrays;

public class MaxSumSubArray {
    public static int maxSumSubArray(int[] array){
        int start = 0;
        int end =0;
        int s=0;
        int sum =0;
        int max = array[0];
        for(int i=0;i<array.length;i++){
            sum = sum + array[i];
            if(sum > max){
                max = sum;
                start = s;
                end =i;
            }
            if(sum < 0){
                sum = 0;
                s=i+1;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Range = "+start+" to "+end);
        return max;
    }
    public static void main(String[] args){
        //int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int[] array ={1,2,3,-4,5};
        System.out.println("Max Sum = "+maxSumSubArray(array));
    }

}
