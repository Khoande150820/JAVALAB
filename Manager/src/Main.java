
import java.util.ArrayList;
import util.Manager;
import util.Worker;
import util.History;

public class Main {

    public static void main(String[] args) {

        ArrayList<Worker> workerList = new ArrayList<>();
        ArrayList<History> salaryHistory = new ArrayList<>();

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addWorker(workerList);
                    break;
                case 2:
                    System.out.println("Up salary: ");
                    Manager.changeSalary(workerList, "increase", salaryHistory);
                    break;
                case 3:
                    System.out.println("Down salary: ");
                    Manager.changeSalary(workerList, "decrease", salaryHistory);
                    break;
                case 4:
                    System.out.println("Display Information salary");
                    Manager.displaySalaryHistory(salaryHistory);
                    break;
                case 5:
                    return;
            }
        }
    }

}
