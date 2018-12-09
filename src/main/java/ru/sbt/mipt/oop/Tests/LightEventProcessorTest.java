package ru.sbt.mipt.oop.Tests;

import org.junit.Before;
import org.junit.Test;

import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Processors.LightsEventProcessor;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.Sensors.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LightEventProcessorTest {
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
    public void lightIsOnTest() {

        event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        new LightsEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            Light light = room.getLightById("1");
            assertTrue(light.isOn());
        }
    }

    @Test
    public void lightsIsOffTest() {

        event = new SensorEvent(SensorEventType.LIGHT_OFF, "2");
        new LightsEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();

        for (Room room : rooms) {
            Light light = room.getLightById("2");
            assertFalse(light.isOn());
        }
    }
}
