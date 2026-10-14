package com.example;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Server");

        ServerSocket s = new ServerSocket(3000);

        do{
            ClientManager ClientNuovo = new ClientManager(s.accept());
        }while(true);

    }
}