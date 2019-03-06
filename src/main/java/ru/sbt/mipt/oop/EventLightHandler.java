package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventLightHandler implements EventHandler{


	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {
		// событие от источника света
		for (Room room : smartHome.getRooms()) {
			for (Light light : room.getLights()) {
				if (light.getId().equals(event.getObjectId())) {
					if (event.getType() == LIGHT_ON) {
						light.setOn(true);
						System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
					} else {
						light.setOn(false);
						System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
					}
				}
			}
		}
	}

	public static void turnOffAllLight(SmartHome smartHome) {
		for (Room homeRoom : smartHome.getRooms()) {
			for (Light light : homeRoom.getLights()) {
				light.setOn(false);
				SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
				command.sendCommand();
			}
		}
	}
}
