package ru.sbt.mipt.oop.Tests.RemoteControlTests;

import org.junit.Test;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;
import ru.sbt.mipt.oop.RemoteControl.CloseHallDoorCommand;
import ru.sbt.mipt.oop.RemoteControl.RemoteControlImpl;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;

public class CloseHallDoorTest {
    private RemoteControlImpl rci;


    SmartHome smartHome = new SmartHome();

    List<Light> lights = new ArrayList<>();
    List<Door> doors = new ArrayList<>();

    Light lightOff = new Light("1", true);
    Light lightOn = new Light("2", false);
    Door door= new Door(true,"3");


    @Test
    public void test(){

        lights.add(lightOff);
        lights.add(lightOn);
        doors.add(door);

        Room room1 = new Room(lights, doors,"hall");
        smartHome.addRoom(room1);

        rci.setCommand("A", new CloseHallDoorCommand(smartHome));
        rci.onButtonPressed("A");
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall"))
                for (Door door : room.getDoors()) {
                    assertFalse(door.isOpen());
                }
        }
    }
}
