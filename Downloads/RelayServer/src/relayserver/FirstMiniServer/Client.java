/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayserver.FirstMiniServer;
import java.io.*;
import java.net.*;

/**
 *
 * @author StephenJMScott
 */
public class Client {
    public static final String DefaultHost = "localhost"; //change this later;
    public static final int DefaultPort = 2002; // may need to include Port 2002 as well. 
    
    
    private static String host = DefaultHost;
    private static int port = DefaultPort;
    
    
    public static void main(String[] args) throws Exception{
        
        Socket S = new Socket(host, port);                                      
        DataOutputStream  DataOut = new DataOutputStream(S.getOutputStream());
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            while (true){  //this will run indefinetly 
                String sout = br.readLine();
                DataOut.writeUTF(sout);
                    if(sout.equalsIgnoreCase("exit"))
                        break;
                
            }
            S.close();
        
        
        
        
    }
        
        
}
