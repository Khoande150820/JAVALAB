package util;

import java.time.Clock;
import java.util.*;

public class Validate {

    private final static Scanner sc = new Scanner(System.in);

    // Check user Integer input limit
    static int validateInteger(int min, int max) {
        // loop until user input integer in rage min - max
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter number in range [" + min + ", " + max + "]");
                System.err.println("Please try again");
            }
        }
    }

    static double validateDouble(double min, double max) {
        // loop until user input integer in rage min - max
        while (true) {
            try {
                double result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter number in range [" + min + ", " + max + "]");
                System.err.println("Please try again");
            }
        }
    }

    public static String validateString() {
        // loop until user enter non empty string
        while (true) {
            try {
                String result = sc.nextLine();
                if (result.isEmpty()) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Input is empty!");
                System.err.println("Please try again: ");
            }
        }
    }

    public static double validateSalary() {
        while (true) {
            try {
                double salary = Integer.parseInt(sc.nextLine().trim());
                if (salary <= 0) {
                    throw new NumberFormatException();
                }
                return salary;
            } catch (NumberFormatException e) {
                System.err.println("Input must be positive!");
                System.err.println("Please try again: ");
            }
        }
    }

    public static boolean isUnique(ArrayList<Worker> workerList, String id) {
        // loop through every id in worker list
        for (Worker worker : workerList) {
            // if worker is not unique return false
            if (worker.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static String getWorkerId(ArrayList<Worker> workerList) {
        while (true) {
            try {
                String id = validateString();
                if (!isUnique(workerList, id)) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.out.println("Worker id must be unique!");
                System.err.print("Enter worker id");
            }
        }
    }

    public static Worker getWorkerByCode(String id, ArrayList<Worker> workerList) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

}
