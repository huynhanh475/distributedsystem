package com.year3.distributedsystem.lecture4.corba.count;

import org.omg.CORBA.ORB;
import Counter.*;

public class CountImpl extends CountPOA
{
    private int sum;
    // Constructor
    CountImpl ()
    {
        sum = 0;
    }

    @Override
    public int sum() {
        return sum;
    }

    @Override
    public void sum(int arg) {

    }

    @Override
    public int increment() {
        return ++sum;
    }

}