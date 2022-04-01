package com.year3.distributedsystem.lecture4.hello;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1024);
            Naming.rebind("rmi://localhost:1024/HelloServer",
                    new Hello("Hello, world!"));
            System.out.println("Hello Server is ready.");
        } catch (Exception e) {
            System.out.println("Hello Server failed: " + e);
        }
    }
}
