package util;

/**
 *
 * @author eldee
 */
public class History extends Worker implements Comparable<History>{

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

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getWorkLocation() {
        return workLocation;
    }

    @Override
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
        public int compareTo(History t) {
        return this.getId().compareTo(t.getId());
    }
 

}
