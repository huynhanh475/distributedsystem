package com.year3.distributedsystem.lecture4.hello;

import java.rmi.Naming;

public class HelloClient {

    public static void main (String[] args) {
        HelloInterface hello;
        String name = "rmi://localhost:1024/HelloServer";
        try {
            hello = (HelloInterface) Naming.lookup(name);
            System.out.println(hello.say());
        }
        catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }
    }
}
