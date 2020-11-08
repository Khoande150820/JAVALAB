
public class Student {

    private String name;
    private String className;
    private double math;
    private double physic;
    private double chemistry;

    public Student() {
    }

    public Student(String name, String className, double math, double physics, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physic = physics;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physic;
    }

    public void setPhysical(double physical) {
        this.physic = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getAverageStudent() {
        return (this.chemistry + this.math + this.physic) / 3;
    }

    String getStudentType() {
        if (getAverageStudent() > 7.5) {
            return "A";
        } else if (getAverageStudent() >= 6 && getAverageStudent() <= 7.5) {
            return "B";
        } else if (getAverageStudent() >= 4 && getAverageStudent() < 6) {
            return "C";
        }
        return "D";
    }
}
