package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SensorEvent;

public class CloseDoorActionById implements Action {
	private SensorEvent event;

	public CloseDoorActionById(SensorEvent event) {
		this.event = event;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Door) {
			Door door = (Door) object;
			if (door.getId().equals(event.getObjectId())) {
				door.setOpen(false);
				System.out.println("Door "+ door.getId()+" in room " + door.getRoom().getName()+" was closed.");
			}
		}
	}
}