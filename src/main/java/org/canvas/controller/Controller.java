package org.canvas.controller;

import java.awt.event.MouseEvent;
import org.canvas.model.GraphicInterface;
import org.canvas.model.GraphicObject;
import org.canvas.model.Model;
import org.canvas.observer.Observer;

public class Controller {

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
        System.out.println("regist observer");
        model.registerObserver(o);
    }

    public void removeObserver(Observer o) {
        model.removeObserver(o);
    }

    public void handleMouseClick(MouseEvent e, GraphicObject selectedObject) {
//        for (GraphicObject object : graphicObjects) {
//            if (object.contains(e.getPoint())) {
//                controller.handleMouseClick(e, object);
//                break;
//            }
//        }
        model.handleMouseClick(selectedObject);
    }

}
