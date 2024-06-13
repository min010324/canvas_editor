package org.canvas.controller.cursor.state;

import java.awt.event.MouseEvent;
import org.canvas.model.Model;

public class DefaultCursorState implements CursorState {

    private final Model model;

    public DefaultCursorState(Model model) {
        this.model = model;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }


}
