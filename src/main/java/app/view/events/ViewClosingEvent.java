
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public class ViewClosingEvent extends ViewEvent {
    
    public ViewClosingEvent(View view) {
        super(view);
    }
}
