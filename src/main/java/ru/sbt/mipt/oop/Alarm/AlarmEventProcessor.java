package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;
public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!isAlarmEvent(event)) return;
        //событие от сигнализации
        if(event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().turnOn();
        }
        else {
            smartHome.getAlarm().turnOff();
        }
    }
    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}