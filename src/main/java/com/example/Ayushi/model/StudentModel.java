package com.example.Ayushi.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="STUDENT_INFO")
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    @Id
    @Column(name="roll_no", columnDefinition = "NUMERIC")
    private Long rollNo;
    @Column(name = "name", columnDefinition = "varchar")
    private String name;
    @Column(name = "father_name", columnDefinition = "varchar")
    private String fatherName;
    @Column(name = "mother_name", columnDefinition = "varchar")
    private String motherName;
    @Column(name = "address", columnDefinition = "varchar")
    private String address;
    @Column(name = "contact", columnDefinition = "NUMERIC")
    private Long contact;

}


