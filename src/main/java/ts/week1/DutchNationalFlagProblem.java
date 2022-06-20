package ts.week1;

public class DutchNationalFlagProblem {

    //  Basic
    public static void runDNF(int array[]){
        int low=0;
        int mid =0;
        int high = array.length-1;
        while(mid<=high){
            display(array);
            if(array[mid]==0){
                swap(array,low,mid);
                low++;
                mid++;
            } else if(array[mid]==1){
                mid++;
            } else{
                swap(array,mid,high);
                high--;
            }
        }
    }

    public static void swap(int array[],int left, int right){
        int temp = array[left];
        array[left]= array[right];
        array[right]= temp;
    }

    public static void display(int array[]){
        for(int i : array){
            System.out.print("\t"+i);
        }
        System.out.println();
    }

    //  Modified for specific 3 symbols
    public static void runDNFModified(char[] array,char[] symbols){
        int low=0;
        int mid =0;
        int high = array.length-1;
        while(mid<=high){
            display(array);
            if(array[mid]==symbols[0]){
                swap(array,low,mid);
                low++;
                mid++;
            } else if(array[mid]==symbols[1]){
                mid++;
            } else{
                swap(array,mid,high);
                high--;
            }
        }
    }
    public static void swap(char array[],int left, int right){
        char temp = array[left];
        array[left]= array[right];
        array[right]= temp;
    }

    public static void display(char array[]){
        for(char i : array){
            System.out.print("\t"+i);
        }
        System.out.println();
    }

    public static void main(String[] args){
        //  Basic Algorithm
        //int[] array = {0,1,2,2,1,0,1,2,2,0};
        int[] array = {0, 0, 1, 2, 0, 1, 2};
        runDNF(array);
        display(array);

        System.out.println("_________________________________");

        //  Modified for specific 3 symbols
        char[] array2 = {'a','a','b','c','a','b','c'};
        char[] symbols = {'a','b','c'};
        runDNFModified(array2,symbols);
    }
}
