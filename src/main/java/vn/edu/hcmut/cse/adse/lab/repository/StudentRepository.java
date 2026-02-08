package vn.edu.hcmut.cse.adse.lab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hcmut.cse.adse.lab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
    // Tìm kiếm sinh viên theo tên (không phân biệt hoa thường)
    List<Student> findByNameContainingIgnoreCase(String name);
}