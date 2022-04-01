package com.year3.distributedsystem.lecture2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socketClient = new Socket("localhost", 1286);

        // Init InputStream
        InputStream clientInputStream = socketClient.getInputStream();
        DataInputStream clientDIS = new DataInputStream(clientInputStream);
        // Init OutputStream
        OutputStream clientOutputStream = socketClient.getOutputStream();
        DataOutputStream clientDOS = new DataOutputStream(clientOutputStream);

        // Init Scanner and message String
        Scanner scanner = new Scanner(System.in);
        String message = "";

        while (!message.equals("quit")) {
            System.out.println("Send a message to Server (Enter 'quit' to stop): ");
            message = scanner.nextLine();
            clientDOS.writeUTF(message);

            System.out.println("Server says: " + clientDIS.readUTF());

        }

        System.out.println("\nClient quit conversation!");

        //Close Streams
        clientDOS.close();
        clientOutputStream.close();

        clientDIS.close();
        clientInputStream.close();

        //Close Socket
        socketClient.close();
    }
}
