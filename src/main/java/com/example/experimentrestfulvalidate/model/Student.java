package com.example.experimentrestfulvalidate.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Student {

    private String name;
    private String city;
    private int age;
}
