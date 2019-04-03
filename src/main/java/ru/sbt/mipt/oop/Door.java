package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;
import ru.sbt.mipt.oop.action.DoorByIdAction;


public class Door implements HomeComponent{
    private final String id;
    private Room room;

    private boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    public static Door getDoorById(SmartHome smartHome, String id) {

        DoorByIdAction doorByIdAction = new DoorByIdAction(id);

        smartHome.executeAction(doorByIdAction);

        return doorByIdAction.getDoor();
    }
}
