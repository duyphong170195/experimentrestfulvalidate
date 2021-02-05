package com.example.experimentrestfulvalidate.controllers;

import com.example.experimentrestfulvalidate.model.Student;
import com.example.experimentrestfulvalidate.request.HelloRequest;
import com.example.experimentrestfulvalidate.request.StudentRequest;
import com.example.experimentrestfulvalidate.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public ResponseEntity<?> createHello() {
        Student student = new Student("phong", "HN", 3);


        helloService.hello();

        return ResponseEntity.ok(student);
    }

    @RequestMapping(value = "/createHello", method = RequestMethod.POST)
    public ResponseEntity<HelloRequest> createHello(@Valid @RequestBody HelloRequest helloRequest) {


        return ResponseEntity.ok(helloRequest);
    }

    @RequestMapping(value = "/createStudent", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentRequest.get();

        return ResponseEntity.ok(student);
    }
}
