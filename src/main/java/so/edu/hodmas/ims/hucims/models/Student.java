package so.edu.hodmas.ims.hucims.models;

public class Student {
    private int ID;
    private String name;
    private String dept_name;
    private double tot_cred;

    public Student(int ID, String name, String dept_name, double tot_cred) {
        this.ID = ID;
        this.name = name;
        this.dept_name = dept_name;
        this.tot_cred = tot_cred;
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

    public double getTot_cred() {
        return tot_cred;
    }

    public void setTot_cred(double tot_cred) {
        this.tot_cred = tot_cred;
    }
}
