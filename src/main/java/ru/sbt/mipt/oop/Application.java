package ru.sbt.mipt.oop;

import java.io.IOException;




public class Application {

    public static void main(String... args) throws IOException {
        EventCenterHandler eventCenterHandler = new EventCenterHandler(
                new  JsonSmartHomeLoader("smart-home-1.js")
        );
        eventCenterHandler.handleEvents(new RandomEventGenerator());
    }

}
