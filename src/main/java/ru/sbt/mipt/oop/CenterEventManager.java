package ru.sbt.mipt.oop;

public interface CenterEventManager {
	void handleEvents();
	void registerEventHandler(EventHandler eventHandler);
}
