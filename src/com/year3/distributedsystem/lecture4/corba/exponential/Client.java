package com.year3.distributedsystem.lecture4.corba.exponential;

import Exponential.Expo;
import Exponential.ExpoHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Expo exponentialServer = ExpoHelper.narrow(ncRef.resolve_str(ExpoImpl.ExpoServerName));

            System.out.println("Enter a and b to calculate a to the power of b:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("a = ");
            int a = scanner.nextInt();
            System.out.print("b = ");
            int b = scanner.nextInt();
            System.out.println("\ta ^ b = " + exponentialServer.calculate(a, b));

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
