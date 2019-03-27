package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.SensorEventsManager;
import java.io.IOException;
import ru.sbt.mipt.oop.adapters.CCSensorEventAdapter;


public class Application {

    public static void main(String... args) throws IOException {
        JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
        SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(1111));

        EventCenterHandler eventCenterHandler = new EventCenterHandler(
                smartHome, new RandomEventGenerator()
        );

        SensorEventsManager sensorEventsManager = new SensorEventsManager();

        CCSensorEventAdapter ccSensorEvent = new CCSensorEventAdapter(sensorEventsManager);

        eventCenterHandler.registerEventHandler(new DecaratedAlarmEventHandler(new EventLightHandler()));
        eventCenterHandler.registerEventHandler(new DecaratedAlarmEventHandler(new EventDoorHandler()));
        eventCenterHandler.registerEventHandler(new DecaratedAlarmEventHandler(new EventHallDoorHandler()));
        eventCenterHandler.registerEventHandler(new AlarmEventHandler());

        eventCenterHandler.handleEvents();
    }

}
