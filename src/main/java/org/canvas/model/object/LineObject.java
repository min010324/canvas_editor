package org.canvas.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.canvas.model.GraphicObject;

public class LineObject extends GraphicObject {

    private int x2, y2;

    public LineObject(int x, int y, int x2, int y2, int width, int height, Color color) {
        super(x, y, width, height, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        this.x2 += dx;
        this.y2 += dy;

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.drawLine(x, y, x2, y2);
    }
}
