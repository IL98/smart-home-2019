package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;

import java.util.Collection;

public class Room implements HomeComponent{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public boolean isHall() {
        return getName().equals("hall");
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);

        for (Door door : doors) {
            door.setRoomName(name);
            door.executeAction(action);
        }

        for (Light light : lights) {
            light.setRoomName(name);
            light.executeAction(action);
        }

    }
}
