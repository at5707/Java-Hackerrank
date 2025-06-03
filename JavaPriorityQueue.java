import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id,String name,double cgpa) {
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }
}
class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue=new PriorityQueue<>(
            new Comparator<Student>() {
                public int compare(Student a,Student b) {
                    if (Double.compare(b.getCGPA(),a.getCGPA())!=0) {
                        return Double.compare(b.getCGPA(),a.getCGPA());
                    } else if (!a.getName().equals(b.getName())) {
                        return a.getName().compareTo(b.getName());
                    } else {
                        return Integer.compare(a.getID(),b.getID());
                    }
                }
            }
        );
        for (String event:events) {
            if (event.startsWith("ENTER")) {
                String[] parts=event.split(" ");
                String name=parts[1];
                double cgpa=Double.parseDouble(parts[2]);
                int id=Integer.parseInt(parts[3]);
                queue.add(new Student(id,name,cgpa));
            } else if (event.equals("SERVED")) {
                queue.poll();
            }
        }
        List<Student> result=new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
