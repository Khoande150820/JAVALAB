
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import util.Manager;
import util.Worker;
import util.History;
import util.Validate;

public class Main {

    static ArrayList<Worker> readWorkerData() throws IOException {
        String filename = "workerData.txt";
        {
            try {
                ArrayList<Worker> workerList = new ArrayList<>();
                FileReader f = new FileReader(filename);
                BufferedReader br = new BufferedReader(f);
                String line;
                while ((line = br.readLine()) != null) {

                    String[] arrOfString = line.split("[|]", 0);
                    String id = arrOfString[0].trim();
                    String name = arrOfString[1].trim();
                    int age = Integer.parseInt(arrOfString[2].trim());
                    double salary = Double.parseDouble(arrOfString[3].trim());
                    String workLocation = arrOfString[4].trim();
                    workerList.add(new Worker(id, name, age, salary, workLocation));

                }
                br.close();
                return workerList;
            } catch (FileNotFoundException e) {
                return new ArrayList<>();
            }
        }
    }

    static ArrayList<History> readSalaryHistoryData(ArrayList<Worker> workerList) throws IOException {
        String filename = "historyData.txt";
        while (true) {
            try {
                ArrayList<History> historyList = new ArrayList<>();
                FileReader f = new FileReader(filename);
                BufferedReader br = new BufferedReader(f);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] arrOfString = line.split("[|]", 0);
                    String id = arrOfString[0].trim();
                    double salaryChange = Double.parseDouble(arrOfString[1].trim());
                    String status = arrOfString[2].trim();
                    String date = arrOfString[3].trim();
                    Worker w = Validate.getWorkerByCode(id, workerList);
                    History history = new History(status, date, id, w.getName(), w.getAge(), salaryChange, w.getWorkLocation());
                    historyList.add(history);

                }
                br.close();
                return historyList;

            } catch (FileNotFoundException e) {
                return new ArrayList<>();
            } 
        }
    }

    static void saveWorkerList(ArrayList<Worker> workerList) throws FileNotFoundException {
        File output = new File("workerData.txt");
        try (PrintWriter pw = new PrintWriter(output)) {
            for (Worker w : workerList) {
                pw.println(w.getId() + "|" + w.getName() + "|" + w.getAge() + "|" + w.getSalary() + "|" + w.getWorkLocation());
            }
        }
    }

    static void saveHistory(ArrayList<History> historyList) throws FileNotFoundException {
        File output = new File("historyData.txt");
        try (PrintWriter pw = new PrintWriter(output)) {
            for (History h : historyList) {
                pw.println(h.getId() + "|" + h.getSalary() + "|" + h.getStatus() + "|" + h.getDate());
            }
        }
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Worker> workerList = readWorkerData();

//        ArrayList<Worker> workerList = new ArrayList<>();
        ArrayList<History> salaryHistory = readSalaryHistoryData(workerList);

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

//                    for (Worker w: workerList){
//                        System.out.println(w);
//                    }
//                            
                    System.out.println("Display Information salary");
                    Manager.displaySalaryHistory(salaryHistory);
                    break;
                case 5:
                    saveWorkerList(workerList);
                    saveHistory(salaryHistory);
                    return;
            }
        }
    }

}
