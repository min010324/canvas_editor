package org.canvas.view.factory;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import org.canvas.controller.Controller;
import org.canvas.view.canvas.CanvasPanel;
import org.canvas.view.menu.CanvasMenu;
import org.canvas.view.property.PropertyPanel;

public class GraphicEditorFactory implements GUIFactory {

    public void addDefaultLayout(Controller controller, JFrame frame) {
        // canvas 설정
        CanvasPanel canvasPanel = new CanvasPanel(controller);
        canvasPanel.setBackground(Color.WHITE);

        // 속성 패널 설정
        PropertyPanel propertyPanel = new PropertyPanel(controller);

        CanvasMenu menuBar = new CanvasMenu(controller);
        frame.setJMenuBar(menuBar);

        frame.add(canvasPanel, BorderLayout.CENTER);
        frame.add(propertyPanel, BorderLayout.WEST);
    }
}
