package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class DoorByIdAction implements Action{
	private String id;
	private Door door = null;

	public DoorByIdAction(String id) {
		this.id = id;
	}

	public Door getDoor() {
		return door;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Door) {
			Door door = (Door) object;
			if (door.getId().equals(id)) {
				this.door = door;
			}
		}
	}
}
