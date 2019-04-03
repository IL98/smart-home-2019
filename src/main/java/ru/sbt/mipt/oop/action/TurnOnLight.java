package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;

public class TurnOnLight implements Action {
	@Override
	public void execute(Object object) {
		if (object instanceof Light) {
			Light light = (Light) object;
			light.setOn(true);
		}
	}
}
