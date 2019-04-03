package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;

public class HallTurnOffLight implements Action{


	@Override
	public void execute(Object object) {
		if (object instanceof Light) {
			Light light = (Light) object;
			light.setOn(false);
			System.out.println("Light " + light.getId()+" in room " + light.getRoom().getName()+" was turned off.");
		}
	}
}
