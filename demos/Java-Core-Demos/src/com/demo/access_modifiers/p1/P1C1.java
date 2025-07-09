package com.demo.access_modifiers.p1;
public class P1C1 {
    // package-private is the official name for (default)
    // instance variable
    private String privateVar;
    String defaultVar;
    protected String protectedVar;
    public String publicVar;

    private void privateMethod(){
//        System.out.println(privateVar);
    }

     void defaultMethod(){
        System.out.println(defaultVar);
    }
    protected void protectedMethod(){
//        System.out.println(protectedVar);
    }
    public void publicMethod(){
//        System.out.println(protectedVar);
    }
//    public static void main(String[] args) {
//        P1C1 p1C1 = new P1C1();
//        System.out.println(p1C1.privateVar);
//        p1C1.privateMethod();
//        System.out.println(p1C1.defaultVar);
//        p1C1.defaultMethod();
//    }
}