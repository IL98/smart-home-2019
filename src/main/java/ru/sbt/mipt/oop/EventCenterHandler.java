package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import java.io.IOException;

public class EventCenterHandler {

	private static SmartHome smartHome;

	public EventCenterHandler( SmartHomeLoader smartHomeLoader) throws IOException { //

		this.smartHome = smartHomeLoader.loadSmartHome();
	}

	static void handleEvents(EventGenerator  eventGenerator ) {
		// начинаем цикл обработки событий

		SensorEvent event = eventGenerator.getNextSensorEvent();
		while (event != null) {
			handleEvent(event);
			event = eventGenerator.getNextSensorEvent();
		}
	}

	static void handleEvent(SensorEvent event) {
		System.out.println("Got event: " + event);
		if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
			doEvent(new EventLightHandler(), event);
		}
		if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
			doEvent(new EventDoorHandler(), event);
		}
	}

	static void doEvent(EventHandler eventHandler, SensorEvent event) {
		eventHandler.doAction(smartHome, event);
	}

}
