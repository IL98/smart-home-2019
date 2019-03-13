package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventHallDoorHandler implements EventHandler{

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {
		boolean isHall = false;

		if (event.getType() != DOOR_CLOSED) {
			return;
		}

		for (Room room : smartHome.getRooms()) {
			for (Door door : room.getDoors()) {
				if (door.getId().equals(event.getObjectId())) {

					if (room.isHall()) {
						isHall = true;
						door.setOpen(false);
						smartHome.turnOffAllLight();
					}
				}
			}
		}

		if (!isHall) {
			return;
		}
		for (Room homeRoom : smartHome.getRooms()) {
			for (Light light : homeRoom.getLights()) {
				SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
				command.sendCommand();
			}
		}

	}


}
