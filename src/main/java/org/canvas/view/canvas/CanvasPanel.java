package org.canvas.view.canvas;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicInterface;
import org.canvas.model.decorator.ClickedDecorator;
import org.canvas.observer.Observer;

public class CanvasPanel extends JPanel implements Observer {

    private ArrayList<GraphicInterface> graphicObjects = new ArrayList<>();
    private GraphicInterface selectedGraphicObjects;

    public CanvasPanel(Controller controller) {
        controller.registerObserver(this);
        setBackground(Color.WHITE);
        addMouseListener(controller);
        addMouseMotionListener(controller);
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicInterface> objects) {
        this.graphicObjects = objects;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        System.out.println(graphicObjects.size());

        for (GraphicInterface object : graphicObjects) {
            object.draw(graphics2D);
        }

        if (selectedGraphicObjects != null) {
            ClickedDecorator clickedDecoratorObject = new ClickedDecorator(selectedGraphicObjects);
            clickedDecoratorObject.draw(graphics2D);
        }

    }


    @Override
    public void updateGraphicObjectsSelected(GraphicInterface objects) {
        this.selectedGraphicObjects = objects;
        repaint();
    }
}
