package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Server");

        ServerSocket s = new ServerSocket(3000);

        do{
            Socket tmp = s.accept();
            ClientManager clientNuovo = new ClientManager(tmp);
            clientNuovo.run();
        }while(true);

    }
}