package ru.sbt.mipt.oop.alarmStates;

import ru.sbt.mipt.oop.Alarm;

public class AlarmDeactivatedState extends AlarmState {

	public AlarmDeactivatedState(Alarm myAlarm) {
		this.myAlarm = myAlarm;
	}

	@Override
	public void activateAlarm(Integer activationCode) {
		if (activationCode.equals(myAlarm.getActivationCode())) {
			myAlarm.setState(new AlarmActivatedState(myAlarm));
		} else {
			myAlarm.setState(new AlarmAlertState(myAlarm));
		}
	}

	@Override
	public void deactivateAlarm(Integer activationCode) {
		return;
	}

	@Override
	public void invokeAlert() {
		return;
	}

}

