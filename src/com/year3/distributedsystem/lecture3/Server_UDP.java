package com.year3.distributedsystem.lecture3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_UDP {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;
        if (args.length <= 0) {
            System.out.println("Pass the port number for UDP Server.");
            System.exit(1);
        }

        try {
            int socketNumber = Integer.parseInt(args[0]);
            dgSocket = new DatagramSocket(socketNumber);
            byte[] byteBuffer = new byte[100];
            while (true) {
                // Get Request from Client and save it into a prepared dgRequest variable
                DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgRequest);

                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
