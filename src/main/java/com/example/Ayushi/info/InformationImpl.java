package com.example.Ayushi.info;
import com.example.Ayushi.dao.StudentDetailsDao;
import com.example.Ayushi.dto.StudentDetailsDTO;
import com.example.Ayushi.dto.StudentRequestDTO;
import com.example.Ayushi.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InformationImpl implements Information {

    @Autowired
    private StudentDetailsDao studentDetailsDao;

    @Override
    public Boolean saveDetails(StudentDetailsDTO studentDetailsDTO) {
        boolean isSaved = Boolean.TRUE;
        if(null != studentDetailsDTO.getRollNo()) {
            StudentModel studentModel = new StudentModel();
            studentModel.setRollNo(studentDetailsDTO.getRollNo());
            studentModel.setName(studentDetailsDTO.getName());
            studentModel.setFatherName(studentDetailsDTO.getFatherName());
            studentModel.setMotherName(studentDetailsDTO.getMotherName());
            studentModel.setAddress(studentDetailsDTO.getAddress());
            studentModel.setContact(studentDetailsDTO.getPhoneNumber());
            studentDetailsDao.save(studentModel);
        } else {
            isSaved = Boolean.FALSE;
        }
        return isSaved;
    }

    @Override
    public List<StudentDetailsDTO> postStudentDetails(StudentRequestDTO studentRequestDTO) {
        Long rollNoToFetch = studentRequestDTO.getRollNo();
        List<StudentDetailsDTO> result = new ArrayList<>();

        List<StudentModel> dbModels = new ArrayList<>();
        if (Objects.nonNull(rollNoToFetch) && rollNoToFetch != 0) {
            dbModels = studentDetailsDao.findAllById(List.of(rollNoToFetch));
        } else {
            dbModels = studentDetailsDao.findAll();
        }
        if (!CollectionUtils.isEmpty(dbModels)) {
            dbModels.forEach(model -> {
                StudentDetailsDTO dto = new StudentDetailsDTO();
                dto.setRollNo(model.getRollNo());
                dto.setName(model.getName());
                dto.setFatherName(model.getFatherName());
                dto.setMotherName(model.getMotherName());
                dto.setAddress(model.getAddress());
                dto.setPhoneNumber(model.getContact());
                result.add(dto);
            });
        }
        return result;
    }
    @Override
    public void deleteStudentDetails(Long roll_no){
        studentDetailsDao.deleteByRollNo(roll_no);
    }
}

