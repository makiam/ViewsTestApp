
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
class ViewEvent {
    private View view;

    public final View getView() {
        return view;
    }
    
    public ViewEvent(View view) {
        this.view = view;
    }
}
