import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        BigInteger A=new BigInteger(a);
        BigInteger B=new BigInteger(b);
        BigInteger sum=A.add(B);
        BigInteger product=A.multiply(B);
        System.out.println(sum);
        System.out.println(product);
    }
}
