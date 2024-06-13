package org.canvas.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface GraphicInterface {

    //    void handleMouseClick(MouseEvent e, GraphicObject object);

    void setObjectInfo(int x, int y, int width, int height);

    void setColor(Color color);

    void add(GraphicInterface object);

    void remove(GraphicInterface object);

    void draw(Graphics2D g2);

    void move(int dx, int dy);

    boolean contains(Point point);

    int getID();

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
