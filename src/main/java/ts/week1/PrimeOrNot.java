package ts.week1;

import java.time.Duration;
import java.time.Instant;

public class PrimeOrNot {
    //  Basic Method
    public boolean isPrime1(int number){
        for(int i=2 ; i<number; i++)
            if(number%i==0) return false;
        return true;
    }
    //  Divide by 2 Method
    public boolean isPrime2(int number){
        for(int i=2 ; i<=number/2; i++)
            if(number%i==0) return false;
        return true;
    }
    //  Square Root Method
    public boolean isPrime3(int number){
        for(int i=2 ; i<=Math.sqrt(number); i++)
            if(number%i==0) return false;
        return true;
    }

    public void result(int number ,boolean result){
        if(result)
            System.out.print(number+" is Prime");
        else
            System.out.print(number+" is not Prime");
    }

    public void compareMethods(int number) throws InterruptedException {

        //  Delay in seconds
        int delay = 2;

        //  Converting to milliseconds
        delay = delay*1000;

        //  Delay
        Thread.sleep(delay);

        //  Basic Method
        Instant start = Instant.now();
        result(number,isPrime1(number));
        Duration timeElapsed = Duration.between(start, Instant.now());
        System.out.print("\tTime taken in basic method: "+ timeElapsed.toMillis() +" milliseconds\n");

        //  Delay
        Thread.sleep(delay);

        //  Divide by 2 Method
        start = Instant.now();
        result(number,isPrime2(number));
        timeElapsed = Duration.between(start, Instant.now());
        System.out.print("\tTime taken in divide by 2 method: "+ timeElapsed.toMillis() +" milliseconds\n");

        //  Delay
        Thread.sleep(delay);

        //  Square root method
        start = Instant.now();
        result(number,isPrime3(number));
        timeElapsed = Duration.between(start, Instant.now());
        System.out.print("\tTime taken in square root method: "+ timeElapsed.toMillis() +" milliseconds\n");
    }

    public static void main(String[] args) throws InterruptedException {

        PrimeOrNot pon = new PrimeOrNot();

        //  Number to check
        int number = 987654323;
        pon.compareMethods(number);
    }
}
