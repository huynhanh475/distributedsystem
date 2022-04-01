package com.year3.distributedsystem.lecture4.sum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddTwoNumberInterface extends Remote {
    public int add(int a, int b) throws RemoteException;
}