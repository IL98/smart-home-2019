package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.TurnOnLight;

public class LightsOnHallCommand implements Command {
	private SmartHome smartHome;

	public LightsOnHallCommand(SmartHome smartHome) {
		this.smartHome = smartHome;
	}

	@Override
	public boolean execute() {
		smartHome.executeAction(object -> {
			if (object instanceof Room) {
				Room room = (Room) object;
				if (room.getName().equals("hall")) {
					room.executeAction(new TurnOnLight());
				}
			}
		});
		return false;
	}

	@Override
	public CommandType getType() {
		return CommandType.LIGHTS_ON_HALL;
	}
}

