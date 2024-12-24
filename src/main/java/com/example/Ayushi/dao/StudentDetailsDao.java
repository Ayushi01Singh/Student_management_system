package com.example.Ayushi.dao;
import com.example.Ayushi.model.StudentModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentDetailsDao extends JpaRepository<StudentModel, Long> {
    @Modifying
    @Transactional
    void deleteByRollNo(Long rollNo);
}
