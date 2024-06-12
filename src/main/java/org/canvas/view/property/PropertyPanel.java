package org.canvas.view.property;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicInterface;
import org.canvas.observer.Observer;

public class PropertyPanel extends JPanel implements Observer {

    private GraphicInterface selectedObject;

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
    public void updateGraphicObjects(ArrayList<GraphicInterface> objects) {

    }


    @Override
    public void updateGraphicObjectsSelected(GraphicInterface objects) {
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
