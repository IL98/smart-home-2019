package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import ru.sbt.mipt.oop.action.CloseDoorActionById;
import ru.sbt.mipt.oop.action.OpenDoorAction;

public class EventDoorHandler implements EventHandler{

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {

		if (event.getType() == DOOR_OPEN) {
			smartHome.executeAction(new OpenDoorAction(event));
		}

		if (event.getType() == DOOR_CLOSED) {
			smartHome.executeAction(new CloseDoorActionById(event));
		}
	}


}
