
package app.model.events;

import app.model.Model;

/**
 *
 * @author maksim.khramov
 */
public class SelectionChangedEvent extends ModelEvent {
    
    public SelectionChangedEvent(Model model) {
        super(model);
    }
    
}
