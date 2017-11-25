package com.morph.engine.debug;

import com.morph.engine.events.ConsoleEvent;
import com.morph.engine.events.EventDispatcher;
import com.morph.engine.events.EventListener;
import com.morph.engine.util.ScriptUtils;

import java.util.logging.Logger;

/**
 * Created on 11/24/2017.
 */
public class Console {
    public enum ScriptType {
        KOTLIN, PYTHON, MULTI
    }

    private String text;
    private ScriptType type;
    private Logger logger;
    private String currentLine;

    public Console(Console.ScriptType type) {
        this.type = type;
        EventDispatcher.INSTANCE.addEventHandler(this);
    }

    public void readIn(String line) {
        print(line);
        runLine(line);
    }

    public void print(String line) {
        this.currentLine = line;
        this.text += line;

        EventDispatcher.INSTANCE.dispatchEvent(new ConsoleEvent(this, ConsoleEvent.EventType.UPDATE, ""));
    }

    public String getText() {
        return text;
    }

    public String getLastLine() {
        return currentLine;
    }

    private void runLine(String line) {
        switch (type) {
            case MULTI:
                String[] parts = line.split(":");
                parts[1] = parts[1].trim();
                ScriptUtils.readScript(parts[1], parts[0]);
                break;
            case KOTLIN:
                ScriptUtils.readScript(line, "kts");
                break;
            case PYTHON:
                ScriptUtils.readScript(line, "py");
        }
    }

    @EventListener(ConsoleEvent.class)
    public void onConsoleEvent(ConsoleEvent e) {
        if (e.getType() == ConsoleEvent.EventType.PRINT) {
            print(e.getMessage());
        }
    }
}
