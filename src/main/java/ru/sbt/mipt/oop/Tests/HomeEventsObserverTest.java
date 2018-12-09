package ru.sbt.mipt.oop.Tests;

import org.junit.Test;
import ru.sbt.mipt.oop.Events.HomeEventsObserver;
import ru.sbt.mipt.oop.Processors.EventProcessor;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.Sensors.SensorEventProvider;
import ru.sbt.mipt.oop.Sensors.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.Sensors.SensorEventType.DOOR_CLOSED;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class HomeEventsObserverTest {

    public static class OneTimeEventProvider implements SensorEventProvider {

        private SensorEvent event;
        private int callsCount = 0;

        public OneTimeEventProvider(SensorEvent event) {
            this.event = event;
        }

        public SensorEvent getNextSensorEvent() {
            if (callsCount > 0) {
                return null;
            }
            callsCount++;
            return event;
        }
    }


    public static class CountingEventProcessor implements EventProcessor {
        private int count = 0;
        private SensorEvent event;

        @Override
        public void processEvent(SmartHome smartHome, SensorEvent event) {
            this.event = event;
            count++;
        }

        public SensorEvent getReceiveEvent() {
            return event;
        }

        public int getCount() {
            return count;
        }

    }

    @Test
    public void test() {

        SensorEvent sensorEvent = new SensorEvent(DOOR_CLOSED, "1");
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(new OneTimeEventProvider(sensorEvent));

        CountingEventProcessor countingEventProcessor1 = new CountingEventProcessor();
        homeEventsObserver.registerEventProcessor(countingEventProcessor1);
        homeEventsObserver.runEventsCycle(new SmartHome());

       assertEquals(1, countingEventProcessor1.getCount());
       assertEquals(sensorEvent, countingEventProcessor1.getReceiveEvent());

    }
}

