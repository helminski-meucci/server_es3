package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.List;

public class ClientManager extends Thread{
    Socket sock;
    public ClientManager(Socket s){
        this.sock = s;
    }

    public void run(){
        List<Integer> nums = List.of();
        List<String> operators = List.of();
        do{
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                out.println("Pronto per scrivere");
                String frase = in.readLine();
                out.println(frase.toUpperCase());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}
