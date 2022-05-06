package com.memduhtutus.tryingbilgym;

import com.google.firebase.auth.FirebaseUser;

public interface HandleEvent {
    void createNewEvent(FirebaseUser u, Event e);
    boolean joinEvent(User u, Event e);
    boolean cancelEventAppt(User u, Event e);

}


