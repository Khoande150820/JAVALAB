package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import javafx.print.Collation;

public class Manager {

    public static int menu() {
        System.out.println("======== Worker Management =========");
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.validateInteger(1, 5);
        return choice;
    }

    public static void addWorker(ArrayList<Worker> workerList) {
        System.out.println("--------- Add Worker ----------");

        System.out.print("Enter Code: ");
        String id = Validate.getWorkerId(workerList);

        System.out.print("Enter Name: ");
        String name = Validate.validateString();

        System.out.print("Enter Age: ");
        int age = Validate.validateInteger(18, 50);

        System.out.print("Enter Salary: ");
        double salary = Validate.validateSalary();

        System.out.print("Enter work location: ");
        String workLocation = Validate.validateString();

        Worker newWorker = new Worker(id, name, age, salary, workLocation);
        workerList.add(newWorker);
        System.out.println("Add successful!");
    }

    public static void changeSalary(ArrayList<Worker> workerList, String status, ArrayList<History> salaryHistory) {
        System.out.print("Enter code: ");
        String code = Validate.validateString();
        String date = getCurrentDate();
        if (Validate.getWorkerByCode(code, workerList) == null) {
            System.out.println("No employee with such Id on the list!");
            return;
        } else {
            Worker worker = Validate.getWorkerByCode(code, workerList);
            double oldSalary = worker.getSalary();
            double newSalary = 0;
            System.out.print("Enter Salary: ");

            if (status.equals("increase")) {
                while (true) {
                    try {
                        double changeAmount = Validate.validateSalary();
                        newSalary = oldSalary + changeAmount;
                        if (newSalary == oldSalary) {
                            System.err.println("New salary must be greater than current salary!");
                            System.out.print("Enter again: ");
                        }
                        worker.setSalary(newSalary);
                        History history = new History("UP", date, worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
                        System.out.println("Successful");
                        salaryHistory.add(history);
                        return;
                    } catch (Exception e) {
                        
                    }
                }
            } else if (status.equals("decrease")) {
                while (true) {
                    try {
                        double changeAmount = Validate.validateSalary();
                        newSalary = oldSalary - changeAmount;
                        if (newSalary < 0) {
                            System.out.println("Amount decrease must be smaller than " + worker.getSalary());
                            System.out.print("Enter again: ");
                            continue;
                        } else {
                            worker.setSalary(newSalary);
                            History history = new History("DOWN", date, worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
                            salaryHistory.add(history);
                            System.out.println("Successful");
                            return;
                        }
                    } catch (Exception e) {

                    }
                }
            }
            System.out.println("Update salary successful");
        }
    }

    public static String getCurrentDate() {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateformat.format(calendar.getTime());
    }

    public static void displaySalaryHistory(ArrayList<History> salaryHistory) {
        if (salaryHistory.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(salaryHistory);
        for (History h : salaryHistory) {
            printHistory(h);
        }
    }

    public static void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10.2f%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }

}
