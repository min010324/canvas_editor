package org.canvas.observer;

import java.util.ArrayList;
import org.canvas.model.GraphicInterface;

public interface Observer {

    void updateGraphicObjects(ArrayList<GraphicInterface> objects);

    void updateGraphicObjectsSelected(GraphicInterface objects);
}
