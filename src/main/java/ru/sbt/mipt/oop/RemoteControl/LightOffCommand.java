package ru.sbt.mipt.oop.RemoteControl;

import ru.sbt.mipt.oop.Parts.Light;

import java.util.List;

public class LightOffCommand implements Command {
    private List<Light> lights;

    public LightOffCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (Light light : lights) {
            light.setOn(false);
        }
    }
}