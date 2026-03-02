package com.geoxify;

import javax.swing.BorderFactory;
import javax.swing.JFrame; // built in java class (Java Swing)
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;

    // Text Area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean isWordWrap = false;

    // Menu Bar
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colorMenu;

    // File Submenu
    JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;

    // Edit Menu
    JMenuItem undoIten, redoItem;

    // Format SUbmenu
    JMenuItem wordWrapItem, arialFontItem, comicSansMSFontItem, timesNewRomanFontItem, fontSize8Item, fontSize12Item,
            fontSize16Item, fontSize20Item, fontSize24Item, fontSize28Item;
    JMenu fontMenu, fontSizeMenu;

    // Color Menu
    JMenuItem color1Item, color2Item, color3Item;

    FileFunction file = new FileFunction(this);
    FormatFunction format = new FormatFunction(this);
    ColorFunction color = new ColorFunction(this);
    EditFunction edit = new EditFunction(this);
    KeyHandler handler = new KeyHandler(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWIndow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        format.selectedFont = "Arial";
        format.createFont(12);
        format.wordWrap();

        color.changeColor("White");
        window.setVisible(true);
    }

    public void createWIndow() {
        window = new JFrame("geo's Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(handler);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                });

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);
        window.setVisible(true);
        // window.add(textArea);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        formatMenu = new JMenu("Format");
        menuBar.add(formatMenu);

        colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);
    }

    public void createFileMenu() {
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        newItem.setActionCommand("New");
        fileMenu.add(newItem);

        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        openItem.setActionCommand("Open");
        fileMenu.add(openItem);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        saveItem.setActionCommand("Save");
        fileMenu.add(saveItem);

        saveAsItem = new JMenuItem("Save As");
        saveAsItem.addActionListener(this);
        saveAsItem.setActionCommand("Save As");
        fileMenu.add(saveAsItem);

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        exitItem.setActionCommand("Exit");
        fileMenu.add(exitItem);
    }

    public void createEditMenu() {
        undoIten = new JMenuItem("Undo");
        undoIten.addActionListener(this);
        undoIten.setActionCommand("Undo");
        editMenu.add(undoIten);

        redoItem = new JMenuItem("Redo");
        redoItem.addActionListener(this);
        redoItem.setActionCommand("Redo");
        editMenu.add(redoItem);
    }

    public void createFormatMenu() {
        wordWrapItem = new JMenuItem("Word Wrap: Off");
        wordWrapItem.addActionListener(this);
        wordWrapItem.setActionCommand("Word Wrap");
        formatMenu.add(wordWrapItem);

        fontMenu = new JMenu("Font");
        formatMenu.add(fontMenu);

        arialFontItem = new JMenuItem("Arial");
        arialFontItem.addActionListener(this);
        arialFontItem.setActionCommand("Arial");
        fontMenu.add(arialFontItem);

        comicSansMSFontItem = new JMenuItem("Comic Sans MS");
        comicSansMSFontItem.addActionListener(this);
        comicSansMSFontItem.setActionCommand("Comic Sans MS");
        fontMenu.add(comicSansMSFontItem);

        timesNewRomanFontItem = new JMenuItem("Times New Roman");
        timesNewRomanFontItem.addActionListener(this);
        timesNewRomanFontItem.setActionCommand("Times New Roman");
        fontMenu.add(timesNewRomanFontItem);

        fontSizeMenu = new JMenu("Font Size");
        formatMenu.add(fontSizeMenu);

        fontSize8Item = new JMenuItem("8");
        fontSize8Item.addActionListener(this);
        fontSize8Item.setActionCommand("8");
        fontSizeMenu.add(fontSize8Item);

        fontSize12Item = new JMenuItem("12");
        fontSize12Item.addActionListener(this);
        fontSize12Item.setActionCommand("12");
        fontSizeMenu.add(fontSize12Item);

        fontSize16Item = new JMenuItem("16");
        fontSize16Item.addActionListener(this);
        fontSize16Item.setActionCommand("16");
        fontSizeMenu.add(fontSize16Item);

        fontSize20Item = new JMenuItem("20");
        fontSize20Item.addActionListener(this);
        fontSize20Item.setActionCommand("20");
        fontSizeMenu.add(fontSize20Item);

        fontSize24Item = new JMenuItem("24");
        fontSize24Item.addActionListener(this);
        fontSize24Item.setActionCommand("24");
        fontSizeMenu.add(fontSize24Item);

        fontSize28Item = new JMenuItem("28");
        fontSize28Item.addActionListener(this);
        fontSize28Item.setActionCommand("28");
        fontSizeMenu.add(fontSize28Item);
    }

    public void createColorMenu() {
        color1Item = new JMenuItem("White");
        color1Item.addActionListener(this);
        color1Item.setActionCommand("White");
        colorMenu.add(color1Item);

        color2Item = new JMenuItem("Black");
        color2Item.addActionListener(this);
        color2Item.setActionCommand("Black");
        colorMenu.add(color2Item);

        color3Item = new JMenuItem("Blue");
        color3Item.addActionListener(this);
        color3Item.setActionCommand("Blue");
        colorMenu.add(color3Item);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.openFIle();
                break;
            case "Save":
                file.saveFile();
                break;
            case "Save As":
                file.saveAsFile();
                break;
            case "Exit":
                file.exitFile();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Comic Sans MS":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
            case "8":
                format.createFont(8);
                break;
            case "12":
                format.createFont(12);
                break;
            case "16":
                format.createFont(16);
                break;
            case "20":
                format.createFont(20);
                break;
            case "24":
                format.createFont(24);
                break;
            case "28":
                format.createFont(28);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;

        }
    }

}