package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SensorEvent;

public class TurnOffLightById implements Action {
	private SensorEvent event;

	public TurnOffLightById(SensorEvent event) {
		this.event = event;
	}


	@Override
	public void execute(Object object) {
		if (object instanceof Light) {
			Light light = (Light) object;
			if (light.getId().equals(event.getObjectId())) {
				light.setOn(false);
				System.out.println("Light " + light.getId()+" in room " + light.getRoom().getName()+" was turned off.");
			}
		}
	}
}
