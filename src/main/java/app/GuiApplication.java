/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 24, 2018.
 */
package app;

import app.view.MainView;
import java.util.logging.Logger;

/**
 *
 * @author maksim.khramov
 */
public class GuiApplication extends GenericApplication {
    private static final Logger logger = Logger.getLogger(GuiApplication.class.getName());

    @Override
    public void run(String... args) {
        MainView view = new MainView();
    }

    @Override
    public void log(String message) {
        logger.info(message);
    }
    
}
