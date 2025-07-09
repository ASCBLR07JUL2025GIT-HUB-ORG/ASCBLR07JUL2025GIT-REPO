package com.demo.access_modifiers.p2;

import com.demo.access_modifiers.p1.P1C1;

public class P2C2 extends P1C1 {
    public  void main(String[] args) {
        P1C1 p1C1 = new P1C1();
//        System.out.println(p1C1.privateVar);
//        p1C1.privateMethod();
//        System.out.println(p1C1.defaultVar);
//        p1C1.defaultMethod();
//        System.out.println(p1C1.protectedVar);
//        p1C1.protectedMethod();
//        System.out.println(privateVar);
//        System.out.println(defaultVar);
//         defaultMethod();
         System.out.println(protectedVar);
         protectedMethod();
        System.out.println(p1C1.publicVar);
        p1C1.publicMethod();
//        p1C1.protectedVar;
//        p1C1.protectedMethod();


    }

//    protected String protectedVar;
//    protected void protectedMethod(){
//        System.out.println(protectedVar);
//    }

}
