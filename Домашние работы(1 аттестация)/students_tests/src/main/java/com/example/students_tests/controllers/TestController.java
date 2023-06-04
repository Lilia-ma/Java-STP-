package com.example.students_tests.controllers;

import com.example.students_tests.models.Schedule;
import com.example.students_tests.models.TestList;
import com.example.students_tests.models.User;
import com.example.students_tests.repository.ScheduleRepository;
import com.example.students_tests.repository.UserRepository;
import com.example.students_tests.schemas.ResultsByStudents;
import com.example.students_tests.services.TestListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestListService testListService;


    @GetMapping("/list")
    public List<TestList> allTests() {
        return testListService.allTestLists();
    }

    @GetMapping("/get_next_tests_for_student/{student_id}")
    public List<TestList> getNextTestsForStudent(@PathVariable Integer student_id) {
        return testListService.getTestsListByStudent(student_id);

    }
    @GetMapping("/results")
    public List<ResultsByStudents> getResultsForStudents() {
        return testListService.getResultsForStudents();

    }
}
