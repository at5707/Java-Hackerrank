import java.util.*;
import java.io.*;

class JavaMap {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // consume newline after reading int

        // Use HashMap to store phone book
        Map<String, Integer> phoneBook = new HashMap<>();

        // Read n entries
        for (int i = 0; i < n; i++) {
            String name = in.nextLine(); // could be "first-name" or "first-name last-name"
            int phone = in.nextInt();
            in.nextLine(); // consume newline
            phoneBook.put(name, phone);
        }

        // Process queries until end-of-file
        while (in.hasNext()) {
            String query = in.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}
