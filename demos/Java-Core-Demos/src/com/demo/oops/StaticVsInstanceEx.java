package com.demo.oops;
public class StaticVsInstanceEx {
    public static void main(String[] args) {

        // Static classes do not need instances to access static members
        Employee.companyName  = "The Thrilling Company";
        //String companyName = Employee.companyName;
        System.out.println(Employee.companyName);
        Employee employee1 = new Employee();
        employee1.employeeName = "Peter";
//        employee1.companyName = "The Fantastic Company";
        System.out.println(employee1.employeeName);
        Employee employee2 = new Employee();
        employee2.employeeName = "Sam";
        System.out.println(employee2.employeeName);
        employee2.companyName = "The Zing Zing Company!";
        System.out.println(employee2.companyName);
        System.out.println(Employee.companyName);
    }
}

class Employee {
    //    static variable / common for all the objects of the same class
//    public final static String companyName = "The Amazing Company";
//    public  static String companyName = "The Amazing Company";
    public static String companyName;
//    public static String zoomId;
    //   each object has its own copy
    public String employeeName;
}