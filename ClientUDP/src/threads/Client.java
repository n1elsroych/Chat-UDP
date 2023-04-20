package threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    DatagramSocket socket;
    InetAddress serverAddress;
    int serverPort;
    byte[] buffer = new byte[1024];        
    
    public Client(String address, int serverPort) throws SocketException, UnknownHostException{
        socket = new DatagramSocket();
        serverAddress = InetAddress.getByName(address);
        this.serverPort = serverPort;
    }
    
    public void connect(){
        InputHandler inputHandler = new InputHandler(socket);
        inputHandler.start();
        
        Scanner scanner = new Scanner(System.in);
        byte[] buffer = new byte[1024];
        boolean isConnected = true;
        try {
            while (isConnected){
                String message = scanner.nextLine();
                buffer = message.getBytes();
                DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
                socket.send(request);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
            socket.close();
        }
        System.out.println("El bucle se termino en Client");
    }
}
