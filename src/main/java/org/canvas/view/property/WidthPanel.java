package org.canvas.view.property;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WidthPanel extends JPanel {

    private final JTextField widthField = new JTextField(10);

    WidthPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        add(new JLabel("Width:"));
        widthField.setEditable(true);
        
        add(widthField);
    }

    public void updateWidth(int width) {
        widthField.setText(String.valueOf(width));
    }

}
