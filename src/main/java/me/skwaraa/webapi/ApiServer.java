package me.skwaraa.webapi;

import me.skwaraa.Main;
import me.skwaraa.sql.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ApiServer implements Runnable {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            Config config = new Config();
            serverSocket = new ServerSocket(config.getPort());
            do {
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                String data = in.readLine();
                String method = data.split(" ")[0];
                String path = data.split(" ")[1];
                if (method.equalsIgnoreCase("GET") && path.equals("/")) {
                    String response = "PigeonChat is running!";
                    int length = response.length();
                    out.println(String.format("HTTP/1.1 200 OK\r\nContent-Type: application/json\r\nContent-Length: %d\r\n\r\n%s", length, response));
                }
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
