package Assignment1;

import java.util.Scanner;


public class Q5 {

    static int fibonacci(int num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        else
            return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter number :"); 
        int num = in.nextInt();

        System.out.println(num + "th term of fib. series is: " + fibonacci(num));
    }
}
