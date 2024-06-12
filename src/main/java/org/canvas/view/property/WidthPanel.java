package org.canvas.view.property;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.canvas.controller.Controller;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicObject;
import org.canvas.observer.Observer;

public class WidthPanel extends JPanel implements Observer {

    private final JTextField widthField = new JTextField(10);

    private GraphicComposite selectedObject;

    WidthPanel(Controller controller) {
        controller.registerObserver(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        add(new JLabel("Width:"));
        widthField.setEditable(true);

        ActionListener widthListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // canvasPanel에 있는 object를 업데이트
                String inputText = widthField.getText();
                try {
                    int width = Integer.parseInt(inputText); // 입력된 텍스트를 정수로 변환
                    selectedObject.setObjectInfo(selectedObject.getX(), selectedObject.getY(),
                        width, selectedObject.getHeight());
                    controller.updateObject(selectedObject);

                } catch (NumberFormatException ex) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
        };
        widthField.addActionListener(widthListener);

        add(widthField);
    }

    public void updateWidth(int width) {
        widthField.setText(String.valueOf(width));
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicObject> objects) {
//        this.graphicObjects = objects;
//        repaint();
    }


    @Override
    public void updateGraphicObjectsSelected(GraphicComposite objects) {
//        if (!objects.isEmpty()) {
//            this.selectedObject = objects.get(0); // todo multi select 대응
//            updateWidth(selectedObject.getWidth());
//        } else {
//            this.selectedObject = null;
//            updateWidth(0);
//        }
        this.selectedObject = objects; // todo multi select 대응
        updateWidth(selectedObject.getWidth());
    }

}
