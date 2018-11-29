package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.Alarm.AlarmEventProcessor;
import ru.sbt.mipt.oop.Events.SensorEventManagerAdapter;
import ru.sbt.mipt.oop.Events.SensorEventsManager;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();



    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        SensorEventProvider sensorEventProvider = new RandomSensorEventProvider();
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        EventsManager eventManager = new SensorEventManagerAdapter(sensorEventsManager);

        SmartHome smartHome = smartHomeLoader.loadSmartHome();

        eventManager.registerEventProcessor(new LightsEventProcessor());
        eventManager.registerEventProcessor(new DoorEventProcessor());
        eventManager.registerEventProcessor(new AlarmEventProcessor());
        eventManager.registerEventProcessor(new HallDoorEventProcessor());
        eventManager.runEventsCycle(smartHome);
    }

}
