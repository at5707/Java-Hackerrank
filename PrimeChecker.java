import java.io.*;
import java.util.*;

public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
class Prime {
    public void checkPrime(int... numbers) {
        for (int num:numbers) {
            if(isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    private boolean isPrime(int n) {
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for (int i=3;i<=Math.sqrt(n);i+=2) {
            if(n%i==0) return false;
        }
        return true;
    }
}
