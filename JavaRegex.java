import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class JavaRegex{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
class MyRegex {
    // Validates numbers from 0 to 255 with optional leading zeros
    String num = "(25[0-5]|2[0-4]\\d|1\\d{2}|0?\\d{1,2})";
    String pattern = "^(" + num + "\\.){3}" + num + "$";
}
