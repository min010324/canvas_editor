package org.canvas.model.decorator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import org.canvas.model.GraphicInterface;
import org.canvas.model.GraphicObject;

public class ClickedDecorator implements GraphicInterface {

    protected GraphicObject graphicObject;

    public ClickedDecorator(GraphicObject graphicObject) {
        this.graphicObject = graphicObject;
    }

    public void setObjectInfo(int x, int y, int width, int height) {
        graphicObject.setObjectInfo(x, y, width, height);
    }

    public void draw(Graphics g) {
        graphicObject.draw(g);

        Graphics2D g2d = (Graphics2D) g;
        Stroke oldStroke = g2d.getStroke();
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(2)); // 테두리 두께 조절
        g2d.drawRect(graphicObject.getX(), graphicObject.getY(), graphicObject.getWidth(),
            graphicObject.getHeight());
        g2d.setStroke(oldStroke);
    }

    public boolean contains(Point point) {
        return graphicObject.contains(point);
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
