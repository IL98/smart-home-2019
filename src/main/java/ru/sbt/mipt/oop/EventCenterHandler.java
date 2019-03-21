package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class EventCenterHandler {

	private SmartHome smartHome;
	private Collection<EventHandler> eventHandlers;

	public EventCenterHandler( SmartHome smartHome) throws IOException { //

		this.smartHome = smartHome;

		eventHandlers = new ArrayList<>();

		eventHandlers.add(new DecaratedAlarmEventHandler(new AlarmEventHandler()));
		eventHandlers.add(new EventLightHandler());
		eventHandlers.add(new EventDoorHandler());
		eventHandlers.add(new EventHallDoorHandler());
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

		for (EventHandler eventHandler : eventHandlers) {
			doEvent(eventHandler, event);
		}

	}

	void doEvent(EventHandler eventHandler, SensorEvent event) {
		eventHandler.doAction(smartHome, event);
	}

}
