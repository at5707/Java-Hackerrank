import java.util.Scanner;
class MyCalculator {
    public long power(int n,int p) throws Exception {
        if(n<0||p<0) {
            throw new Exception("n and p should be non-negative");
        }
        return (long) Math.pow(n,p);
    }
}
public class JavaExceptionHandling {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();
            
            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
