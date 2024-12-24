package com.example.Ayushi.info;
import com.example.Ayushi.dto.StudentDetailsDTO;
import com.example.Ayushi.dto.StudentRequestDTO;

import java.util.List;

public interface Information {

    Boolean saveDetails(StudentDetailsDTO studentDetailsDTO);
    List<StudentDetailsDTO> postStudentDetails(StudentRequestDTO studentRequestDTO);

    void deleteStudentDetails(Long rollNo);
}
