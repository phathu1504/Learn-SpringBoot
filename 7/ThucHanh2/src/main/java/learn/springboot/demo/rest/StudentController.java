package learn.springboot.demo.rest;

import jakarta.annotation.PostConstruct;
import learn.springboot.demo.entity.ErrorResponse;
import learn.springboot.demo.entity.SinhVien;
import learn.springboot.demo.exception.StudentExection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    public List<SinhVien> listSinhVien;


    @PostConstruct  //Phuong thuc nay se thuc hien ngay sau khi @RestController duoc tao ra
    public void createList() {
        listSinhVien = new ArrayList<SinhVien>();
        listSinhVien.add(new SinhVien(1, "Phan Hoang Anh Thu", 20, "CNTT", 9));
        listSinhVien.add(new SinhVien(2, "Ta Nguyen Hoang Son", 18, "Marketing", 10));
        listSinhVien.add(new SinhVien(3, "Ho Ngoc Ha", 19, "TKDH", 9));
        listSinhVien.add(new SinhVien(4, "Thu Ha", 20, "Ke Toan", 8));
        listSinhVien.add(new SinhVien(5, "Doan Thai Bao", 22, "Kien Truc", 9));
        listSinhVien.add(new SinhVien(6, "Thai Anh", 23, "Bac Si", 5));
    }


    @GetMapping("/")
    public List<SinhVien> getList() {
        return listSinhVien;
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVienId(@PathVariable int id) {
        SinhVien result = null;
        for (SinhVien student : listSinhVien) {
            if (student.getId() == id) {
                return student;
            }
        }

        if (result == null) {
            throw new StudentExection("Khong tim thay sinh vien voi id la " + id);
        }
        return null;
    }

    @GetMapping("/index/{index}")
    public SinhVien getStudentIndex(@PathVariable int index) {
        try{
            SinhVien student = listSinhVien.get(index);
            return student;
        }catch (IndexOutOfBoundsException e) {
            throw new StudentExection(e.getMessage());
        }
    }

//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> batloi(StudentExection ex){
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> batLoiTatCa(Exception ex){
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }

}
