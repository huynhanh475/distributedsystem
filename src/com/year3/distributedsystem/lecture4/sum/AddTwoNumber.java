package com.year3.distributedsystem.lecture4.sum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddTwoNumber extends UnicastRemoteObject implements AddTwoNumberInterface {

    public AddTwoNumber() throws RemoteException {}

    public int add(int a, int b) throws RemoteException {
        System.out.println("Calculating: " + a + " + " + b);
        return a + b;
    }
}
