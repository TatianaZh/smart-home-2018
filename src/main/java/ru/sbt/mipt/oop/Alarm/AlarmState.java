package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Sensors.SensorEvent;

public interface AlarmState {
    void turnOn();
    void turnOff();
    void enterPassword(String password);
    void startRing();
    AlarmStateEnum getState();
}
