package com.year3.distributedsystem.lecture4.corba.count;

import Counter.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class CountServer {
    static public void main(String[] args) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            // get reference to rootpoa & activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // create servant
            CountImpl server = new CountImpl();

            // get object reference from the servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(server);
            Count href = CountHelper.narrow(ref);

            org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name( "ECHO-SERVER" );
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting ...");

            // wait for invocations from clients
            orb.run();
        } catch (Exception e){
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }
}
