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
import org.canvas.model.GraphicInterface;
import org.canvas.observer.Observer;

public class HeightPanel extends JPanel implements Observer {

    private final JTextField heightField = new JTextField(10);
    private GraphicInterface selectedObject;

    public HeightPanel(Controller controller) {
        controller.registerObserver(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        add(new JLabel("Height:"));
        heightField.setEditable(true);

        ActionListener heightListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // canvasPanel에 있는 object를 업데이트
                String inputText = heightField.getText();
                try {
                    int height = Integer.parseInt(inputText); // 입력된 텍스트를 정수로 변환
                    selectedObject.setObjectInfo(selectedObject.getX(), selectedObject.getY(),
                        selectedObject.getWidth(), height);
                    controller.updateObject(selectedObject);

                } catch (NumberFormatException ex) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
        };
        heightField.addActionListener(heightListener);

        add(heightField);
    }

    public void updateHeight(int height) {
        heightField.setText(String.valueOf(height));
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicInterface> objects) {
    }


    @Override
    public void updateGraphicObjectsSelected(GraphicInterface objects) {
        this.selectedObject = objects;
        updateHeight(selectedObject.getHeight());
    }


}
