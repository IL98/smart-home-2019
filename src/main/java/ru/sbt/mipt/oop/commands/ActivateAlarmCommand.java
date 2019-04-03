package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.SmartHome;


public class ActivateAlarmCommand implements Command {
	private SmartHome smartHome;
	Integer activationCode;

	public ActivateAlarmCommand(SmartHome smartHome, Integer activationCode) {
		this.smartHome = smartHome;
		this.activationCode = activationCode;
	}

	@Override
	public boolean execute() {
		if (smartHome.getAlarm() == null) {
			return false;
		}
		smartHome.getAlarm().activateAlarm(activationCode);
		return true;
	}

	@Override
	public CommandType getType() {
		return CommandType.ACTIVATE_ALARM;
	}
}
