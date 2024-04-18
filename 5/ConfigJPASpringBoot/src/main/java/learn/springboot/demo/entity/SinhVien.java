package learn.springboot.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sinhvien")
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ho_dem", length = 45)
    private String hoDem;

    @Column(name = "ten", length = 45)
    private String ten;

    private String email;

    public SinhVien() {}

    public SinhVien(String email, String ten, String hoDem) {
        this.email = email;
        this.ten = ten;
        this.hoDem = hoDem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // to string

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
