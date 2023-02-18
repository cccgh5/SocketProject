package kr.h.global;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {

    private Socket socket;
    private Scanner scanner;

    public SendThread(Socket socket) {
        this.socket = socket;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        try (DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {
            while(true) {
                String line = scanner.nextLine();
                if(line.equals("exit")) break;
                writer.writeUTF(line);
                writer.flush();
            }
        } catch (IOException ignored) {
        }
    }

}
