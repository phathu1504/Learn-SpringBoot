package learn.springboot.demo.dao;

import learn.springboot.demo.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {

    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAllSinhVien();

    public List<SinhVien> getByName(String name);

    public int updateAllTen(String ten);


    public void updateSinhVien(SinhVien sinhVien);

    public void deleteSinhVien(int id);
    public void deleteSinhVienByCondition(String ten);
}
