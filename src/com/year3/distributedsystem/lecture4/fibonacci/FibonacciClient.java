package com.year3.distributedsystem.lecture4.fibonacci;

import java.rmi.Naming;
import java.util.Scanner;

public class FibonacciClient {

    public static void main (String[] args) {
        FibonacciInterface fibonacci;
        String name = "rmi://localhost:1024/FibServer";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        try {
            fibonacci = (FibonacciInterface) Naming.lookup(name);
            System.out.println("Fibonacci(" + n + ") = " + fibonacci.calculate(n));
        }
        catch (Exception e) {
            System.out.println("FibClient exception: " + e);
        }
    }
}
