package com.spring.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please Enter a valid data")
    @Column(nullable = false)
    private String firstname;

    @NotEmpty(message = "Please Enter a valid data")
    @Column(nullable = false)
    private String lastname;

    @NotNull(message = "Please Enter a valid data")
    @Column(nullable = false)
    private Double grade;

    private LocalDateTime createDate = LocalDateTime.now();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getCreateDate() {
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return createDate.format(dtf);
    }

   /* public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }*/
}
