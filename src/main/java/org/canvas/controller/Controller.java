package org.canvas.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicInterface;
import org.canvas.model.GraphicObject;
import org.canvas.model.Model;
import org.canvas.observer.Observer;

public class Controller extends MouseAdapter {

    private final Model model;

    public Controller(Model model) {
        this.model = model;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        GraphicInterface object = model.getObjectAtPoint(e.getPoint());
        if (object != null) {
            model.handleMouseClick(object);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GraphicComposite object = model.getGraphicComposite();
        object.handleMousePressed(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GraphicComposite object = model.getGraphicComposite();
        object.handleMouseDragged(e);
        model.notifyObserverClickedObject();
    }

    public void bringObjectToFront() {
        model.bringObjectToFront();
    }

    public void bringObjectToBack() {
        model.bringObjectToBack();
    }

}
