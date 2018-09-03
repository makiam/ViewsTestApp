
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public class ViewChangedEvent {
    private final View view;

    public View getView() {
        return view;
    }
    
    public ViewChangedEvent(View view) {
        this.view = view;
    }
}
