package ru.sbt.mipt.oop.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.Events.SensorEventManagerAdapter;
import ru.sbt.mipt.oop.Events.SensorEventsManager;
import ru.sbt.mipt.oop.Events.EventsManager;
import ru.sbt.mipt.oop.Loader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.RemoteControl.RemoteControlImpl;
import ru.sbt.mipt.oop.RemoteControl.RemoteControlRegistry;
import ru.sbt.mipt.oop.Loader.SmartHomeLoader;

import java.io.IOException;


@Configuration
public class Config {

    @Bean
    SmartHomeLoader smartHomeLoader() {
        return new FileSmartHomeLoader();
    }

    @Bean
    EventsManager eventsManager() {
        return new SensorEventManagerAdapter(new SensorEventsManager());
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {return new RemoteControlRegistry();}

    @Bean
    RemoteControlImpl rci() throws IOException {
        return  new RemoteControlImpl();
    }
}