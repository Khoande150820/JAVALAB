package util;

/**
 *
 * @author eldee
 */
public class History extends Worker implements Comparable<History> {

    String status;
    String date;

    public History() {
    }

    public History(String status, String date, String id, String name, int age, double salary, String workLocation){
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    
    
    @Override
    public int compareTo(History t) {
        return this.getId().compareTo(t.getId());
    }

}
