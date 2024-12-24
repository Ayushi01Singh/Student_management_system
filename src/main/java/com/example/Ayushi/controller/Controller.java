package com.example.Ayushi.controller;
import com.example.Ayushi.dto.StudentDetailsDTO;
import com.example.Ayushi.dto.StudentRequestDTO;
import com.example.Ayushi.model.StudentModel;
import com.example.Ayushi.info.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(
        origins = {
                "http://localhost:4200",
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        }
)

@RestController
public class Controller {

    @Autowired
    private Information information;

    @DeleteMapping(value="/student/delete/{roll_no}")
    public ResponseEntity<Boolean> deleteStudentDetails(@PathVariable("roll_no") Long roll_no){
        information.deleteStudentDetails(roll_no);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value="/student/get")
    public ResponseEntity<List<StudentDetailsDTO>> postStudentDetails(@RequestBody(required = true) StudentRequestDTO studentRequestDTO) {
        List<StudentDetailsDTO> studentDetails = information.postStudentDetails(studentRequestDTO);
        return new ResponseEntity<>(studentDetails, HttpStatus.OK);
    }

    @PutMapping(value = "/student/save")
    public ResponseEntity<Boolean> saveUserDetails(@RequestBody(required = true)StudentDetailsDTO studentDetailsDTO) {
        Boolean isSaved = information.saveDetails(studentDetailsDTO);
        return new ResponseEntity<>(isSaved, HttpStatus.ACCEPTED);
    }

}
