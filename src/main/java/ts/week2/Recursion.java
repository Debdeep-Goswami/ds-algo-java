package ts.week2;

public class Recursion {
    public static void forRecursion1(int start,int end,int step){
        //  Condition check
        if(start<end){
            //  Statement to be executed inside for
            System.out.println(start);

            //  Call for next iteration with increment/decrement
            forRecursion1(start+step,end,step);
        }
    }
    public static void forRecursion2(int start,int end,int step){
        //  Statement to be executed inside for
        System.out.println(start);

        //  Condition check
        if(start>end-2){
            return;
        }

        //  Call for next iteration with increment/decrement
        forRecursion2(start+step,end,step);
    }
    public static void printNumberDescending(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNumberDescending(n-1);
    }
    public static void printNumberAscending(int n){
        if(n==0){
            return;
        }
        printNumberAscending(n-1);
        System.out.println(n);
    }
    public static int sumOfNaturalNumber(int number){
        if(number==0){
            return 0;
        }
        return number + sumOfNaturalNumber(number-1);
    }
    public static int factorial(int number){
        if(number==1 || number ==0){
            return 1;
        }
        int factNm1= factorial(number-1);
        int factN = number * factNm1;
        return factN;
    }
    public static int factorial2(int number){
        if(number==1 || number ==0){
            return 1;
        }
        return number * factorial2(number-1);
    }
    public static String revreseString(String input){
        //  The base case
        if(input.equals("")){
            return "";
        }
        //  The code to be executed in each iteration
        return revreseString(input.substring(1))+input.charAt(0);

    }
    public static boolean isPalindrome(String input){
        //  Base Case
        if(input.length()==0 || input.length()==1){
            return true;
        }
        else{
            if(input.charAt(0)==input.charAt(input.length()-1)){
                return isPalindrome(input.substring(1,input.length()-1));
            }
            //  Base Case
            else {
                return false;
            }
        }
    }
    public static String decToBin(int decimal,String result) {
        //  Base case
        if(decimal==0){
            return result;
        }
        result = decimal%2 + result;
        return decToBin(decimal/2,result);
    }
    public static String decToBin(int decimal) {
        //  Base case
        if(decimal==0){
            return "0";
        }
        if(decimal ==1){
            return "1";
        }
        return decToBin(decimal/2)+(decimal%2);
    }
    public static int calcPower(int x, int n){
        //  Call Stack size n
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return x * calcPower(x,n-1);
    }
    public static int calcPower2(int x, int n){
        //  Call stack size is log n
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n%2==0){
            return (calcPower(x,n/2) * calcPower(x,n/2));
        } else{
            return (calcPower(x,n/2) * calcPower(x,n/2)*x);
        }
    }
    public static void fibonacci(int first, int second, int term){
        //  Terminating Condition
        if(term == 0){
            return;
        }
        int temp = first+second;
        System.out.print(" "+temp);
        fibonacci(second,temp,term-1);
    }

    public static void main(String[] args){
//        for(int i=0;i<5;i++){
// 		    System.out.println(i);
// 		}
//        forRecursion1(0,5,1);
//        forRecursion2(0,5,1);

//        printNumberDescending(5);
//        printNumberAscending(5);

//        System.out.println(sumOfNaturalNumber(number));

//        int number =5;
//        System.out.println(factorial(number));
//        System.out.println(factorial2(number));

//        String input = "debdeep";
//        System.out.println(revreseString(input));

//        input = "rajabajar";
//        System.out.println(isPalindrome(input));

//        System.out.println(decToBin(number,""));
//        System.out.println(decToBin(number));

//        int [] array = {1,2,3,4,5,6,7,8,9};
//        System.out.println(binarySearch(9,array,0, array.length-1));

//        System.out.println(calcPower(2,5));
//        System.out.println(calcPower2(2,5));

        //  Fibonacci
//        int term = 5;
//        int first = 0;
//        int second = 1;
//        System.out.print(first+" "+second);
//        fibonacci(first,second,term-2);
    }
}
