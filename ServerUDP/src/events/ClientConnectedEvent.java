package events;

import java.util.EventObject;

public class ClientConnectedEvent extends EventObject{
    int id;
    
    public ClientConnectedEvent(Object source, int id){
        super(source);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
