package ru.sbt.mipt.oop;


import ru.sbt.mipt.oop.Alarm.AlarmEventProcessor;

import java.io.IOException;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        HomeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        HomeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        HomeEventsObserver.registerEventProcessor(new AlarmEventProcessor());
        HomeEventsObserver.runEventsCycle(smartHome);
    }

}
