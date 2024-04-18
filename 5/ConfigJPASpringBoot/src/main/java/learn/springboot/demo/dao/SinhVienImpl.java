package learn.springboot.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import learn.springboot.demo.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SinhVienImpl implements SinhVienDAO {

    private EntityManager em;

    @Autowired
    public SinhVienImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.em.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return this.em.find(SinhVien.class, id);
    }

    @Override
    public List<SinhVien> getAllSinhVien() {
        String jpql = "SELECT s FROM SinhVien s";
        return this.em.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public List<SinhVien> getByName(String name) {
        String jpql = "SELECT s FROM SinhVien s WHERE s.ten = :ten";
        TypedQuery<SinhVien> query = this.em.createQuery(jpql, SinhVien.class);
        query.setParameter("ten", name);
        return query.getResultList();
    }

    @Override
    public void updateSinhVien(SinhVien sinhVien) {
        this.em.merge(sinhVien);
    }

    @Override
    public void deleteSinhVien(int id) {
        SinhVien sinhVien = this.em.find(SinhVien.class, id);
        this.em.remove(sinhVien);
    }

    @Override
    public void deleteSinhVienByCondition(String hodem) {
        String jpql = "DELETE FROM SinhVien s WHERE hoDem = :hoDem";
        Query query = this.em.createQuery(jpql);
        query.setParameter("hoDem", hodem);
        query.executeUpdate();
    }


    @Override
    public int updateAllTen(String ten) {
        String jpql = "UPDATE SinhVien s SET s.ten = :ten";
        Query query = this.em.createQuery(jpql);
        query.setParameter("ten", ten);
        return query.executeUpdate();
    }
}
