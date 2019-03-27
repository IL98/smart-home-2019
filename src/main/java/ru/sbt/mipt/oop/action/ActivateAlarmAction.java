package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.SmartHome;

public class ActivateAlarmAction implements Action{

	Integer activationCode;


	public ActivateAlarmAction(Integer activationCode) {
		this.activationCode = activationCode;
	}


	@Override
	public void execute(Object object) {
		if (object instanceof Alarm) {
			Alarm alarm = (Alarm) object;
			alarm.activateAlarm(activationCode);
		}
	}
}
