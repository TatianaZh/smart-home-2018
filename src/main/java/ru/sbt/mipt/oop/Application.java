package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.Alarm.AlarmEventProcessor;
import ru.sbt.mipt.oop.Events.SensorEventManagerAdapter;
import ru.sbt.mipt.oop.Events.SensorEventsManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {

    private static Logger logger = LogManager.getLogger(Application.class);
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static EventsManager eventsManager = new EventsManagerAdapter(new SensorEventsManager());

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        EventsManager eventsManager = context.getBean(EventsManager.class);

        SensorEventProvider sensorEventProvider = new RandomSensorEventProvider();
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        EventsManager eventManager = new SensorEventManagerAdapter(sensorEventsManager);

        eventManager.registerEventProcessor(new LightsEventProcessor());
        eventManager.registerEventProcessor(new DoorEventProcessor());
        eventManager.registerEventProcessor(new AlarmEventProcessor());
        eventManager.registerEventProcessor(new HallDoorEventProcessor());
        eventManager.runEventsCycle(smartHome);
    }

}
