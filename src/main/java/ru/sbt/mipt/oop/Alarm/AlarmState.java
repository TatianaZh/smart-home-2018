package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.SensorEvent;

public interface AlarmState {
    void turnOn();
    void turnOff();
    void onSensorEvent(SensorEvent event);
    void enterPassword(String password);
    void startRing();
    AlarmStateEnum getState();
}
