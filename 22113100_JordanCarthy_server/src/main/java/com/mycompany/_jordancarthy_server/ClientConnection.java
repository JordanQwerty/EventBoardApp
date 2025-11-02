/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._jordancarthy_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author jordancarthy
 */
public class ClientConnection implements Runnable{

    Socket client_link = null;
    String clientID;

    public ClientConnection(Socket connection, String cID) {
        this.client_link = connection;
        clientID = cID;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client_link.getInputStream())); 
            PrintWriter out = new PrintWriter(client_link.getOutputStream(), true); 

            String message = in.readLine();         
            System.out.println("Message received from client: " + clientID + "  " + message);
            out.println("Echo Message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("\n* Closing connection with the client " + clientID + " ... *");
                client_link.close();				    //Step 5.
            } catch (IOException e) {
                System.out.println("Unable to disconnect!");
            }
        }
    }
}
