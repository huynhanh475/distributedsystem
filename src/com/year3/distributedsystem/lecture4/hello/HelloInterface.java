package com.year3.distributedsystem.lecture4.hello;

import java.rmi.*;

public interface HelloInterface extends Remote {
    public String say() throws RemoteException;
}