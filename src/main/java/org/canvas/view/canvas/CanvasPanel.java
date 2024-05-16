package org.canvas.view.canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicObject;
import org.canvas.model.decorator.ClickedDecorator;
import org.canvas.observer.Observer;

public class CanvasPanel extends JPanel implements Observer {

    private ArrayList<GraphicObject> graphicObjects = new ArrayList<>();
    private ArrayList<GraphicObject> selectedGraphicObjects = new ArrayList<>();

    public CanvasPanel(Controller controller) {
        controller.registerObserver(this);
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (GraphicObject object : graphicObjects) {
                    if (object.contains(e.getPoint())) {
                        controller.handleMouseClick(e, object);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicObject> objects) {
        this.graphicObjects = objects;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GraphicObject object : graphicObjects) {
            if (this.selectedGraphicObjects.contains(object)) {
                ClickedDecorator selectedObject = new ClickedDecorator(object);
                selectedObject.draw(g);
            } else {
                object.draw(g);
            }

        }
    }


    @Override
    public void updateGraphicObjectsSelected(ArrayList<GraphicObject> objects) {
        this.selectedGraphicObjects = objects;
        repaint();
    }
}
