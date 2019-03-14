package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEvent;

public class TurnOnLightById implements Action {

	private SensorEvent event;

	public TurnOnLightById(SensorEvent event) {
		this.event = event;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Light) {
			Light light = (Light) object;
			if (light.getId().equals(event.getObjectId())) {
				light.setOn(true);
				System.out.println("Light " + light.getId()+" in room " + light.getRoomName()+" was turned on.");
			}
		}
	}
}