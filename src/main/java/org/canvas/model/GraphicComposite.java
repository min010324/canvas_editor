package org.canvas.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class GraphicComposite implements GraphicInterface, Iterable<GraphicInterface> {

    private ArrayList<GraphicInterface> graphicObjects = new ArrayList<>();

    private int mouseStartX, mouseStartY;

    public void move(int dx, int dy) {
        for (GraphicInterface o : graphicObjects) {
            o.move(dx, dy);
        }
    }

    public void handleMousePressed(MouseEvent e) {
        mouseStartX = e.getX();
        mouseStartY = e.getY();
    }

    public void handleMouseDragged(MouseEvent e) {
        int dx = e.getX() - mouseStartX;
        int dy = e.getY() - mouseStartY;
        mouseStartX = e.getX();
        mouseStartY = e.getY();
        move(dx, dy);
    }

    public ArrayList<GraphicInterface> getGraphicObjects() {
        return graphicObjects;
    }

    public void selectObject(GraphicInterface object) {
        if (graphicObjects.contains(object)) {
            object.setColor(Color.black);
            graphicObjects.remove(object);
        } else {
            graphicObjects.add(object);
        }
    }

    @Override
    public Iterator<GraphicInterface> iterator() {
        return graphicObjects.iterator();
    }

    public void setObjectInfo(int x, int y, int width, int height) {
        if (graphicObjects.size() == 1) {
            graphicObjects.get(0).setObjectInfo(x, y, width, height);
        }
    }

    public void setColor(Color color) {
        for (GraphicInterface o : graphicObjects) {
            o.setColor(color);
        }
    }

    public void draw(Graphics2D g2) {
        for (GraphicInterface o : graphicObjects) {
            o.draw(g2);
        }
    }

    public boolean contains(Point point) {
        for (GraphicInterface o : graphicObjects) {
            if (o.contains(point)) {
                return true;
            }
        }
        return false;
    }


    public int getID() {
        if (graphicObjects.size() == 1) {
            return graphicObjects.get(0).getID();
        }
        return -1;
    }

    public int getX() {
        if (graphicObjects.size() == 1) {
            return graphicObjects.get(0).getX();
        }
        return 0;
    }

    public int getY() {
        if (graphicObjects.size() == 1) {
            return graphicObjects.get(0).getY();
        }
        return 0;
    }

    public int getWidth() {
        if (graphicObjects.size() == 1) {
            return graphicObjects.get(0).getWidth();
        }
        return 0;
    }

    public int getHeight() {
        if (graphicObjects.size() == 1) {
            return graphicObjects.get(0).getHeight();
        }
        return 0;
    }


}
