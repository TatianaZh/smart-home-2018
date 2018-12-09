package ru.sbt.mipt.oop.Parts;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.ActionExecutor;

public class Light implements ActionExecutor {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
