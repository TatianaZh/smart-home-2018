package ru.sbt.mipt.oop.Parts;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.ActionExecutor;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Light;

import java.util.Collection;

public class Room implements ActionExecutor {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }


    @Override
    public void executeAction(Action action) {
        action.execute(this);
        for (Door door : this.getDoors())
            door.executeAction(action);
        for (Light light : this.getLights())
            light.executeAction(action);
    }

    public Light getLightById(String objectId) {
        for (Light light : lights) {
            if (light.getId().equals(objectId))
                return light;
        }
        return null;
    }

    public Door getDoorById(String objectId) {
        for (Door door : doors) {
            if (door.getId().equals(objectId))
                return door;
        }
        return null;
    }

}
