import java.util.*;

public class ReverseNumber {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        // 1.using algorithm

        int rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10; // 0+1234 %10=4, 4*10+1234%10=40+3=43

            num = num / 10; // 1234/10=123, 123/10=12 , 12/10=1,1/10=0

        }

        System.out.println("Reverse number is :" + rev);

    }

}

// what is kubernative
/*
 * 
 * 1. 1.1.1.1.1.1.1.1
 * microserivces
 * in todays era packtet design and docker
 * kubernetes is
 * 
 * orchstrate means managining our application
 * may be it is self doing something goes wrong
 * 
 * container isation is a process of packing our application in a container
 * and that container is running on a machine
 * putting out it to on cloud
 * 
 * is wiill make more quality that might have a video conversation service
 * 
 * it is tool which is used to
 * 
 */