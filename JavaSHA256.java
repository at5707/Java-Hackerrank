import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class JavaSHA256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        sc.close();
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        byte[] hashBytes=md.digest(input.getBytes());
        StringBuilder hexString=new StringBuilder();
        for(byte b : hashBytes) {
            String hex=String.format("%02x",b);
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}
