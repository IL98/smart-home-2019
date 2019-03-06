package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventDoorHandler implements EventHandler{

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {

		for (Room room : smartHome.getRooms()) {
			for (Door door : room.getDoors()) {
				if (door.getId().equals(event.getObjectId())) {
					if (event.getType() == DOOR_OPEN) {
						door.setOpen(true);
						System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
					} else {
						door.setOpen(false);
						System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
						handleHallDoor(smartHome, room);
					}
				}
			}
		}
	}

	void handleHallDoor(SmartHome smartHome, Room room) {
		if (room.isHall()) {
			EventLightHandler.turnOffAllLight(smartHome);
		}
	}

}
