package com.geoxify;

import java.awt.Font;

public class FormatFunction {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public FormatFunction(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if (!gui.isWordWrap) {
            gui.isWordWrap = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.wordWrapItem.setText("World Wrap: On");
        } else if (gui.isWordWrap) {
            gui.isWordWrap = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.wordWrapItem.setText("World Wrap: Off");
        }
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;

        }
    }
}