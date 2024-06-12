package org.canvas.view.canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicObject;
import org.canvas.model.decorator.ClickedDecorator;
import org.canvas.observer.Observer;

public class CanvasPanel extends JPanel implements Observer {

    private ArrayList<GraphicObject> graphicObjects = new ArrayList<>();
    private GraphicComposite selectedGraphicObjects;

    public CanvasPanel(Controller controller) {
        controller.registerObserver(this);
        setBackground(Color.WHITE);
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicObject> objects) {
        this.graphicObjects = objects;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        System.out.println(graphicObjects.size());

        for (GraphicObject object : graphicObjects) {
//            if (this.selectedGraphicObjects.contains(object)) {
//                ClickedDecorator selectedObject = new ClickedDecorator(object);
//                selectedObject.draw(g);
//            } else {
//                object.draw(g);
//            }
            object.draw(graphics2D);
        }

        if (selectedGraphicObjects != null) {
            ClickedDecorator clickedDecoratorObject = new ClickedDecorator(selectedGraphicObjects);
            clickedDecoratorObject.draw(graphics2D);
        }

    }


    @Override
    public void updateGraphicObjectsSelected(GraphicComposite objects) {
        this.selectedGraphicObjects = objects;
        repaint();
    }
}
