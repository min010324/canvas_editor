package org.canvas.model;

import java.awt.Graphics;
import java.awt.Point;

public interface GraphicInterface {

    //    void handleMouseClick(MouseEvent e, GraphicObject object);

    void setObjectInfo(int x, int y, int width, int height);

    void draw(Graphics g);

    boolean contains(Point point);

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
