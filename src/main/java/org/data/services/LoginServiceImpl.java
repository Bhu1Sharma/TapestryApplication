package org.data.services;

import org.data.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LoginServiceImpl implements LoginService {

    private final EmployeeRepository empRepository;

    @Autowired
    public LoginServiceImpl(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public boolean isValidUser(String username, String password) {
        return empRepository.checkCredentials(username, password);
    }
}
