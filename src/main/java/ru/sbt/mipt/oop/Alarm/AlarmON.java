package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Sensors.SensorEvent;

public class AlarmON implements AlarmState {
    private final Alarm alarm;

    public AlarmON(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void turnOn() {}

    @Override
    public void turnOff() {}

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startRing() {
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.ON;
    }
}
