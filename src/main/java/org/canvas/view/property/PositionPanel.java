package org.canvas.view.property;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.canvas.model.GraphicObject;

public class PositionPanel extends JPanel {

    private final JTextField xField = new JTextField(10);
    private final JTextField yField = new JTextField(10);

    private GraphicObject selectedObject;

    public PositionPanel(GraphicObject selectedObject) {
        this.selectedObject = selectedObject;

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

//        ActionListener listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // canvasPanel에 있는 object를 업데이트
//                controller.updateObject();
//            }
//        };

        add(xPanel, BorderLayout.NORTH);
        add(yPanel, BorderLayout.SOUTH);
    }

    public void updatePosition(int x, int y) {
        xField.setText(String.valueOf(x));
        yField.setText(String.valueOf(y));
    }

}
