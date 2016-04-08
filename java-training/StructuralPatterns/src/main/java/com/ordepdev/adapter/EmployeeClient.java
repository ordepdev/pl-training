package com.ordepdev.adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

    public List<Employee> getEmployeeList() {

        List<Employee> employees = new ArrayList<>();
        Employee employeeFromDB = new EmployeeDB("1", "Foo", "Bar", "foo@bar.com");
        employees.add(employeeFromDB);

        // We can't add an EmployeeLdap to a List<Employee>
        // This is where the adapter comes into play.
        //EmployeeLdap employeeFromLdap = new EmployeeLdap("2", "Bar", "Foo", "bar@foo.com");
        //employees.add(employeeFromLdap);

        EmployeeLdap employeeFromLdap = new EmployeeLdap("2", "Bar", "Foo", "bar@foo.com");
        employees.add(new EmployeeAdapterLdap(employeeFromLdap));

        EmployeeCSV employeeFromCSV = new EmployeeCSV("3,Foo,Zar,foo@zar.com");
        employees.add(new EmployeeAdapterCSV(employeeFromCSV));

        return employees;
    }
}
