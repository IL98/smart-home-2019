package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.action.HomeComponent;
import ru.sbt.mipt.oop.alarmStates.*;


public class Alarm implements HomeComponent {
	private final Integer activationCode;
	private AlarmState state;

	public Alarm(Integer activationCode) {
		this.activationCode = activationCode;
		this.state = new AlarmDeactivatedState(this);
	}

	@Override
	public void executeAction(Action action) {
		action.execute(this);
	}


	public void activateAlarm(Integer activationCode) {
		state.activateAlarm(activationCode);
	}

	public void deactivateAlarm(Integer activationCode) {
		state.deactivateAlarm(activationCode);
	}

	public void invokeAlert(){
		state.invokeAlert();
	}

	public void setState(AlarmState state) {
		this.state = state;
	}

	public Integer getActivationCode() {
		return activationCode;
	}

	public AlarmState getState() {
		return this.state;
	}

	public boolean isDeactivated() {
		return state instanceof AlarmDeactivatedState;
	}
}
