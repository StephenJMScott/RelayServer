/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayserver.UDPMiniServer;
import java.io.*;
import java.net.*;

/**
 *
 * @author hello
 */
public class UDPServer {
    public static void main(String[] args){
            try{
                DatagramSocket serverSocket = new DatagramSocket(9876);
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];
                while(true)
                   {
                      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                      serverSocket.receive(receivePacket);
                      String sentence = new String( receivePacket.getData());
                      System.out.println("RECEIVED: " + sentence);
                      InetAddress IPAddress = receivePacket.getAddress();
                      int port = receivePacket.getPort();
                      String capitalizedSentence = sentence.toUpperCase();
                      sendData = capitalizedSentence.getBytes();
                      DatagramPacket sendPacket =
                      new DatagramPacket(sendData, sendData.length, IPAddress, port);
                      serverSocket.send(sendPacket);
                   }

                }catch (Exception e){
                    System.out.println("Not working");
                };
            
    }
}
