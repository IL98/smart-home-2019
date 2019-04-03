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

//        EventCenterHandler eventCenterHandler = new EventCenterHandler(
//                smartHome, new RandomEventGenerator()
//        );

        SensorEventsManager sensorEventsManager = new SensorEventsManager();

        CCSensorEventAdapter ccSensorEvent = new CCSensorEventAdapter(
                sensorEventsManager, smartHome
        );

        ccSensorEvent.registerEventHandler(new DecaratedAlarmEventHandler(new EventLightHandler()));
        ccSensorEvent.registerEventHandler(new DecaratedAlarmEventHandler(new EventDoorHandler()));
        ccSensorEvent.registerEventHandler(new DecaratedAlarmEventHandler(new EventHallDoorHandler()));
        ccSensorEvent.registerEventHandler(new AlarmEventHandler());

        ccSensorEvent.handleEvents();
    }

}
