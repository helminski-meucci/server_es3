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
        System.out.println("Server is online. Awaiting connection");

        ServerSocket s = new ServerSocket(3000);
        Socket sock = s.accept();

        System.out.println("Connection set. Awaiting next operation");

        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);

        List<Double> nums = List.of();
        List<String> operators = List.of();
        do{
            String info = in.readLine();
            if(info.trim().equals("exit")) break;
            else{
                nums.add(Double.valueOf(Double.parseDouble(info)));
                do{
                    String o = in.readLine();
                    o = o.trim();
                    if(o.trim().equals("=")) break;
                    operators.add(o);

                    String n = in.readLine();
                    n = n.trim();
                    nums.add(Double.valueOf(Double.parseDouble(n)));
                }while(true);
                while(nums.size() > 1){
                    int pos = findNextOperationPos(operators);
                    double result = performOperation(nums.get(pos).doubleValue(), nums.get(pos+1).doubleValue(), operators.get(pos));
                    nums.set(pos, Double.valueOf(result));
                    nums.remove(pos+1);
                    operators.remove(pos);
                }
                out.println(nums.getFirst());
            }
        }while(true);

    }

    private static int findNextOperationPos(List<String> ops){
        for(String s : ops){
            if(s.equals("C3") || s.equals("D4")) return ops.indexOf(s);
        }
        return 0;
    }

    private static double performOperation(double n1, double n2, String op){
        switch(op){
            case "A1":
                 return n1 + n2;
            case "B2":
                 return n1 - n2;
            case "C3":
                 return n1 * n2;
            case "D4":
                if(n2==0) throw new ArithmeticException("Division by zero is not allowed.");
                return n1 / n2;
            default:
                throw new NullPointerException("Invalid operation: " + op);
        }
    }
}