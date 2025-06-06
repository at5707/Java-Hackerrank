import java.io.*;
import java.util.*;

public class JavaExceptionHandling(Try-catch) {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            int x=sc.nextInt();
            int y=sc.nextInt();
            System.out.println(x/y);
        } catch (InputMismatchException e){
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: " + e.getMessage());
        }
        sc.close();
    }
}
