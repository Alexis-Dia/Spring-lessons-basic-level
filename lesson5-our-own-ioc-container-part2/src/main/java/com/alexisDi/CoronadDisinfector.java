package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class CoronadDisinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room) {
        announcer.announce("Started disenfection, everyone go out!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Take a risk to return back.");
    }

    private void desinfect(Room room) {
        System.out.println("Disinfection...");
    }

}
