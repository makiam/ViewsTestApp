/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 24, 2018.
 */
package app.view;

import app.model.Model;
import java.awt.Component;


/**
 *
 * @author maksim.khramov
 */
public abstract class View {
    
    private Model model;

    public Model getModel() {
        return model;
    }

    public abstract Component getSource();
    
    public void setModel(Model model) {
        this.model = model;
    }
    
    public abstract void update();
}
