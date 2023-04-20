package events;

import java.util.EventListener;

public interface ServerEventsListener extends EventListener{
    
    void onClientConnected(ClientConnectedEvent evt);
}
