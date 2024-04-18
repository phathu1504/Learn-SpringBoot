package learn.springboot.demo.common;

import jakarta.persistence.EntityManager;
import learn.springboot.demo.dao.SinhVienImpl;
import learn.springboot.demo.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienImpl svd, SinhVienImpl sinhVienImpl) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("===========================");
                printMenu();
                int choose = sc.nextInt();
                sc.nextLine();
                if (choose == 1) {

                    // lay thong tin sinh vien
                    System.out.println("Nhap ho dem: ");
                    String ho_dem = sc.nextLine();
                    System.out.println("Nhap ho ten: ");
                    String ten = sc.nextLine();
                    System.out.println("Nhap email: ");
                    String email = sc.nextLine();

                    SinhVien sv = new SinhVien(email, ten, ho_dem);

                    // luu xuong co so du lieu
                    svd.save(sv);
                } else if (choose == 2) {
                    System.out.println("Nhap masv: ");
                    int masv = sc.nextInt();
                    SinhVien sv = svd.getById(masv);
                    if (sv != null) {
                        System.out.println(sv.toString());
                    } else {
                        System.out.println("Khong co sinh vien!");
                    }
                } else if (choose == 3) {
                    List<SinhVien> list = svd.getAllSinhVien();
                    for (SinhVien sv : list) {
                        System.out.println(sv.toString());
                    }
                } else if (choose == 4) {
                    System.out.println("Nhap ten sinh vien can tim: ");
                    String ten = sc.nextLine();
                    List<SinhVien> list = svd.getByName(ten);

                    for (SinhVien sv : list) {
                        System.out.println(sv.toString());
                    }

                } else if (choose == 5) {
                    System.out.println("Nhap id sinh vien can tim: ");
                    int id = sc.nextInt();
                    SinhVien sv = svd.getById(id);

                    if (sv != null) {
                        sc.nextLine();
                        System.out.println("Nhap ho dem: ");
                        String ho_dem = sc.nextLine();
                        System.out.println("Nhap ho ten: ");
                        String ten = sc.nextLine();
                        System.out.println("Nhap email: ");
                        String email = sc.nextLine();

                        sv.setTen(ten);
                        sv.setEmail(email);
                        sv.setHoDem(ho_dem);

                        svd.updateSinhVien(sv);
                    } else {
                        System.out.println("Khong co sinh vien!");
                    }
                } else if (choose == 6) {

                    System.out.println("Nhap ten sinh vien can sua: ");
                    String ten = sc.nextLine();
                    int row = svd.updateAllTen(ten);
                    System.out.println(row + " da thay doi");
                }else if(choose == 7){
                    System.out.println("Nhap id sinh vien can xoa: ");
                    int id = sc.nextInt();
                    svd.deleteSinhVien(id);
                }else if (choose == 8){
                    System.out.println("Nhap ho dem sinh vien can xoa: ");
                    String hodem = sc.nextLine();
                    svd.deleteSinhVienByCondition(hodem);
                }
            }
        };
    }

    public void printMenu() {
        System.out.println("Menu:\n"
                + "1. Them sinh vien.\n" +
                "2. Tim sinh vien. \n" +
                "3. Tim tat ca sinh vien. \n" +
                "4. Tim ten sinh vien \n" +
                "5. Cap nhap ten sinh vien dua tren id \n" +
                "6. Cap nhap tat ca thong tin sinh vien\n" +
                "7. Xoa sinh vien theo id\n" +
                "8. Xoa sinh vien theo ho dem");
    }
}
