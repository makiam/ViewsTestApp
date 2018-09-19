
package app.view;

import app.model.events.SelectionChangedEvent;

/**
 *
 * @author maksim.khramov
 */
public interface SelectionChangeListener {
    
    public void onSelectionChangeEvent(SelectionChangedEvent event);
}
