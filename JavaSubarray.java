import java.io.*;
import java.util.*;

public class JavaSubarray {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        int negativeSubarrayCount=0;
        for(int start=0;start<n;start++) {
            int sum=0;
            for(int end=start;end<n;end++) {
                sum+=arr[end];
                if(sum<0) {
                    negativeSubarrayCount++;
                }
            }
        }
        System.out.println(negativeSubarrayCount);
    }
}
