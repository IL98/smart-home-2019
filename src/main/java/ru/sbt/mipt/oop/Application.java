package ru.sbt.mipt.oop;

import java.io.IOException;




public class Application {

    public static void main(String... args) throws IOException {
        JsonSmartHomeLoader jsonSmartHomeLoader = new  JsonSmartHomeLoader("smart-home-1.js");
        SmartHome smartHome = jsonSmartHomeLoader.loadSmartHome();
        smartHome.setAlarm(new Alarm(1111));

        EventCenterHandler eventCenterHandler = new EventCenterHandler(
               smartHome
        );
        eventCenterHandler.handleEvents(new RandomEventGenerator());
    }

}
