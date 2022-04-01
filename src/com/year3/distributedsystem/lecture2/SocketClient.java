package com.year3.distributedsystem.lecture2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1286);

        InputStream sIn = s.getInputStream();

        DataInputStream socketDIS = new DataInputStream(sIn);

        String testString = new String(socketDIS.readUTF());
        System.out.println(testString);

        sIn.close();
        s.close();
    }
}
