package com.year3.distributedsystem.lecture4.fibonacci;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FibonacciInterface extends Remote {
    public int calculate(int n) throws RemoteException;
}