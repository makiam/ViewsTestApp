
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public class ViewModelLoadEvent extends ViewEvent {
    
    public ViewModelLoadEvent(View view) {
        super(view);
    }
}
