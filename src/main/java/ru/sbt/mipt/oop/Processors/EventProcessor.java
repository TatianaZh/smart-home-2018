package ru.sbt.mipt.oop.Processors;

import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
}
