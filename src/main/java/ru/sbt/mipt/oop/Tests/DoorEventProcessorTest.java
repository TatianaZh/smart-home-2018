package ru.sbt.mipt.oop.Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Sensors.SensorEvent;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.Sensors.SensorEventType.*;

public class DoorEventProcessorTest {

    @Test
    public void doorIsClosedTest(){
        SmartHome smartHome = new SmartHome();
        SensorEvent sensorEvent = new SensorEvent(DOOR_CLOSED, "1");
        Door door = new Door(false, "1");

        List<Door> listForDoors = new ArrayList<>();
        listForDoors.add(door);
        Room room = new Room(new ArrayList<Light>(), listForDoors,"1");
        smartHome.addRoom(room);

        for (Room rooms : smartHome.getRooms())
            for (Door doors : rooms.getDoors())
                if (doors.getId().equals(sensorEvent.getObjectId())) {
                    assertEquals("" + doors.getId(), "1");
                }
    }

    @Test
    public void doorIsOpenedTest(){
        SmartHome smartHome = new SmartHome();
        SensorEvent sensorEvent = new SensorEvent(DOOR_OPEN, "1");
        Door door = new Door(true, "1");

        List<Door> listForDoors = new ArrayList<>();
        listForDoors.add(door);
        Room room = new Room(new ArrayList<Light>(), listForDoors,"1");
        smartHome.addRoom(room);

        for (Room rooms : smartHome.getRooms())
            for (Door doors : rooms.getDoors())
                if (doors.getId().equals(sensorEvent.getObjectId())) {
                    assertEquals("" + doors.getId(), "1");
                }
    }

}