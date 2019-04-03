package ru.sbt.mipt.oop.adapters;

import static ru.sbt.mipt.oop.SensorEventType.*;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.EventCenterHandler;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;


public class EventHandlerAdapter implements	 com.coolcompany.smarthome.events.EventHandler {
	SmartHome smartHome;
	ru.sbt.mipt.oop.EventHandler eventHandler;

	public EventHandlerAdapter(SmartHome smartHome, ru.sbt.mipt.oop.EventHandler eventHandler) {
		this.smartHome = smartHome;
		this.eventHandler = eventHandler;
	}

	@Override
	public void handleEvent(CCSensorEvent event) {
		SensorEvent sensorEvent = sensorEventFromCCSensorEvent(event);
		if (sensorEvent == null) {
			System.out.println("Cannot convert current API event to native type of event");
		} else {
			System.out.println("Got event: " + sensorEvent);
			eventHandler.doAction(this.smartHome, sensorEvent);
		}
	}

	private SensorEvent sensorEventFromCCSensorEvent(CCSensorEvent event) {
		if (event.getEventType().equals("DoorIsOpen")) {
			return new SensorEvent(DOOR_OPEN, event.getObjectId());
		}
		if (event.getEventType().equals("DoorIsClosed")) {
			return new SensorEvent(DOOR_CLOSED, event.getObjectId());
		}
		if (event.getEventType().equals("LightIsOn")) {
			return new SensorEvent(LIGHT_ON, event.getObjectId());
		}
		if (event.getEventType().equals("LightIsOff")) {
			return new SensorEvent(LIGHT_OFF, event.getObjectId());
		}
		return null;
	}
}
