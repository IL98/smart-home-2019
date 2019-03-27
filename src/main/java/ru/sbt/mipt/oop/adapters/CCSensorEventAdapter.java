package ru.sbt.mipt.oop.adapters;

import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.CenterEventManager;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class CCSensorEventAdapter implements CenterEventManager {
	private SensorEventsManager sensorEventsManager;
	private SmartHome smartHome;

	public CCSensorEventAdapter(SensorEventsManager sensorEventsManager) {
		this.sensorEventsManager = sensorEventsManager;
	}

	@Override
	public void handleEvents() {
		sensorEventsManager.start();
	}

	@Override
	public void registerEventHandler(ru.sbt.mipt.oop.EventHandler eventHandler) {
		com.coolcompany.smarthome.events.EventHandler eventHandlerAdapter = new EventHandlerAdapter(
				this.smartHome, eventHandler
		);
		sensorEventsManager.registerEventHandler(eventHandlerAdapter);
	}


}
