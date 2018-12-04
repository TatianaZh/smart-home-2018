package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.Alarm.AlarmEventProcessor;
import ru.sbt.mipt.oop.Configs.Config;
import ru.sbt.mipt.oop.Events.EventsManager;
import ru.sbt.mipt.oop.Events.SensorEventManagerAdapter;
import ru.sbt.mipt.oop.Events.SensorEventsManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.Loader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.Loader.SmartHomeLoader;
import ru.sbt.mipt.oop.Processors.DoorEventProcessor;
import ru.sbt.mipt.oop.Processors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.Processors.LightsEventProcessor;
import ru.sbt.mipt.oop.RemoteControl.RemoteControlImpl;
import ru.sbt.mipt.oop.RemoteControl.*;

import java.io.IOException;

public class Application {

    private static Logger logger = LogManager.getLogger(Application.class);

    private static EventsManager eventManager = new SensorEventManagerAdapter(new SensorEventsManager());
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();


    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        EventsManager eventManager = context.getBean(EventsManager.class);

        SmartHome smartHome = smartHomeLoader.loadSmartHome();

        RemoteControlImpl rci = context.getBean(RemoteControlImpl.class);
        RemoteControlRegistry remoteControlRegistry = context.getBean(RemoteControlRegistry.class);
        remoteControlRegistry.registerRemoteControl(rci,"1234");

        eventManager.registerEventProcessor(new LightsEventProcessor());
        eventManager.registerEventProcessor(new DoorEventProcessor());
        eventManager.registerEventProcessor(new AlarmEventProcessor());
        eventManager.registerEventProcessor(new HallDoorEventProcessor());
        eventManager.runEventsCycle(smartHome);
    }

}
