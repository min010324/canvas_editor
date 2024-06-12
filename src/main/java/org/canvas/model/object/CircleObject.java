package org.canvas.model.object;

import java.awt.Color;
import java.awt.Graphics2D;
import org.canvas.model.GraphicObject;

public class CircleObject extends GraphicObject {

    public CircleObject(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.drawOval(x, y, width, height);
    }
}
