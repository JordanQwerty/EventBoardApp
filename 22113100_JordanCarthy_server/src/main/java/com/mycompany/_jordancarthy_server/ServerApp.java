/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._jordancarthy_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *  @author jordancarthy
 *  02/11/2025
 *  ServerApp.java
 */
public class ServerApp {
    private static final int PORT = 8080;
    private static ServerSocket servSock;
    private static int clientConnections = 0;
    
    public static void main(String[] args) {
        System.out.println("Opening port ...");
        try{
            servSock = new ServerSocket(PORT);
        }catch(IOException e){
            System.out.println("ServerSocket error : " + e);
            System.exit(1);
        }
        do{
            run();
        }while(true);
    }
    private static void run(){
         Socket link = null;                        
    try 
    {
        link = servSock.accept(); 
        clientConnections++;
        String client_ID = "Client "+ clientConnections;
        Runnable resource = new ClientConnection(link, client_ID);
        Thread t = new Thread (resource);
        t.start();
    }
    catch(IOException e1)
    {
        e1.printStackTrace();
        try {
	    System.out.println("\n* Closing connection... *");
            link.close();				    
	}
       catch(IOException e2)
       {
            System.out.println("Unable to disconnect!");
	    System.exit(1);
       }
    }
  } 
    
}
