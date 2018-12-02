package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class LightHallOnCommand implements Command {
    private final SmartHome smartHome;

    public LightHallOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (room.getName().equals("hall")) {
                    light.setOn(true);
                }
            }
        }
    }
}

