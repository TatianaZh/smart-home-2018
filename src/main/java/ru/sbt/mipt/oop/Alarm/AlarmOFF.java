package ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.Sensors.SensorEvent;

public class AlarmOFF implements AlarmState {
    private final Alarm alarm;

    public AlarmOFF(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void turnOn() {
        alarm.setState(new AlarmON(alarm));
    }

    @Override
    public void turnOff() {}

    @Override
    public void onSensorEvent(SensorEvent event) {}

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startRing() {
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.OFF;
    }
}
