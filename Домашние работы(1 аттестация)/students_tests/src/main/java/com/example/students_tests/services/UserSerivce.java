package com.example.students_tests.services;

import com.example.students_tests.models.User;
import com.example.students_tests.repository.UserRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class UserSerivce {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getOnlyTeachers() {
        return userRepository.findUsersByRoleId(2);
    }

    public List<User> getOnlyStudents() {
        return userRepository.findUsersByRoleId(1);
    }

}
