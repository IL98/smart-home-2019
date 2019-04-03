package ru.sbt.mipt.oop;

public class DecaratedAlarmEventHandler implements EventHandler {

	private EventHandler eventHandler;

	public DecaratedAlarmEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}

	@Override
	public void doAction(SmartHome smartHome, SensorEvent event) {
		if(smartHome.getAlarm() != null) {
			if (!(smartHome.getAlarm().isDeactivated())) {
				if (isDoorOrLightEvent(event)) {
					smartHome.getAlarm().invokeAlert();
				}
			}
		} else {
			eventHandler.doAction(smartHome, event);
		}
	}

	private boolean isDoorOrLightEvent(SensorEvent event) {
		return (event.getType() == SensorEventType.LIGHT_ON ||
				event.getType() == SensorEventType.LIGHT_OFF ||
				event.getType() == SensorEventType.DOOR_OPEN ||
				event.getType() == SensorEventType.DOOR_CLOSED);
	}


}
