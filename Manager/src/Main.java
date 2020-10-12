
import java.util.ArrayList;
import util.Manager;
import util.Worker;

public class Main {

    public static void main(String[] args) {

        ArrayList<Worker> workerList = new ArrayList<>();

        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addWorker(workerList);
                    break;
                case 2:
                    Manager.changeSalary(workerList, "increase");
                    break;
                case 3:
                    Manager.changeSalary(workerList, "decrease");
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }

    }

}
