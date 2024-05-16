package org.canvas.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.canvas.controller.Controller;
import org.canvas.view.factory.GUIFactory;
import org.canvas.view.factory.GraphicEditorFactory;

public class GraphicEditor extends JFrame {

    private static final int EDITOR_WIDTH = 1000;
    private static final int EDITOR_HEIGHT = 800;

    public GraphicEditor(Controller controller) {

        setTitle("Graphic Editor");
        setSize(EDITOR_WIDTH, EDITOR_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GUIFactory factory = new GraphicEditorFactory();
        factory.addDefaultLayout(controller, this);
    }

//    private void addDefaultLayout(Controller controller) {
//        // canvas 설정
//        CanvasPanel canvasPanel = new CanvasPanel(controller);
//        canvasPanel.setBackground(Color.WHITE);
//
//        // 속성 패널 설정
//        PropertyPanel propertyPanel = new PropertyPanel(controller);
//
//        CanvasMenu menuBar = new CanvasMenu(controller);
//        setJMenuBar(menuBar);
//
//        add(canvasPanel, BorderLayout.CENTER);
//        add(propertyPanel, BorderLayout.WEST);
//    }

//    private void updatePropertyPanel() {
//        propertyPanel.removeAll();
//        if (selectedObject != null) {
//            // 선택된 객체의 속성을 속성 패널에 표시하는 코드 추가
//        }
//        propertyPanel.revalidate();
//        propertyPanel.repaint();
//    }

}



