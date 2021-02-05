package com.example.experimentrestfulvalidate.request;

import com.example.experimentrestfulvalidate.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private String city;
    private int age;

    public Student get() {
        return new Student(name, city, age).toBuilder().build();
    }
}
