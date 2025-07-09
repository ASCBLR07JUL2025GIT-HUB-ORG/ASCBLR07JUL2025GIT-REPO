package com.demo.oops;

public class StaticEx {
    public static void main(String[] args) {
        System.out.println(Employee1.companyName);
        System.out.println(Employee1.CEO);
        Employee1.displayCompanyDetails();
    }
}


class Employee1 {
    public static String companyName = "AZ";
    public static String CEO = "Busy!";

    public static void  displayCompanyDetails(){
        System.out.println(companyName);
        System.out.println(CEO);
    }
}