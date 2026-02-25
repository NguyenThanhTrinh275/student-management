package vn.edu.hcmut.cse.adse.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.hcmut.cse.adse.lab.service.StudentService;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentWebController {
    @Autowired private StudentService service;

    // 1. Trang danh sách có tìm kiếm
    @GetMapping
    public String listStudents(@RequestParam(required = false) String keyword, Model model) {
        List<Student> students = (keyword != null) ? service.searchByName(keyword) : service.getAll();
        model.addAttribute("dsSinhVien", students);
        return "students";
    }

    // 2. Trang thêm mới
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    // 3. Trang chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-form";
    }

    // 4. Lưu sinh viên (Thêm & Sửa)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    // 5. Xem chi tiết
    @GetMapping("/{id}")
    public String viewDetail(@PathVariable String id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "student-detail";
    }

    // 6. Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}