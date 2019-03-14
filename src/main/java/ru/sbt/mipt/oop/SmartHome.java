package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;

public class SmartHome implements HomeComponent{
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void turnOffAllLight() {
        for (Room homeRoom : rooms) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
            }
        }
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }
}
