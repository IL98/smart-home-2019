package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.ACTIVATE_ALARM;
import static ru.sbt.mipt.oop.SensorEventType.DEACTIVATE_ALARM;


public class AlarmEventHandler implements EventHandler{

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {
		if (smartHome.getAlarm() == null) {
			return;
		}
		if (event.getType() == ACTIVATE_ALARM) {
			smartHome.getAlarm().activateAlarm(Integer.parseInt(event.getObjectId()));
		}
		if (event.getType() == DEACTIVATE_ALARM) {
			smartHome.getAlarm().deactivateAlarm(Integer.parseInt(event.getObjectId()));
		}
	}

}
