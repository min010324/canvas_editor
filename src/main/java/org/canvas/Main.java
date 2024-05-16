package org.canvas;

import org.canvas.controller.Controller;
import org.canvas.model.Model;
import org.canvas.view.GraphicEditor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        SwingUtilities.invokeLater(() -> {
            GraphicEditor editor = new GraphicEditor(controller);
            editor.setVisible(true);
        });
    }
}