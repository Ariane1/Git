package socket_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4444);
        //Socket socket = new Socket("127.0.0.1", 4444);
        //to get the ip address
        System.out.println((java.net.InetAddress.getLocalHost()).toString());

        //true: it will flush the output buffer
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Thread.sleep(1000);
        outSocket.println("I'm here !");
        System.out.println("The server will choose a number between 0 and 5");
        if ("number chosen".equals(inSocket.readLine())) {
            System.out.println("The server has chosen his number");
            System.out.println("Can you guess the number ?");
            boolean test = false;
            do {
                Scanner sc = new Scanner(System.in);
                int clientTry = sc.nextInt();
                outSocket.println(clientTry);
                if ("wrong".equals(inSocket.readLine())) {
                    System.out.println("Wrong, please try again");
                    if ("higher".equals(inSocket.readLine())){
                        System.out.println("The number is higher");
                    }else{
                        System.out.println("The number is lower");
                    }
                } else {
                    System.out.println("Good job ! You've found the number");
                    test = true;
                }
            } while (!test);

        }
        System.out.println("End.");
        socket.close();
    }

}
