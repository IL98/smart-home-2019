package ru.sbt.mipt.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.alarmStates.*;

public class AlarmTest {
	private Alarm alarm = null;
	public Integer activationCode;

	@Before
	public void initTest() {
		activationCode = 54321;
		alarm = new Alarm(activationCode);
	}

	@Test
	public void activatedStateTest1() {
		assertEquals(alarm.getActivationCode(), activationCode);

		assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));

		alarm.activateAlarm(54321);
		assertTrue(alarm.getState().getClass().equals(AlarmActivatedState.class));

		alarm.invokeAlert();
		assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));

	}

	@Test
	public void activatedStateTest2() {
		alarm.activateAlarm(5555);

		assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));
	}

	@Test
	public void deactivatedStateTest() {
		alarm.activateAlarm(54321);
		alarm.deactivateAlarm(54321);

		assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));

		alarm.invokeAlert();
		assertTrue(alarm.getState().getClass().equals(AlarmDeactivatedState.class));
	}


	@Test
	public void alertStateTest() {
		alarm.activateAlarm(54321);
		alarm.deactivateAlarm(4444);

		assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));

		// Тестируем когда alarm в состоянии alert:
		alarm.invokeAlert();
		assertTrue(alarm.getState().getClass().equals(AlarmAlertState.class));
	}
}