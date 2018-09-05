
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public class ViewClosedEvent extends ViewEvent {
    
    public ViewClosedEvent(View view) {
        super(view);
    }
}
