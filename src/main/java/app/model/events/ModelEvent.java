/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 31, 2018.
 */
package app.model.events;

import app.model.Model;
import java.util.Date;

/**
 *
 * @author maksim.khramov
 */
public class ModelEvent {
    protected Model model;
    
    protected Date timestamp = new Date();

    public Date getTimestamp() {
        return timestamp;
    }
    
    public ModelEvent(Model model) {
        this.model = model;
    }
}
