package ru.sbt.mipt.oop.Processors;
import ru.sbt.mipt.oop.Parts.Door;
import ru.sbt.mipt.oop.Parts.Room;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.Sensors.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {


    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        if (event.getType() != DOOR_CLOSED) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        if (((Door) objectDoor).getId().equals(event.getObjectId())) smartHome.turnOffLights();
                    }
                });
            }
        }
    }

}
