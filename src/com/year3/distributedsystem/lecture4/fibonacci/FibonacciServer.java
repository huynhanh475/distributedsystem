package com.year3.distributedsystem.lecture4.fibonacci;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class FibonacciServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1024);
            Naming.rebind("rmi://localhost:1024/FibServer",
                    new Fibonacci());
            System.out.println("Fib Server is ready.");
        } catch (Exception e) {
            System.out.println("Fib Server failed: " + e);
        }
    }
}
