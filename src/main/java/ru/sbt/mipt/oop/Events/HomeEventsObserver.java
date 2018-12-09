package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Events.EventsManager;
import ru.sbt.mipt.oop.Processors.EventProcessor;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.Sensors.SensorEventProvider;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.Collection;

public class HomeEventsObserver implements EventsManager {

    private static final Collection<EventProcessor> eventProcessors = new ArrayList<>();
    protected SmartHome smartHome;
    private SensorEventProvider sensorEventProvider;

    public HomeEventsObserver(SmartHome smartHome, SensorEventProvider sensorEventProvider){
        this.smartHome = smartHome;
        this.sensorEventProvider = sensorEventProvider;
    }

    public HomeEventsObserver(SensorEventProvider sensorEventProvider){
        this.sensorEventProvider = sensorEventProvider;
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
          while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}