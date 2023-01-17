package so.edu.hodmas.ims.hucims.models;

public class Student {
    private Long id;
    private String name;
    private String dept_name;
    private double tot_cred;

    public Student(Long id, String name, String dept_name, double tot_cred) {
        this.id = id;
        this.name = name;
        this.dept_name = dept_name;
        this.tot_cred = tot_cred;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
