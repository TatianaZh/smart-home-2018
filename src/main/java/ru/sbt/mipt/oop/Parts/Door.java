package ru.sbt.mipt.oop.Parts;

import ru.sbt.mipt.oop.Action.Action;
import ru.sbt.mipt.oop.Action.ActionExecutor;

public class Door implements ActionExecutor {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
