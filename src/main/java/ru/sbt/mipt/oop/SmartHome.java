package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.ActionExecutor;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Sensors.CommandType;
import ru.sbt.mipt.oop.Sensors.SensorCommand;
import ru.sbt.mipt.oop.Sensors.SensorCommandExecutor;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements ActionExecutor {
    Collection<Room> rooms;
    Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void turnOffLights() {
        for (Room homeRoom : getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }

    public Alarm getAlarm() {
        return alarm;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : this.getRooms()) {
            room.executeAction(action);
        }
    }
}
