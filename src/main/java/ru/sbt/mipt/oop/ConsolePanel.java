package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.commands.CommandType.*;

import java.util.HashMap;
import java.util.Map;
import rc.RemoteControl;
import ru.sbt.mipt.oop.commands.*;

public class ConsolePanel implements RemoteControl {

	private String ID;
	private SmartHome smartHome = null;
	private Map<CommandType, Command> commands = null;
	private Map<String, Command> buttons = null;

	public ConsolePanel(String ID, SmartHome smartHome) {
		this.ID = ID;

		this.smartHome = smartHome;
		buttons = new HashMap<>();
		commands = new HashMap<>();

		commands.put(LIGHTS_ON_HALL, new LightsOnHallCommand(smartHome));
		commands.put(LIGHTS_OFF_HOME, new LightsOffHomeCommand(smartHome));
		commands.put(LIGHTS_ON_HOME, new LightsOnHomeCommand(smartHome));
		commands.put(ACTIVATE_ALERT_ALARM, new ActivateAlertAlarmCommand(smartHome));
		commands.put(ACTIVATE_ALARM, new ActivateAlarmCommand(smartHome, 1111));
		commands.put(CLOSE_HALL_DOOR, new CloseHallDoorCommand(smartHome));

	}

	public Map<CommandType, Command> getCommands() {
		return commands;
	}


	public Map<String, Command> getButtons() {
		return buttons;
	}


	public String getID() {
		return ID;
	}

	public SmartHome getSmartHome() {
		return smartHome;
	}

	@Override
	public void onButtonPressed(String buttonCode, String rcId) {
		if (!readyToWork()) {
			return;
		}
		if (buttons.get(buttonCode) == null) {
			System.out.println("This code is not configurated");
		}
		buttons.get(buttonCode).execute();
	}

	public void bindCommandToButton(String buttonID, CommandType commandType) {
		if (!readyToWork()) {
			return;
		}
		buttons.put(buttonID, commands.get(commandType));
	}


	private boolean readyToWork() {
		if (buttons != null && commands != null) {
			return true;
		}
		return false;
	}
}
