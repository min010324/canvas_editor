package org.canvas.view.property;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicObject;
import org.canvas.observer.Observer;

public class PropertyPanel extends JPanel implements Observer {

    private GraphicComposite selectedObject;

    private final WidthPanel widthPanel;
    private final HeightPanel heightPanel;
    private final PositionPanel positionPanel;
    private final Controller controller;


    public PropertyPanel(Controller controller) {
        this.controller = controller;
        this.controller.registerObserver(this);
        setPreferredSize(new Dimension(200, getHeight()));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        this.widthPanel = new WidthPanel(controller);
        this.heightPanel = new HeightPanel(controller);
        this.positionPanel = new PositionPanel(controller);

        add(widthPanel);
        add(heightPanel);
        add(positionPanel);
    }


    @Override
    public void updateGraphicObjects(ArrayList<GraphicObject> objects) {
//        this.graphicObjects = objects;
//        repaint();
    }


    @Override
    public void updateGraphicObjectsSelected(GraphicComposite objects) {
//        if (!objects.getGraphicObjects().isEmpty()) {
//            this.selectedObject = objects; // todo multi select 대응
//            widthPanel.updateWidth(selectedObject.getWidth());
//            heightPanel.updateHeight(selectedObject.getHeight());
//            positionPanel.updatePosition(selectedObject.getX(), selectedObject.getY());
//        } else {
//            this.selectedObject = null;
//            widthPanel.updateWidth(0);
//            heightPanel.updateHeight(0);
//            positionPanel.updatePosition(0, 0);
//        }
        this.selectedObject = objects; // todo multi select 대응
        widthPanel.updateWidth(selectedObject.getWidth());
        heightPanel.updateHeight(selectedObject.getHeight());
        positionPanel.updatePosition(selectedObject.getX(), selectedObject.getY());
    }

    public void updateSelectedObject(int x, int y, int width, int height) {
        if (selectedObject == null) {
            return;
        }
        selectedObject.setObjectInfo(x, y, width, height);
        this.controller.updateObject(selectedObject);
    }
}
