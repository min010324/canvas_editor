package org.canvas.model.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import org.canvas.model.GraphicInterface;

public class ClickedDecorator implements GraphicInterface {

    protected GraphicInterface graphicObject;

    public ClickedDecorator(GraphicInterface graphicObject) {
        this.graphicObject = graphicObject;
        setColor(Color.red);
    }

    public void setObjectInfo(int x, int y, int width, int height) {
        graphicObject.setObjectInfo(x, y, width, height);
    }

    public void setColor(Color color) {
        graphicObject.setColor(color);
    }

    @Override
    public void add(GraphicInterface object) {
    }

    @Override
    public void remove(GraphicInterface object) {
    }

    public void move(int dx, int dy) {
        graphicObject.move(dx, dy);

    }

    public void draw(Graphics2D g2) {
        graphicObject.draw(g2);
    }

    public boolean contains(Point point) {
        return graphicObject.contains(point);
    }

    public int getID() {
        return graphicObject.getID();
    }

    public int getX() {
        return graphicObject.getX();
    }

    public int getY() {
        return graphicObject.getY();
    }

    public int getWidth() {
        return graphicObject.getWidth();
    }

    public int getHeight() {
        return graphicObject.getHeight();
    }


}
