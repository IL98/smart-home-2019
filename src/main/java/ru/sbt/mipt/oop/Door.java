package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;


public class Door implements HomeComponent{
    private final String id;
    private String roomName;
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String room_name) {
        this.roomName = room_name;
    }

    public static boolean isOpenByIndex(SmartHome smartHome, String id) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id)) {
                    return door.isOpen();
                }
            }
        }
        return false;
    }
}
