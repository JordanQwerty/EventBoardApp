/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany._jordancarthy_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.*;

/**
 *
 *  @author jordancarthy
 *  02/11/2025 
 *  ClientApp.java
 */
public class ClientApp {

    // 8080 server port
    private static final int PORT = 8080;
    private static InetAddress host;

    public static void main(String[] args) {

        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Host is unknown error : " + e);
        }
        run();
    }

    private static void run() {

        Socket link = null;
        try {
            link = new Socket(host, PORT);
            // Buffered reader for input from stream and printwriter for output
            BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);

            
            BufferedReader userEntry = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter message to be sent to server: ");
            String message = userEntry.readLine();

            sendMessage(out, message);
            receiveResponse(in);
        } catch (IOException e) {
            System.out.println("Socket connection error : " + e);
        }finally{
            try{
                if(link!=null) link.close();
            }catch(IOException e){
                System.out.println("Socket closing error : " + e);
            }
        }
    }

    // Helper method : send message to server
    private static void sendMessage(PrintWriter out, String message) {
        out.println(message);
    }

    // Helper method : receive and print server response
    private static void receiveResponse(BufferedReader in) throws IOException {
        String response = in.readLine();
        System.out.println("\nSERVER RESPONSE> " + response);
    }

    // Method for retrieving event from url 
    private static void getEventRaw() {
        URL eventsUrl;
        BufferedReader buffRead;
        String eventLine;
        /*https://stackoverflow.com/questions/6259339/how-to-read-a-text-file-directly-from-internet-using-java*/
        try {
            eventsUrl = new URL("https://raw.githubusercontent.com/JordanQwerty/EventBoardApp/refs/heads/main/events.txt");
            buffRead = new BufferedReader(new InputStreamReader(eventsUrl.openStream()));
            while ((eventLine = buffRead.readLine()) != null) {
                System.out.println(eventLine);
            }
            buffRead.close();
        } catch (IOException e) {
            System.out.println("IO error :" + e);
        }
    }

}
