package learn.springboot.demo.entity;

public class SinhVien {
    private int id;
    private String name;
    private int age;
    private String major;
    private double dtb;

    public SinhVien(int id, String name, int age, String major, double dtb) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.major = major;
        this.dtb = dtb;
    }

    public SinhVien() {

    }

    //Jackson
    // class -> json  thong qua funtion getter
    // json -> class thong qua funtion setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
