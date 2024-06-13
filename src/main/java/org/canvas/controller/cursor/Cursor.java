package org.canvas.controller.cursor;

import java.awt.event.MouseEvent;
import org.canvas.controller.cursor.state.CursorState;
import org.canvas.controller.cursor.state.DefaultCursorState;
import org.canvas.model.Model;

public class Cursor {

    private CursorState cursorState;

    public Cursor(Model model) {
        this.cursorState = new DefaultCursorState(model);
    }

    public void setCursorState(CursorState state) {
        this.cursorState = state;
    }

    public void mouseClicked(MouseEvent e) {
        cursorState.mouseClicked(e);
    }

    public void mousePressed(MouseEvent e) {
        cursorState.mousePressed(e);
    }

    public void mouseDragged(MouseEvent e) {
        cursorState.mouseDragged(e);
    }


}
