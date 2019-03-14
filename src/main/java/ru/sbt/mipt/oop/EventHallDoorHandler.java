package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import ru.sbt.mipt.oop.action.HallTurnOffLight;

public class EventHallDoorHandler implements EventHandler{

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {

		if (event.getType() != DOOR_CLOSED) {
			return;
		}
		smartHome.executeAction(new HallTurnOffLight(event));
	}


}
