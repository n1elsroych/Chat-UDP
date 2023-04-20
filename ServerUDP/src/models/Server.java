package models;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import threads.InputHandler;

public class Server {
    DatagramSocket serverSocket;
    Map<Integer, Client> clients;
    
    public Server(int port) throws SocketException{
        serverSocket = new DatagramSocket(port);
        clients = new HashMap<>();
    }
    
    public void start(){
        InputHandler inputHandler = new InputHandler(serverSocket);
        inputHandler.start();
    }
    
    private void sendBroadcast(){
        
    }
    
    
}
