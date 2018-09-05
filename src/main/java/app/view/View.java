
package app.view;

import app.model.Model;
import java.awt.Component;


/**
 *
 * @author maksim.khramov
 */
public abstract class View {
    
    private Model model;

    public Model getModel() {
        return model;
    }

    public abstract Component getSource();
    
    public void setModel(Model model) {
        this.model = model;
    }
    
    public abstract void activate();
    public abstract void update();
    public abstract void close();
}
