package ru.sbt.mipt.oop.Sample;

import ru.sbt.mipt.oop.Events.SensorEventsManager;

public class Sample {
    public static void main(String[] args) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.start();
    }
}