package org.canvas.view.menu;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.canvas.controller.Controller;
import org.canvas.model.object.CircleObject;
import org.canvas.model.object.RectangleObject;

public class CanvasMenu extends JMenuBar {

    private final int defaultPosition = 50;
    private final int defaultSize = 100;
    private final Color defaultColor = Color.BLACK;

    public CanvasMenu(Controller controller) {
        JMenu shapeMenu = new JMenu("Add Shape");
        JMenuItem rectangleItem = new JMenuItem("Rectangle");
        rectangleItem.addActionListener(
            e -> controller.createObject(
                new RectangleObject(defaultPosition, defaultPosition, defaultSize, defaultSize,
                    defaultColor)));

        JMenuItem circleItem = new JMenuItem("Circle");
        circleItem.addActionListener(
            e -> controller.createObject(
                new CircleObject(defaultPosition, defaultPosition, defaultSize, defaultSize,
                    defaultColor)));
        shapeMenu.add(rectangleItem);
        shapeMenu.add(circleItem);
        add(shapeMenu);

        JMenu changeOrderMenu = new JMenu("Change Order");
        JMenuItem frontItem = new JMenuItem("Bring to Front");
        frontItem.addActionListener(e -> controller.bringObjectToFront());

        JMenuItem backItem = new JMenuItem("Bring to Back");
        backItem.addActionListener(e -> controller.bringObjectToBack());
        changeOrderMenu.add(frontItem);
        changeOrderMenu.add(backItem);
        add(changeOrderMenu);
    }
}
