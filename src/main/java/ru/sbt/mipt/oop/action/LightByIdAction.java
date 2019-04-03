package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Light;

public class LightByIdAction implements Action{

	private String id;
	private Light light = null;

	public LightByIdAction(String id) {
		this.id = id;
	}

	public Light getLight() {
		return light;
	}

	@Override
	public void execute(Object object) {
		if (object instanceof Light) {
			Light light = (Light) object;
			if (light.getId().equals(id)) {
				this.light = light;
			}
		}
	}
}
