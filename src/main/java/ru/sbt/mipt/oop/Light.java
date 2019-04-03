package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;
import ru.sbt.mipt.oop.action.LightByIdAction;

public class Light implements HomeComponent{
    private boolean isOn;
    private final String id;
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public static Light getLightById(SmartHome smartHome, String id) {

        LightByIdAction lightByIdAction = new LightByIdAction(id);
        smartHome.executeAction(lightByIdAction);

        return lightByIdAction.getLight();
    }
}
