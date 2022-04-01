package com.year3.distributedsystem.lecture4.fibonacci;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Fibonacci extends UnicastRemoteObject implements FibonacciInterface {

    public Fibonacci() throws RemoteException {}

    public int calculate(int n) throws RemoteException {
        System.out.println("Calculating Fibonacci number " + n);
        if (n <= 1)
            return n;
        return calculate(n-1) + calculate(n-2);
    }
}
