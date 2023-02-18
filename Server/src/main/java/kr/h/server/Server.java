package kr.h.server;

import kr.h.global.ReceiveThread;
import kr.h.global.SendThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(25566);
        while(true) {
            Socket sock = socket.accept();
            System.out.println(sock.getInetAddress()+" connected!");
            ReceiveThread r = new ReceiveThread(sock);
            SendThread s = new SendThread(sock);
            r.start();
            s.start();
        }
    }

}
