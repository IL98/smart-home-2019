package ru.sbt.mipt.oop;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.*;


public class EventDoorHandlerTest {
	private EventDoorHandler eventDoorHandler;

	@Before
	public void initTest() {
		eventDoorHandler = new EventDoorHandler();
	}

	@Test
	public void getTest1() throws Exception{
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome
		);
		String id = "4";
		SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, id);

		eventCenterHandler.handleEvent(event);
		assertTrue(Door.isOpenByIndex(smartHome, id));

	}

	@Test
	public void getTest2() throws Exception{
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome
		);
		String id = "3";
		SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, id);

		eventCenterHandler.handleEvent(event);
		assertFalse(Door.isOpenByIndex(smartHome, id));

	}

}
