
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public class ViewChangedEvent extends ViewEvent {
    
    public ViewChangedEvent(View view) {
        super(view);
    }
}
