package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.SmartHome;

public class AlarmOnCommand implements Command {

    private final SmartHome smartHome;

    public AlarmOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }
    @Override
    public void execute() {
        smartHome.getAlarm().turnOn();
    }
}
