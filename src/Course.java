public class Course {
    private int id;
    private String name;
    private String ins_name;
    private int credit;


    public Course(int id, String name, int credit , String ins_name) {
        this.id = id;
        this.name = name;
        this.ins_name = ins_name;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getIns_name() {
        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }
}
