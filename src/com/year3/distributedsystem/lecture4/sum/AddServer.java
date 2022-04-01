package com.year3.distributedsystem.lecture4.sum;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AddServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1024);
            Naming.rebind("rmi://localhost:1024/AddServer",
                    new AddTwoNumber());
            System.out.println("Add Server is ready.");
        } catch (Exception e) {
            System.out.println("Add Server failed: " + e);
        }
    }
}
