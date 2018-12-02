package ru.sbt.mipt.oop.RemoteControl;

import java.util.HashMap;
import java.util.Map;

public class RemoteControlImpl implements RemoteControl {

    private Map<String,Command> button;

    public RemoteControlImpl() {
        button = new HashMap<>();
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        button.get(buttonCode).execute();
    }

    public void setCommand(String buttonCode, Command command) {
        button.put(buttonCode,command);
    }

}
