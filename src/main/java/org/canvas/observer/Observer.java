package org.canvas.observer;

import java.util.ArrayList;
import org.canvas.model.GraphicComposite;
import org.canvas.model.GraphicObject;

public interface Observer {

    void updateGraphicObjects(ArrayList<GraphicObject> objects);

    void updateGraphicObjectsSelected(GraphicComposite objects);
}
