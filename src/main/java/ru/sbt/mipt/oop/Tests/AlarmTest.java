package ru.sbt.mipt.oop.Tests;
import org.junit.Test;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmState;
import ru.sbt.mipt.oop.Alarm.AlarmStateEnum;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;

import static org.junit.Assert.*;


public class AlarmTest {

    public SensorEvent getSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "1234");
    }

    @Test
    public void testSystemOff(){
        Alarm alarm = new Alarm("1234");
        assertEquals(AlarmStateEnum.OFF, alarm.getState());
    }

    @Test
    public void testSystemOn(){
        Alarm alarm = new Alarm("1234");
        alarm.turnOn();
        assertEquals(AlarmStateEnum.ON, alarm.getState());
    }

    @Test
    public void testSystemSensorEvent(){
        Alarm alarm = new Alarm("1234");
        alarm.turnOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarm.onSensorEvent(sensorEvent);
        assertEquals(AlarmStateEnum.WAIT_FOR_PASSWORD, alarm.getState());
    }

    @Test
    public void testSystemWaitForPassword(){
        Alarm alarm = new Alarm("1234");
        alarm.turnOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarm.onSensorEvent(sensorEvent);
        alarm.enterPassword("1236");
        assertEquals(AlarmStateEnum.RING, alarm.getState());
    }


}
