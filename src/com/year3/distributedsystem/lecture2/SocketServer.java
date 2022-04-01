package com.year3.distributedsystem.lecture2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1286);

        Socket s = ss.accept();

        OutputStream socketOutputStream = s.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutputStream);

        socketDOS.writeUTF("Hello World!");

        socketDOS.close();;
        socketOutputStream.close();
        s.close();

        ss.close();

    }
}
