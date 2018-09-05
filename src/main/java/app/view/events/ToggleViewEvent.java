/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Sep 5, 2018.
 */
package app.view.events;

import app.view.View;

/**
 *
 * @author maksim.khramov
 */
public final class ToggleViewEvent {
    private final View view;

    public View getView() {
        return view;
    }
    
    public ToggleViewEvent(View view) {
        this.view = view;
    }
}
