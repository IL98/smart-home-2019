package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SensorEvent;

public class CheckIsHallAction implements Action{

	private SensorEvent event;

	private boolean isHall = false;


	public boolean isHall() {
		return isHall;
	}


	public CheckIsHallAction(SensorEvent event) {
		this.event = event;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Door) {
			Door door = (Door) object;
			if (door.getId().equals(event.getObjectId())) {
				if (door.getRoom().getName().equals("hall")) {
					isHall = true;
				}
			}
		}
	}
}
