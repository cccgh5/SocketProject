package kr.h.client;

import kr.h.global.ReceiveThread;
import kr.h.global.SendThread;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost", 25566);
        System.out.println("서버와 접속되었습니다.");
        ReceiveThread receiveThread = new ReceiveThread(sock);
        receiveThread.start();
        SendThread sendThead = new SendThread(sock);
        sendThead.start();
    }

}
