package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class EventCenterHandler implements CenterEventManager {

	private SmartHome smartHome;
	private Collection<EventHandler> eventHandlers;
	private EventGenerator  eventGenerator;

	public EventCenterHandler( SmartHome smartHome,
								EventGenerator  eventGenerator) throws IOException { //

		this.smartHome = smartHome;
		this.eventGenerator = eventGenerator;

		eventHandlers = new ArrayList<>();
	}


	@Override
	public void handleEvents() {
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

		@Override
	public void registerEventHandler(EventHandler eventHandler) {
		eventHandlers.add(eventHandler);
	}


	void doEvent(EventHandler eventHandler, SensorEvent event) {
		eventHandler.doAction(smartHome, event);
	}

}
