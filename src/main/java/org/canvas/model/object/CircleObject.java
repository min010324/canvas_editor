package org.canvas.model.object;

import java.awt.Graphics;
import org.canvas.model.GraphicObject;

public class CircleObject extends GraphicObject {

    public CircleObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }
}
