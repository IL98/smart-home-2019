package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.TurnOnLight;

public class LightsOnHomeCommand implements Command {
	private SmartHome smartHome;

	public LightsOnHomeCommand(SmartHome smartHome) {
		this.smartHome = smartHome;
	}

	@Override
	public boolean execute() {
		smartHome.executeAction(new TurnOnLight());
		return true;
	}

	@Override
	public CommandType getType() {
		return CommandType.LIGHTS_ON_HOME;
	}
}
