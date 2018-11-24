package ru.sbt.mipt.oop.Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IteratorTest {
    @Test
    public void actionableComposite(){
        List<Light> lights_1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors_1 = Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights_1, doors_1, "kitchen");

        List<Light> lights_2 = Arrays.asList(new Light("3", true));
        List<Door> doors_2 = Arrays.asList(new Door(false, "2"));
        Room bathroom = new Room(lights_2, doors_2, "bathroom");

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));

        Set<Object> unvisitedObjects = new HashSet<>();
        unvisitedObjects.add(smartHome);
        unvisitedObjects.add(kitchen);
        unvisitedObjects.add(bathroom);
        unvisitedObjects.addAll(lights_1);
        unvisitedObjects.addAll(lights_2);
        unvisitedObjects.addAll(doors_1);
        unvisitedObjects.addAll(doors_2);

        smartHome.executeAction(obj ->{
            unvisitedObjects.remove(obj);
        });
        System.out.println(unvisitedObjects);
        assertTrue(unvisitedObjects.isEmpty());
    }
    
}
