package org.canvas.view.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.canvas.controller.Controller;
import org.canvas.model.object.CircleObject;
import org.canvas.model.object.RectangleObject;

public class CanvasMenu extends JMenuBar {

    private final int defaultPosition = 50;
    private final int defaultSize = 100;

    public CanvasMenu(Controller controller) {
        JMenu shapeMenu = new JMenu("Add Shape");
        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(
            e -> controller.createObject(
                new RectangleObject(defaultPosition, defaultPosition, defaultSize, defaultSize)));

        JMenuItem circleItem = new JMenuItem("Circle");
        circleItem.addActionListener(
            e -> controller.createObject(
                new CircleObject(defaultPosition, defaultPosition, defaultSize, defaultSize)));
        shapeMenu.add(rectangleItem);
        shapeMenu.add(circleItem);
        add(shapeMenu);
    }
}
