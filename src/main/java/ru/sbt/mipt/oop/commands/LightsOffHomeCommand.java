package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.TurnOffLight;

public class LightsOffHomeCommand implements Command {
	private SmartHome smartHome;

	public LightsOffHomeCommand(SmartHome smartHome) {
		this.smartHome = smartHome;
	}

	@Override
	public boolean execute() {
		smartHome.executeAction(new TurnOffLight());
		return true;
	}

	@Override
	public CommandType getType() {
		return CommandType.LIGHTS_OFF_HOME;
	}
}