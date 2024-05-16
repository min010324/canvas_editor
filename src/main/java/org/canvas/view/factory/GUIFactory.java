package org.canvas.view.factory;

import javax.swing.JFrame;
import org.canvas.controller.Controller;

public interface GUIFactory {

    void addDefaultLayout(Controller controller, JFrame frame);

}
