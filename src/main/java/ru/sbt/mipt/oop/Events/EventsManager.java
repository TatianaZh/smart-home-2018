package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Processors.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;

public interface EventsManager {
    void registerEventProcessor(EventProcessor eventProcessor);
    void runEventsCycle(SmartHome smartHome);
}
