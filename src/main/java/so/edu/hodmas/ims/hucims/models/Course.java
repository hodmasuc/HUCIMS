package so.edu.hodmas.ims.hucims.models;

public class Course {
    private int course_id;
    private String title;
    private String dept_name;
    private double credits;

    public Course(int course_id, String title, String dept_name, double credits) {
        this.course_id = course_id;
        this.title = title;
        this.dept_name = dept_name;
        this.credits = credits;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
}
