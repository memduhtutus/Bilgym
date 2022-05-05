package com.memduhtutus.tryingbilgym;

public interface HandleEvent {
    void createNewEvent(User u, Event e);
    boolean joinEvent(User u, Event e);
    boolean cancelEventAppt(User u, Event e);

}


