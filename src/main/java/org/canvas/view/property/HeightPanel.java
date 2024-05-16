package org.canvas.view.property;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HeightPanel extends JPanel {

    private final JTextField heightField = new JTextField(10);

    public HeightPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.WHITE);
        add(new JLabel("Height:"));
        heightField.setEditable(true);
        add(heightField);
    }

    public void updateHeight(int height) {
        heightField.setText(String.valueOf(height));
    }

}
