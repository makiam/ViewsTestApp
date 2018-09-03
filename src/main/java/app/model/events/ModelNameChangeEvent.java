
package app.model.events;

import app.model.Model;

/**
 *
 * @author maksim.khramov
 */
public class ModelNameChangeEvent extends ModelEvent {
    
    private final String oldValue;
    private final String newValue;
    
    public ModelNameChangeEvent(Model model, String newValue) {
        super(model);
        this.newValue = newValue;
        this.oldValue = model.getName();
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }
    
    
}
