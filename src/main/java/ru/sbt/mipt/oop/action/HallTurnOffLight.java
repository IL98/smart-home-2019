package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;

public class HallTurnOffLight implements Action{

	private SensorEvent event;
	private boolean isHall = false;

	public HallTurnOffLight(SensorEvent event) {
		this.event = event;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Door) {
			Door door = (Door) object;
			if (door.getId().equals(event.getObjectId())) {
				if (door.getRoomName().equals("hall")) {
					isHall = true;
				}
			}
		}
		if (object instanceof Light) {
			if (!isHall) {
				return;
			}
			Light light = (Light) object;
			light.setOn(false);
			System.out.println("Light " + light.getId()+" in room " + light.getRoomName()+" was turned off.");
		}
	}
}
