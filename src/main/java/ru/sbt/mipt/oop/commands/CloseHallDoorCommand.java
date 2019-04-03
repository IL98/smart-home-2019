package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.action.CloseDoor;
import ru.sbt.mipt.oop.action.CloseDoorActionById;
import ru.sbt.mipt.oop.action.HallTurnOffLight;

public class CloseHallDoorCommand implements Command {
	private SmartHome smartHome;

	public CloseHallDoorCommand(SmartHome smartHome) {
		this.smartHome = smartHome;
	}

	@Override
	public boolean execute() {

		smartHome.executeAction(object -> {
			if (object instanceof Room) {
				Room room = (Room) object;
				if (room.getName().equals("hall")) {
					room.executeAction(new CloseDoor());
				}
			}
		});
		smartHome.executeAction(new HallTurnOffLight());
		return true;
	}

	@Override
	public CommandType getType() {
		return CommandType.CLOSE_HALL_DOOR;
	}
}
