package org.canvas.model;

import com.google.gson.Gson;
import java.awt.Point;
import java.util.ArrayList;
import org.canvas.observer.Observer;
import org.canvas.observer.Subject;

public class Model implements Subject {

    private final ArrayList<GraphicInterface> graphicObjects = new ArrayList<>();
    private final ArrayList<Observer> observers = new ArrayList<>();

    private final GraphicComposite graphicComposite = new GraphicComposite();

    public static final Gson gson = new Gson();

    public void createObject(GraphicObject object) {
        int size = graphicObjects.size();
        if (size == 0) {
            object.setId(0);
        } else {
            object.setId(graphicObjects.get(size - 1).getID());
        }

        graphicObjects.add(object);
        notifyObserver();
    }

    public void updateObject(GraphicInterface object) {
        notifyObserver();
    }

    public GraphicInterface getObjectAtPoint(Point point) {
        for (GraphicInterface object : graphicObjects) {
            if (object.contains(point)) {
                return object;
            }
        }
        return null;
    }

    public GraphicComposite getGraphicComposite() {
        return graphicComposite;
    }

    public void bringObjectToFront() {
        for (GraphicInterface object : graphicComposite.getGraphicObjects()) {
            graphicObjects.remove(object);
            graphicObjects.add(0, object);
        }
        notifyObserver();
        notifyObserverClickedObject();
    }

    public void bringObjectToBack() {
        for (GraphicInterface object : graphicComposite.getGraphicObjects()) {
            graphicObjects.remove(object);
            graphicObjects.add(object);
        }
        notifyObserver();
        notifyObserverClickedObject();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers) {
            o.updateGraphicObjects(graphicObjects);
        }
    }

    public void notifyObserverClickedObject() {
        for (Observer o : observers) {
            o.updateGraphicObjectsSelected(graphicComposite);
        }
    }

    public void handleMouseClick(GraphicInterface graphic) {
        if (graphicComposite.hasGraphic(graphic)) {
            graphicComposite.remove(graphic);
        } else {
            graphicComposite.add(graphic);
        }
        notifyObserverClickedObject();
    }
}
