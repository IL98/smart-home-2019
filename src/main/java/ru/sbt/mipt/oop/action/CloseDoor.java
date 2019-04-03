package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class CloseDoor implements Action{
	@Override
	public void execute(Object object) {
		if (object instanceof Door) {
			Door door = (Door) object;
			door.setOpen(false);
		}
	}
}
