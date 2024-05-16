package org.canvas.model.object;

import java.awt.Graphics;
import org.canvas.model.GraphicObject;

public class RectangleObject extends GraphicObject {

    public RectangleObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }
    
}
