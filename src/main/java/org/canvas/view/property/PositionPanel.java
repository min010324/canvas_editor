package org.canvas.view.property;

import static org.canvas.model.Model.gson;

import java.awt.BorderLayout;
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

public class PositionPanel extends JPanel implements Observer {

    private final JTextField xField = new JTextField(10);
    private final JTextField yField = new JTextField(10);

    private GraphicInterface selectedObject;

    public PositionPanel(Controller controller) {
        controller.registerObserver(this);

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel xPanel = new JPanel();
        xPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        xPanel.add(new JLabel("X Position:"));
        xField.setEditable(true);
        xPanel.add(xField);

        JPanel yPanel = new JPanel();
        yPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        yPanel.add(new JLabel("Y Position:"));
        yField.setEditable(true);
        yPanel.add(yField);

        ActionListener xListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // canvasPanel에 있는 object를 업데이트
                String inputText = xField.getText();
                try {
                    int xPos = Integer.parseInt(inputText); // 입력된 텍스트를 정수로 변환
                    System.out.println("입력된 숫자: " + gson.toJson(selectedObject.getID()));
                    System.out.println("입력된 숫자: " + xPos);

                    selectedObject.setObjectInfo(xPos, selectedObject.getY(),
                        selectedObject.getWidth(), selectedObject.getHeight());
                    controller.updateObject(selectedObject);

                } catch (NumberFormatException ex) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
        };
        xField.addActionListener(xListener);

        ActionListener yListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // canvasPanel에 있는 object를 업데이트
                String inputText = yField.getText();
                try {
                    int yPos = Integer.parseInt(inputText); // 입력된 텍스트를 정수로 변환
                    selectedObject.setObjectInfo(selectedObject.getX(), yPos,
                        selectedObject.getWidth(), selectedObject.getHeight());
                    controller.updateObject(selectedObject);

                } catch (NumberFormatException ex) {
                    System.out.println("숫자를 입력하세요.");
                }
            }
        };
        yField.addActionListener(yListener);

        add(xPanel, BorderLayout.NORTH);
        add(yPanel, BorderLayout.SOUTH);
    }

    public void updatePosition(int x, int y) {
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
    }

    @Override
    public void updateGraphicObjects(ArrayList<GraphicInterface> objects) {

    }


    @Override
    public void updateGraphicObjectsSelected(GraphicInterface objects) {
        this.selectedObject = objects;
        updatePosition(selectedObject.getX(), selectedObject.getY());
    }

}
