package org.canvas.model;

import java.awt.Graphics;
import java.awt.Point;

public abstract class GraphicObject implements GraphicInterface {

    protected int id;
    protected int x, y;
    protected int width, height;

    public GraphicObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObjectInfo(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics g);

    public boolean contains(Point point) {
        return (point.x >= x && point.x <= x + width && point.y >= y && point.y <= y + height);
    }

    public int getID() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
