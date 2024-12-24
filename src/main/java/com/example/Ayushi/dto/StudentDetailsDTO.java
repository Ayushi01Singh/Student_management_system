package com.example.Ayushi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class StudentDetailsDTO{
    private Long rollNo;
    private  String name;
    private  String fatherName;
    private  String motherName;
    private  String address;
    private Long phoneNumber;

}
