package org.canvas.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import org.canvas.observer.Observer;
import org.canvas.observer.Subject;

public class Model implements Subject {

    private final ArrayList<GraphicObject> graphicObjects;
    private final ArrayList<Observer> observers;

    private ArrayList<GraphicObject> selectedGraphicObjects;

    public static final Gson gson = new Gson();

    public Model() {
        this.graphicObjects = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.selectedGraphicObjects = new ArrayList<>();
    }

    public void createObject(GraphicObject object) {
        int size = graphicObjects.size();
        if (size == 0) {
            object.setId(0);
        } else {
            object.setId(graphicObjects.get(size - 1).id);
        }

        graphicObjects.add(object);
        System.out.println(gson.toJson(graphicObjects));
        notifyObserver();
    }

    public void updateObject(GraphicObject object) {
        for (GraphicObject o : graphicObjects) {
            if (o.getID() == object.getID()) {
                o.setObjectInfo(object.getX(), object.getY(), object.getWidth(),
                    object.getHeight());
            }
        }

        System.out.println(gson.toJson(graphicObjects));
        notifyObserver();
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
            o.updateGraphicObjectsSelected(selectedGraphicObjects);
        }
    }

    public void handleMouseClick(GraphicObject o) {
        if (selectedGraphicObjects.contains(o)) {
            selectedGraphicObjects.remove(o);
        } else {
            selectedGraphicObjects.add(o);
        }
        notifyObserverClickedObject();
    }
}
