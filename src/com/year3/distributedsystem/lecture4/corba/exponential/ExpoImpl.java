package com.year3.distributedsystem.lecture4.corba.exponential;

import Exponential.ExpoPOA;

public class ExpoImpl extends ExpoPOA {

    public static String ExpoServerName = "EXPO-SERVER";

    @Override
    public int calculate(int a, int b) {
        System.out.println("Calculating " + a + " to the power of " + b);
        return (int) Math.pow(a,b);
    }
}
