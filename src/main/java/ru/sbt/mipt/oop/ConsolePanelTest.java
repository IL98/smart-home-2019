package ru.sbt.mipt.oop;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.commands.CommandType.*;

import java.io.IOException;
import org.junit.*;
import rc.RemoteControl;

public class ConsolePanelTest {

	private SmartHome smartHome;

	@Before
	public void initTest() throws IOException {
		JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
		this.smartHome = jsonSmartHomeLoader.loadSmartHome();
	}

	@Test
	public void getTest1() {
		ConsolePanel consolePanel = new ConsolePanel("1", smartHome);
		consolePanel.bindCommandToButton("1", LIGHTS_ON_HOME);
		consolePanel.onButtonPressed("1", consolePanel.getID());

		for (Room room: smartHome.getRooms()) {
			for (Light light : room.getLights()) {
				assertTrue(light.isOn());
			}
		}
	}

	@Test
	public void getTest2() {
		ConsolePanel consolePanel = new ConsolePanel("1", smartHome);
		consolePanel.bindCommandToButton("1", CLOSE_HALL_DOOR);
		consolePanel.onButtonPressed("1", consolePanel.getID());


		assertFalse(Door.getDoorById(smartHome, "4").isOpen());

		for (Room room: smartHome.getRooms()) {
			for (Light light : room.getLights()) {
				assertFalse(light.isOn());
			}
		}
	}

}