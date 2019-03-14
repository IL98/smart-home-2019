package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import ru.sbt.mipt.oop.action.TurnOffLightById;
import ru.sbt.mipt.oop.action.TurnOnLightById;

public class EventLightHandler implements EventHandler{


	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {

		if (event.getType() == LIGHT_ON) {
			smartHome.executeAction(new TurnOnLightById(event));
		}

		if (event.getType() == LIGHT_OFF) {
			smartHome.executeAction(new TurnOffLightById(event));
		}
	}


}
