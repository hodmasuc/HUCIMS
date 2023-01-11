package so.edu.hodmas.ims.hucims.models;

public class Instructor {
    private int ID;
    private String name;
    private String dept_name;
    private double salary;

    public Instructor(int ID, String name, String dept_name, double salary) {
        this.ID = ID;
        this.name = name;
        this.dept_name = dept_name;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
