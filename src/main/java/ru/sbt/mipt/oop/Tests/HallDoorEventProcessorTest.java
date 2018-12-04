package ru.sbt.mipt.oop.Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.Sensors.SensorEventType;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class HallDoorEventProcessorTest {

    @Test
    public void checkLightAfterHall(){

        Light light;
        List<Light> arrayListForLight = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            light = new Light("" + i, true);
            arrayListForLight.add(light);
        }

        Door door = new Door(false, "4" );
        List<Door> arrayListForDoor = new ArrayList<>();
        arrayListForDoor.add(door);

        Room room = new Room(arrayListForLight, arrayListForDoor, "hall");
        List<Room> listForRooms = new ArrayList<>();
        listForRooms.add(room);

        SmartHome smartHome = new SmartHome(listForRooms);
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.DOOR_CLOSED, "4");

        for (Room room1 : smartHome.getRooms())
            for (Light light1 : room1.getLights())
                assertTrue(light1.isOn());

    }

}