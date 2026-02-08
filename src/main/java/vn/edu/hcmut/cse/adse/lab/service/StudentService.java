package vn.edu.hcmut.cse.adse.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.hcmut.cse.adse.lab.entity.Student;
import vn.edu.hcmut.cse.adse.lab.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository; // Sử dụng cơ chế Dependency Injection [cite: 295, 327]

    public List<Student> getAll() {
        return repository.findAll(); // Lấy toàn bộ danh sách [cite: 329]
    }

    public Student getById(String id) {
        return repository.findById(id).orElse(null); // Trả về null nếu không tìm thấy [cite: 332]
    }
}