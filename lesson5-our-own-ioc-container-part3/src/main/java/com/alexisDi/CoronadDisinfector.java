package com.alexisDi;

/**
 * @author Alexey Druzik on 5/12/2020
 */
public class CoronadDisinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

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
