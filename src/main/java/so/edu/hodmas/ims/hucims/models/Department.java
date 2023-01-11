package so.edu.hodmas.ims.hucims.models;

public class Department {
    private int dept_name;
    private String name;
    private double budget;

    public Department(int dept_name, String name, double budget) {
        this.dept_name = dept_name;
        this.name = name;
        this.budget = budget;
    }

    public int getDept_name() {
        return dept_name;
    }

    public void setDept_name(int dept_name) {
        this.dept_name = dept_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
