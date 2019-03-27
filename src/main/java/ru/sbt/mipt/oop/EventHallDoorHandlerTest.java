package ru.sbt.mipt.oop;

import static org.junit.Assert.*;

import org.junit.*;

public class EventHallDoorHandlerTest {
	private EventHallDoorHandler eventHallDoorHandler;

	@Before
	public void initTest() {
		eventHallDoorHandler = new EventHallDoorHandler();
	}

	@Test
	public void getTest1() throws Exception{
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome, new RandomEventGenerator()
		);
		String id = "4";
			SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED	, id);

		eventCenterHandler.handleEvent(event);
		assertFalse(Door.getDoorById(smartHome, id).isOpen());

		for (Room room: smartHome.getRooms()) {
			for (Light light : room.getLights()) {
				assertFalse(Light.getLightById(smartHome, id).isOn());
			}
		}
	}

	@Test
	public void getTest2() throws Exception {
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();

		EventCenterHandler eventCenterHandler = new EventCenterHandler(
				smartHome, new RandomEventGenerator()
		);
		String id = "4";

		SensorEvent eventLight = new SensorEvent(SensorEventType.LIGHT_ON, id);
		eventCenterHandler.handleEvent(eventLight);

		SensorEvent eventDoor = new SensorEvent(SensorEventType.DOOR_OPEN, id);
		eventCenterHandler.handleEvent(eventDoor);

		for (Room room: smartHome.getRooms()) {
			for (Door door : room.getDoors()) {
				if (door.getId().equals(eventDoor.getObjectId())) {
					assertTrue(room.isHall());
				}
			}
		}

		assertTrue(Light.getLightById(smartHome, id).isOn());
	}
}