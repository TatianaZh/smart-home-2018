package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Sensors.SensorEvent;

public class AlarmPassword implements AlarmState {
    private final Alarm alarm;

    public AlarmPassword(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void turnOn() {}

    @Override
    public void turnOff() {}

    @Override
    public void onSensorEvent(SensorEvent event) {}

    @Override
    public void enterPassword(String password) {
        if(alarm.checkPassword(password)) {
            alarm.setState(new AlarmOFF(alarm));
        }
        else {
            alarm.setState(new AlarmRing(alarm));
        }
    }

    @Override
    public void startRing() {

    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.WAIT_FOR_PASSWORD;
    }
}
