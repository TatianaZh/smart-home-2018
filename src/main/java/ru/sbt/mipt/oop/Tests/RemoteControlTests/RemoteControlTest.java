package ru.sbt.mipt.oop.Tests.RemoteControlTests;
import org.junit.Test;
import ru.sbt.mipt.oop.Alarm.AlarmStateEnum;
import ru.sbt.mipt.oop.Parts.Light;

import ru.sbt.mipt.oop.RemoteControl.*;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoteControlTest {

    @Test
    public void run(){
        RemoteControlImpl rci = new RemoteControlImpl();

        SmartHome smartHome = new SmartHome();

        List<Light> lights = new ArrayList<>();
        String lightOffId = "1";
        String lightOnId = "2";
        Light lightOff = new Light(lightOffId, true);
        Light lightOn = new Light(lightOnId, false);
        lights.add(lightOff);
        lights.add(lightOn);

        Command alarmOn = new AlarmOnCommand(smartHome);
        Command alarmRingAlarm = new AlarmRingCommand(smartHome);
        Command lightOnLights = new LightOnCommand(lights);
        Command lightOffLights = new LightOffCommand(lights);

        rci.setCommand("A", alarmOn);
        rci.setCommand("B", alarmRingAlarm);
        rci.setCommand("C", lightOnLights);
        rci.setCommand("D",lightOffLights);


      rci.onButtonPressed("A");
      assertEquals(smartHome.getAlarm().getState(), AlarmStateEnum.ON);

       rci.onButtonPressed("B");
        assertEquals(smartHome.getAlarm().getState(), AlarmStateEnum.RING);

        rci.onButtonPressed("C");
        assertFalse(lightOff.isOn());
        assertFalse(lightOn.isOn());

        rci.onButtonPressed("D");
        assertTrue(lightOff.isOn());
        assertTrue(lightOn.isOn());
    }
}