
import java.util.ArrayList;

/**
 *
 * @author eldee
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        System.out.println("====Management Student Program=========");
        //Step 1: Get student info
        while (true) {
            Manage.createStudent(studentList);
            System.out.print("Do you want to enter more student information? (Y/N): ");
            if(!Validate.getYNinput()){
                break;
            }
        }
        
        // Step 2: Print student info to screen
        Manage.displayStudentInfo(studentList);
        // Step 3: Display Classification info
        Manage.getPercentTypeStudent(studentList);
       
    }

}
