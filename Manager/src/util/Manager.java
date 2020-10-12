package util;

import java.util.ArrayList;

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

    public static void changeSalary(ArrayList<Worker> workerList, String status) {
        System.out.print("Enter code: ");
        String code = Validate.validateString();
        if (Validate.getWorkerByCode(code, workerList) == null) {
            System.out.println("No employee with such Id on the list!");
            return;
        } else {
            Worker worker = Validate.getWorkerByCode(code, workerList);
            double oldSalary = worker.getSalary();
            double newSalary = 0;
            System.out.print("Enter Salary");
            double changeAmount = Validate.validateSalary();
            if (status.equals("increase")) {
                while (true) {
                    try {
                        newSalary = oldSalary + changeAmount;
                        if (newSalary == oldSalary) {
                            throw new Exception();
                        }
                        worker.setSalary(newSalary);
                        System.out.println("Successful");
                        return;
                    } catch (Exception e) {
                        System.err.println("New salary must be greater than current salary!");
                    }
                }
            } else if (status.equals("decrease")) {
                while (true) {
                    try {
                        newSalary = oldSalary - changeAmount;
                        if (newSalary < 0) {
                            throw new Exception();
                        }
                        worker.setSalary(newSalary);
                        System.out.println("Successful");
                        return;
                    } catch (Exception e) {
                        System.err.print("Salary decrease must be smaller than current salary!");
                    }
                }
            }
            System.out.println("Update salary successful");
        }
    }
    
    
    public static void displayInfo(ArrayList<Worker> workerList){
        System.out.format("%5s %10s %2d %5f %15s", "Id", "Name", "Age", "Salary", "Work Location");
        for (Worker worker: workerList){
            System.out.format("%5s %10s %2d %5f %15s", worker.getId(), 
                    worker.getName(), 
                    worker.getAge(), 
                    worker.getSalary(),
                    worker.getWorkLocation());
        }
    }
}
