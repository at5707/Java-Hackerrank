import java.io.*;
import java.util.*;

public class JavaBitSet {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        BitSet[] bitSets=new BitSet[3];
        bitSets[1] = new BitSet(n);
        bitSets[2] = new BitSet(n);
        for(int i=0;i<m;i++) {
            String op=sc.next();
            int x=sc.nextInt();
            int y=sc.nextInt();
            switch(op) {
                case "AND":
                    bitSets[x].and(bitSets[y]);
                    break;
                case "OR":
                    bitSets[x].or(bitSets[y]);
                    break;
                case "XOR":
                    bitSets[x].xor(bitSets[y]);
                    break;
                case "FLIP":
                    bitSets[x].flip(y);
                    break;
                case "SET":
                    bitSets[x].set(y);
                    break;
            }
            System.out.println(bitSets[1].cardinality() + " " + bitSets[2].cardinality());
        }
    }
}
