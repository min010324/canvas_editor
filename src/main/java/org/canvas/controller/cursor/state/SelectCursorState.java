package org.canvas.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicInterface;
import org.canvas.model.Model;

public class SelectCursorState implements CursorState {

    private final Model model;

    public SelectCursorState(Model model) {
        this.model = model;
    }

    public void mouseClicked(MouseEvent e) {
        GraphicInterface object = model.getObjectAtPoint(e.getPoint());
        if (object != null) {
            model.handleMouseClick(object);
        }
    }

    public void mousePressed(MouseEvent e) {
        GraphicComposite object = model.getGraphicComposite();
        object.handleMousePressed(e);
    }

    public void mouseDragged(MouseEvent e) {
        GraphicComposite object = model.getGraphicComposite();
        object.handleMouseDragged(e);
        model.notifyObserverClickedObject();
    }


}
