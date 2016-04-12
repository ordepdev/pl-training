package com.ordepdev.memento;

public class MementoDemo {

    public static void main(String[] args) {

        Caretaker caretaker = new Caretaker();
        Employee employee = new Employee("Name 1", "Address 1", "Phone 1");
        System.out.println("Employee before save: " + employee);
        caretaker.save(employee);

        employee.setPhone("Phone 2");
        caretaker.save(employee);
        System.out.println("Save new phone: " + employee);

        employee.setPhone("Phone 3");
        caretaker.revert(employee);
        System.out.println("Reverts to last save point: " + employee);

        caretaker.revert(employee);
        System.out.println("Reverts to original: " + employee);
    }
}
