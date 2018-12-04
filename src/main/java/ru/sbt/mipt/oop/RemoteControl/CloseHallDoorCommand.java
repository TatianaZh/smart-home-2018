package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.Parts.Door;

import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SmartHome;

public class CloseHallDoorCommand implements Command {
    private final SmartHome smartHome;

    public CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }


    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (room.getName().equals("hall")) {
                    door.setOpen(true);
                }
            }
        }
    }
}
