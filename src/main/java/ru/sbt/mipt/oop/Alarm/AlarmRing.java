package ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.Sensors.SensorEvent;

public class AlarmRing implements AlarmState {
    private final Alarm alarm;

    public AlarmRing(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void turnOn() {}

    @Override
    public void turnOff() {
        alarm.setState(new AlarmOFF(alarm));
    }

    @Override
    public void onSensorEvent(SensorEvent event) {}

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startRing() {
        alarm.setState(new AlarmRing(alarm));
        System.out.println("Sending sms");
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.RING;
    }
}
