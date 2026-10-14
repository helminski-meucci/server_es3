package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Server");

        ServerSocket s = new ServerSocket(3000);
        Socket sock = s.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

        out.println("Connessione stabilita");

        List<Integer> nums = List.of();
        List<String> operators = List.of();
        do{
            do{
                String n = in.readLine();
                nums.add(Integer.parseInt(n));

                String o = in.readLine();
                operators.add(o);
            }while(true);

        }while(true);

    }

    private static double performOperation(int n1, int n2, String op){
        switch(op){
            case "A1":
                 return n1 + n2;
            case "B2":
                 return n1 - n2;
            case "C3":
                 return n1 * n2;
            case "D4":
                return n1 / n2;
            default:
                return 0;
        }
    }
}