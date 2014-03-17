package socket_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        new Server().begin(4444);
    }

    ServerSocket serverSocket;

    public void begin(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting for clients to connect on port " + port + "...");
            new ProtocolThread(serverSocket.accept()).start();
            //Thread.start() calls Thread.run()
        }
    }

    class ProtocolThread extends Thread {

        Socket socket;
        PrintWriter out_socket;
        BufferedReader in_socket;

        public ProtocolThread(Socket socket) {
            System.out.println("Accepting connection from " + socket.getInetAddress() + "...");
            this.socket = socket;
            try {
                out_socket = new PrintWriter(socket.getOutputStream(), true);
                in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                if ("I'm here !".equals(in_socket.readLine())) {
                    boolean test = false;
                    int randNumber = (int) (Math.random() * 5);
                    System.out.println("I've chosen number " + randNumber);
                    out_socket.println("number chosen");
                    do {
                        int answerClient = Integer.parseInt(in_socket.readLine());
                        if (answerClient != randNumber) {
                            out_socket.println("wrong");
                            if (answerClient < randNumber) {
                                out_socket.println("higher");
                            } else {
                                out_socket.println("lower");
                            }
                        } else {
                            out_socket.println("right");
                            test = true;
                        }
                    } while (!test);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    System.out.println("Closing connection.");
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
