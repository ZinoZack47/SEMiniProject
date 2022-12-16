package DAO;

public class Module {
    int code;
    String name;
    Semester semester;
    Sector sector;

    public Module() { }

    public Module(int code, String name, Semester semester, Sector sector) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.sector = sector;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
