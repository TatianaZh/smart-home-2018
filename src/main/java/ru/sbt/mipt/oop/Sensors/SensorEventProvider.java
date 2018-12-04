package ru.sbt.mipt.oop.Sensors;

import ru.sbt.mipt.oop.Sensors.SensorEvent;

public interface SensorEventProvider {
    static SensorEvent getNextSensorEvent(){
        return null;
    };
}
