package com.year3.distributedsystem.lecture4.sum;

import java.rmi.Naming;
import java.util.Scanner;

public class AddClient {

    public static void main (String[] args) {
        AddTwoNumberInterface addTwoNumber;
        String name = "rmi://localhost:1024/AddServer";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();

        try {
            addTwoNumber = (AddTwoNumberInterface) Naming.lookup(name);
            System.out.println(a + " + " + b + " = " + addTwoNumber.add(a, b));
        }
        catch (Exception e) {
            System.out.println("AddClient exception: " + e);
        }
    }
}
