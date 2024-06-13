package org.canvas.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.canvas.controller.cursor.Cursor;
import org.canvas.controller.cursor.state.CursorState;
import org.canvas.controller.cursor.state.DefaultCursorState;
import org.canvas.controller.cursor.state.SelectCursorState;
import org.canvas.model.GraphicInterface;
import org.canvas.model.GraphicObject;
import org.canvas.model.Model;
import org.canvas.observer.Observer;

public class Controller extends MouseAdapter {

    private final Model model;
    private final Cursor cursor;

    public Controller(Model model) {
        this.model = model;
        this.cursor = new Cursor(model);
    }

    public void createObject(GraphicObject object) {
        model.createObject(object);
    }

    public void updateObject(GraphicInterface object) {
        model.updateObject(object);
    }

    public void registerObserver(Observer o) {
        model.registerObserver(o);
    }

    public void removeObserver(Observer o) {
        model.removeObserver(o);
    }

    public void setCursor(CursorState state) {
        this.cursor.setCursorState(state);
    }

    public void setDefaultCursorState() {
        setCursor(new DefaultCursorState(model));
    }

    public void setSelectCursorState() {
        setCursor(new SelectCursorState(model));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.cursor.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.cursor.mousePressed(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.cursor.mouseDragged(e);
    }

    public void bringObjectToFront() {
        model.bringObjectToFront();
    }

    public void bringObjectToBack() {
        model.bringObjectToBack();
    }

}
