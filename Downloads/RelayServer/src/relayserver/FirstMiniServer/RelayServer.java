/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayserver.FirstMiniServer;
import relayserver.FirstMiniServer.Client;
import java.io.*;
import java.net.*;


/**
 *
 * @author Stephen JM Scott
 * Relay Server Management Application between Audio Device and Client PC.
 * 22/10/2018
 */
public class RelayServer {
    
    

    
    public static void main(String[] args) throws Exception{
       
        ServerSocket ss = new ServerSocket (Client.DefaultPort);
        Socket s = ss.accept();
        System.out.println("Connected");
        DataInputStream DataInput =  new DataInputStream(s.getInputStream());
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){  //Run indefintely 
            String foo = DataInput.readUTF();
            System.out.println("Client Message: " + foo);
                       if(foo.equalsIgnoreCase("exit"))
                           break;
            
        }
        s.close();
        
        
    }
    
}
