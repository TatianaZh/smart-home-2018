package ru.sbt.mipt.oop.Tests;

import org.junit.Before;
import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Processors.DoorEventProcessor;
import ru.sbt.mipt.oop.Sensors.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static ru.sbt.mipt.oop.Sensors.SensorEventType.*;

public class DoorEventProcessorTest {
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
    public void doorIsClosedTest(){

        event = new SensorEvent(DOOR_CLOSED, "1");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            Door door = room.getDoorById("1");
            assertFalse(door.isOpen());
        }
    }

    @Test
    public void doorIsOpenedTest() {

        event = new SensorEvent(DOOR_OPEN, "2");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            Door door = room.getDoorById("2");
            assertTrue(door.isOpen());
        }
    }

}