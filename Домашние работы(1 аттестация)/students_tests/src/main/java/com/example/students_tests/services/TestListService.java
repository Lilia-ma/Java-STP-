package com.example.students_tests.services;

import com.example.students_tests.models.*;
import com.example.students_tests.repository.*;
import com.example.students_tests.schemas.ResultsByStudents;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class TestListService {
    @Autowired
    TestListRepository testListRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StudAnswRepository studAnswRepository;
    @Autowired
    AnswerRepository answerRepository;

    public List<TestList> allTestLists() {
        return testListRepository.findAll();
    }

    public List<TestList> getTestsListByStudent(Integer student_id) {
        User user = userRepository.findById(student_id).get();
        List<Schedule> schedules = scheduleRepository.findAllByGroupId(user.getGroupId());
        List<TestList> tests = new ArrayList<>();
        for (Schedule sc : schedules) {
            TestList t = testListRepository.findById(sc.getTestId()).get();
            tests.add(t);
        }
        return tests;
    }

    public List<ResultsByStudents> getResultsForStudents() {
        List<ResultsByStudents> results = new ArrayList<>();
        List<User> students = userRepository.findUsersByRoleId(1);
        for (User u : students) {
            ResultsByStudents temp = new ResultsByStudents();
            temp.student = u;
            temp.BallsByTest = new HashMap<>();
            List<StudAnsw> answers = studAnswRepository.findAllByUserId(u.getRowId());
            for (StudAnsw ans : answers) {
                TestList t = testListRepository.findTestListByRowId(ans.getTestId());
                Answer a = answerRepository.findAnswerByRowId(ans.getAnswerId());
                if (!temp.BallsByTest.containsKey(t)) {
                    temp.BallsByTest.put(t, 0);
                }
                if (a.getCorrect()) {
                    temp.BallsByTest.put(t, temp.BallsByTest.get(t) + 1);
                }
            }
            results.add(temp);
        }
        return results;
    }
}
