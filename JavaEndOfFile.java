import java.io.*;
import java.util.*;

public class JavaEndOfFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber=1;
        while(scanner.hasNext()) {
            String line=scanner.nextLine();
            System.out.println(lineNumber + " " + line);
            lineNumber++;
        }
        scanner.close();
    }
}
