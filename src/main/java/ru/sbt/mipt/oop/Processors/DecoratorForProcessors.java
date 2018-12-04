package ru.sbt.mipt.oop.Processors;

import ru.sbt.mipt.oop.Alarm.AlarmStateEnum;
import ru.sbt.mipt.oop.Sensors.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class DecoratorForProcessors implements EventProcessor {
    EventProcessor eventProcessor;
    public DecoratorForProcessors(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        //режим тревоги
        if (smartHome.getAlarm().getState().equals(AlarmStateEnum.RING)) {
            smartHome.getAlarm().startRing();
        }
        eventProcessor.processEvent(smartHome, event);
    }
}