package ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.Sensors.SensorEvent;

public class Alarm {
    private final String truePassword;
    private AlarmState state;

    public Alarm(String password) {
        truePassword = password;
        state = new AlarmOFF(this);
    }

    public void turnOn(){
        state.turnOn();
    }

    public void turnOff() {
        state.turnOff();
    }

    public void enterPassword(String password) {
        state.enterPassword(password);
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    boolean checkPassword (String password) {
        if(password.equals(truePassword)) return true;
        return false;
    }

    public AlarmStateEnum getState() {
        return state.getState();
    }

    public void startRing() {
        state.startRing();
    }
}