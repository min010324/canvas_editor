package org.canvas.controller.cursor.state;

import java.awt.event.MouseEvent;

public interface CursorState {

    void mouseClicked(MouseEvent e);

    void mousePressed(MouseEvent e);

    void mouseDragged(MouseEvent e);

}
