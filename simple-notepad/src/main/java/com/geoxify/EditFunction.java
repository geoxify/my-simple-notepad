package com.geoxify;

public class EditFunction {
    GUI gui;

    public EditFunction(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        gui.um.undo();
    }

    public void redo() {
        gui.um.redo();
    }
}