public class Student {

    private final int id;
    private final String name;
    private final double cgpa;

    public Student( String name, double cgpa ,int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}
