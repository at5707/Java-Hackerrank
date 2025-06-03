import java.io.*;
import java.util.*;
import java.security.*;
public class JavaMD5 {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        sc.close();
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest=md.digest();
        StringBuilder sb=new StringBuilder();
        for (byte b:digest) {
            sb.append(String.format("%02x",b & 0xff));
        }
        System.out.println(sb.toString());
    }
}
