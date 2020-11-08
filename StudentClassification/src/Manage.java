
import java.util.ArrayList;

public class Manage {

    static void createStudent(ArrayList<Student> studentList) {
        System.out.print("Name: ");
        String name = Validate.getInputString();
        System.out.print("Class: ");
        String className = Validate.getInputString();
//        System.out.print("Maths: ");
        double math = Validate.getMark("Maths");
//        System.out.print("Chemistry: ");
        double chemistry = Validate.getMark("Chemistry");
//        System.out.print("Physics: ");
        double physic = Validate.getMark("Physics");
        studentList.add(new Student(name, className, math, physic, chemistry));
    }

    static void displayStudentInfo(ArrayList<Student> studentList) {
        int studentCount = 0;
        for (Student s : studentList) {
            studentCount++;
            System.out.println("--------Student" + studentCount + " Info--------");
            System.out.println("Name: " + s.getName());
            System.out.println("Class: " + s.getClassName());
            System.out.println("AVG: " + s.getAverageStudent());
            System.out.println("Type: " + s.getStudentType());
        }
    }

    static void getPercentTypeStudent(ArrayList<Student> studentList) {
        int totalStudents = studentList.size();
        if (totalStudents == 0) {
            System.out.println("No student entered!");
            return;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (Student s : studentList) {
            switch (s.getStudentType()) {
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "C":
                    c++;
                    break;
                case "D":
                    d++;
                    break;
                default:
                    break;
            }
        }
        double aPercentage = a / totalStudents * 100;
        double bPercentage = b / totalStudents * 100;
        double cPercentage = c / totalStudents * 100;
        double dPercentage = d / totalStudents * 100;

        System.out.println("----Classification info-----");
        System.out.printf("A: %.0f%%\n", aPercentage);
        System.out.printf("B: %.0f%%\n", bPercentage);
        System.out.printf("C: %.0f%%\n", cPercentage);
        System.out.printf("D: %.0f%%\n", dPercentage);
    }
}
