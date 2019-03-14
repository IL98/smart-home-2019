package ru.sbt.mipt.oop;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.*;

public class EventLightHandlerTest {
	private EventLightHandler eventLightHandler;

	@Before
	public void initTest() {
		eventLightHandler = new EventLightHandler();
	}

	@Test
	public void getTest1() throws Exception{
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome
		);
		String id = "4";
		SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, id);

		eventCenterHandler.handleEvent(event);
		assertTrue(Light.isOnByIndex(smartHome, id));

	}

	@Test
	public void getTest2() throws Exception{
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome
		);
		String id = "7";
		SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, id);

		eventCenterHandler.handleEvent(event);
		assertFalse(Light.isOnByIndex(smartHome, id));

	}

}