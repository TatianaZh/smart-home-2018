package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.AlarmStateEnum;

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