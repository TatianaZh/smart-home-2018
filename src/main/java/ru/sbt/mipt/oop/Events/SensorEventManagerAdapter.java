package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.*;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class SensorEventManagerAdapter implements EventsManager{

    private SensorEventsManager sensorEventsManager;
    private final Collection<EventProcessor> eventProcessors = new ArrayList<>();

    public SensorEventManagerAdapter(SensorEventsManager sensorEventsManager) {
       this.sensorEventsManager = sensorEventsManager;
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }
}
