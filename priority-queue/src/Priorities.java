import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

    private final PriorityQueue<Student> queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparing(Student::getId));

    public List<Student> getStudents(List<String> events) {
        events.forEach((event) -> {
            if (event.equals("SERVED")) {
                queue.poll();
            } else {
                String[] details = event.split(" ");
                queue.add(new Student(details[1], Double.parseDouble(details[2]),
                        Integer.parseInt(details[3])));
            }
        });

        List<Student> students = new ArrayList<>();
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}
