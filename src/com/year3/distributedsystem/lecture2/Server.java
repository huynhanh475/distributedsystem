package com.year3.distributedsystem.lecture2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(1286);

        System.out.println("Server is listening to port 1286 ...\n");

        // Wait for client request and accept
        Socket acceptedSocketServer = socketServer.accept();

        // Init InputStream
        InputStream serverInputStream = acceptedSocketServer.getInputStream();
        DataInputStream serverDIS = new DataInputStream(serverInputStream);
        // Init OutputStream
        OutputStream serverOutputStream = acceptedSocketServer.getOutputStream();
        DataOutputStream serverDOS = new DataOutputStream(serverOutputStream);

        // Init empty message String
        String messageReceived = "";

        while (!messageReceived.equals("quit")) {

            messageReceived = new String(serverDIS.readUTF());
            System.out.println("Client says: " + messageReceived);

            String messageSent = messageReceived.toUpperCase();
            if (messageReceived.equals("quit")) {
                messageSent = "Bye bye!!";
            }
            serverDOS.writeUTF(messageSent);
            System.out.println("Server sends back: " + messageSent);

        }

        System.out.println("\nClient quit conversation. Server shut down!!");

        //Close Streams
        serverDOS.close();
        serverOutputStream.close();

        serverDIS.close();
        serverInputStream.close();

        //Close Socket
        acceptedSocketServer.close();
        socketServer.close();

    }
}
