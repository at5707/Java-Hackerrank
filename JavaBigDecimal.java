import java.math.BigDecimal;
import java.util.*;
class JavaBigDecimal{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Arrays.sort(s,0,n,new Comparator<String>() {
            public int compare(String a,String b) {
                BigDecimal A = new BigDecimal(a);
                BigDecimal B = new BigDecimal(b);
                return B.compareTo(A);
            }
        });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
