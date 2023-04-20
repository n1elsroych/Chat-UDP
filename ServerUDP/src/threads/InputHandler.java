package threads;

import events.ServerEventsListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class InputHandler extends Thread{
    DatagramSocket serverSocket;
    private ArrayList<ServerEventsListener> listeners;
    
    public InputHandler(DatagramSocket serverSocket){
        this.serverSocket = serverSocket;
        listeners = new ArrayList<>();
    }
    
    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        boolean isConnected = true;
        try{
            while (isConnected) {            
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(request);
                String message = new String(request.getData());
                
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addEventsListener(ServerEventsListener listener){
        listeners.add(listener);
    }
    
    public void removeMiEventoListener(ServerEventsListener listener) {
        listeners.remove(listener);
    }
    
    public void triggerMessageReceivedEvent(String message) {
        MessageReceivedEvent evt = new MessageReceivedEvent(this, message);
        for (ServerEventsListener listener : listeners) {
            listener.onReceivedMessage(evt);
        }
    }
}
