package learn.springboot.mvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import learn.springboot.mvcdemo.entity.Student;
import learn.springboot.mvcdemo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }

    // Hien thi form creat student
    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        // Cach chuyen sang 1 cai url moi
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

}
