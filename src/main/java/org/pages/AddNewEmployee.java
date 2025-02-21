package org.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.data.entities.Employee;
import org.data.services.EmployeeService;

public class AddNewEmployee {

        @Property
        private String name;

        @Property
        private int age;

        @Property
        private String address;

        @Property
        private String errorMessage;
        @Inject
        private EmployeeService employeeService;

        @Property
        private Employee employee;

        @InjectPage
        private EmployeeList employeeList;
        @InjectComponent
        private Zone designationZone;

        @InjectPage
        private Login loginPage;  // For logout redirection


//        void onValidateFromAddEmployeeForm() {
//            if (name == null || name.isEmpty() || age < 18 || address == null || address.isEmpty()) {
//                errorMessage = "All fields are required!";
//            }
//        }

        Object onSuccessFromAddEmployeeForm() {
            if (errorMessage == null) {
                Employee newEmployee = new Employee();
                newEmployee.setName(name);
                newEmployee.setAge(age);
                newEmployee.setAddress(address);

                employeeService.saveEmployee(newEmployee);
                return employeeList;
            }
            return null;
        }


    void onActivate(int id) {
        employee = employeeService.getEmployeeById(id);
    }

    void onActionFromShowImage() {
        String imageUrl = employee.getImageUrl();
    }


    Object onPromoteEmployee(int id) {
        employee = employeeService.getEmployeeById(id);
        employee.setDesignation("Manager");
        employeeService.saveEmployee(employee);

        return designationZone;
    }
    Object onActionFromClose() {
        return loginPage;
    }

}
