package ru.sbt.mipt.oop.Parts;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDoor {
    private final SmartHome smartHome;
    private ArrayList<Door> doors;
    private Collection<Room> rooms;
    private Iterator<Door> iterator;

    public IteratorDoor(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.rooms = smartHome.getRooms();
        this.doors =new ArrayList<>(getAllDoors(rooms));
        this.iterator = doors.iterator();
    }

    private Collection<Door> getAllDoors(Collection<Room> rooms) {
        Collection<Door> doorArrayList = new ArrayList<>();
        for (Room room : rooms) {
            doorArrayList.addAll(room.getDoors());
        }
        return doorArrayList;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Door next() {
        return iterator.next();
    }
}
