package ru.sbt.mipt.oop.Tests;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Processors.DoorEventProcessor;
import ru.sbt.mipt.oop.Processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.Sensors.SensorEventType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.Sensors.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessorTest {
    private SensorEvent event;
    private SmartHome smartHome;

    @Before
    public void before() {
        List<Door> doors = new ArrayList<>();
        doors.add(new Door(true, "1"));
        doors.add(new Door(false, "2"));
        List<Light> lights = new ArrayList<>();
        lights.add(new Light("1", true));
        lights.add(new Light("2", false));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(lights, doors, "hall"));

        smartHome = new SmartHome(rooms);
    }


    @Test
    public void checkLightAfterHall(){
        event = new SensorEvent(DOOR_CLOSED, "1");
        new HallDoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }

}