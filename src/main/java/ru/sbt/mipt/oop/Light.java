package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;

public class Light implements HomeComponent{
    private boolean isOn;
    private final String id;
    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    public static boolean isOnByIndex(SmartHome smartHome, String id) {
        for (Room room : smartHome.getRooms()) {
            for (Light light: room.getLights()) {
                if (light.getId().equals(id)) {
                    return light.isOn();
                }
            }
        }
        return false;
    }
}
