
package app.model.events;

import app.model.Model;

/**
 *
 * @author maksim.khramov
 */
public class ModelLoadEvent extends ModelEvent {
    
    public ModelLoadEvent(Model model) {
        super(model);
    }
}
