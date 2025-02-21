package org.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.data.entities.Employee;
import org.data.entities.User;
import org.data.services.EmployeeService;
import org.data.services.UserService;

import java.util.List;

public class EmployeeList {
    @PageActivationContext  // Automatically gets value from URL context
    @Property
    private int employeeId;
    @Inject
    private EmployeeService employeeService;

    @Property
    private Employee employee;

    @SessionState
    private User loggedInUser; // Store the logged-in user details

    @Inject
    private UserService userService;

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

//    @InjectPage
//    private IndividualEmployee individualEmployee;

//    Object onActionFromViewDetails(int id) {
//        individualEmployee.setEmployeeId(id);
//        return individualEmployee;
//    }

    void setupRender() {
        employee = employeeService.getEmployeeById(employeeId);
    }


        public boolean getHasEditPermission() {
            return userService.hasPermission(loggedInUser.getUsername(), "EDIT");
        }

}


