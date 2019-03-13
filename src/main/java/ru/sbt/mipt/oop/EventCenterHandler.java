package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import java.io.IOException;

public class EventCenterHandler {

	private SmartHome smartHome;

	public EventCenterHandler( SmartHome smartHome) throws IOException { //

		this.smartHome = smartHome;
	}

	void handleEvents(EventGenerator  eventGenerator ) {
		// начинаем цикл обработки событий

		SensorEvent event = eventGenerator.getNextSensorEvent();
		while (event != null) {
			handleEvent(event);
			event = eventGenerator.getNextSensorEvent();
		}
	}

	void handleEvent(SensorEvent event) {
		System.out.println("Got event: " + event);

		doEvent(new EventLightHandler(), event);

		doEvent(new EventDoorHandler(), event);

		doEvent(new EventHallDoorHandler(), event);

	}

	void doEvent(EventHandler eventHandler, SensorEvent event) {
		eventHandler.doAction(smartHome, event);
	}

}
