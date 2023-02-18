package kr.h.global;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveThread extends Thread {
    private Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream())) {
            while(!socket.isClosed()) {
                System.out.println(input.readUTF());
            }
        } catch (IOException ignored) {
            System.out.println(socket.getInetAddress() + "is disconnect");
        }
    }

}
