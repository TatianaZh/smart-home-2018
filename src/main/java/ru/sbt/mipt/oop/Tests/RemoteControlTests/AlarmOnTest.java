package ru.sbt.mipt.oop.Tests.RemoteControlTests;

import org.junit.Test;;
import ru.sbt.mipt.oop.Alarm.AlarmStateEnum;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.RemoteControl.AlarmOnCommand;
import ru.sbt.mipt.oop.RemoteControl.RemoteControlImpl;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AlarmOnTest {

        private RemoteControlImpl rci = new RemoteControlImpl();
        private SmartHome smartHome = new SmartHome();
        private Light light1 = new Light("1", false), light2 = new Light("2", true);


        @Test
        public void test() {
            List<Light> lights = new ArrayList<>();
            lights.add(light1);
            lights.add(light2);
            smartHome.addRoom(new Room(lights, null, "kitchen"));
            rci.setCommand("A", new AlarmOnCommand(smartHome));
            rci.onButtonPressed("A");
            assertEquals(smartHome.getAlarm().getState(), AlarmStateEnum.ON);
        }
    }

