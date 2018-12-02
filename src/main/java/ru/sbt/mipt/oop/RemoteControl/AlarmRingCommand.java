package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.Alarm.AlarmRing;
import ru.sbt.mipt.oop.SmartHome;

public class AlarmRingCommand implements Command {
    private final SmartHome smartHome;

    public AlarmRingCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getAlarm().turnOn();
        smartHome.getAlarm().startRing();
}

}
