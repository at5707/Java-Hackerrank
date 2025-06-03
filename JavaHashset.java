import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaHashset {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < t; i++) {
            // Use a space to separate; no ambiguity or special characters
            String pair = pair_left[i] + "," + pair_right[i];
            uniquePairs.add(pair);
            System.out.println(uniquePairs.size());
        }
   }
}
