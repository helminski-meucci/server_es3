package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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
            BufferedReader in;
            try {
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                out.println("Nuova connessione stabilita");
                String n = in.readLine();
                nums.add(Integer.parseInt(n));
    
                String o = in.readLine();
                nums.add(Integer.parseInt(o));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}
