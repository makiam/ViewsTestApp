/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 27, 2018.
 */
package app;

import app.controller.Controller;

/**
 *
 * @author maksim.khramov
 */
public interface Application {
    public Controller getController();
    public void run(String... args);
}
