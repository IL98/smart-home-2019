package ru.sbt.mipt.oop.alarmStates;

import ru.sbt.mipt.oop.Alarm;

public class AlarmActivatedState extends AlarmState {

	public AlarmActivatedState(Alarm myAlarm) {
		this.myAlarm = myAlarm;
	}

	@Override
	public void activateAlarm(Integer activationCode) {
		return;
	}

	@Override
	public void deactivateAlarm(Integer activationCode) {
		if (activationCode.equals(myAlarm.getActivationCode())) {
			myAlarm.setState(new AlarmDeactivatedState(myAlarm));
		} else {
			myAlarm.setState(new AlarmAlertState(myAlarm));
		}
	}

	@Override
	public void invokeAlert() {
		myAlarm.setState(new AlarmAlertState(myAlarm));
		System.out.println("ALERT IS ON!");
	}
}