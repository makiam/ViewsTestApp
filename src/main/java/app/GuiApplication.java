
package app;

import app.controller.Controller;
import app.model.Scene;
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
        Controller controller = getController();
        controller.bind(new Scene(), new MainView());
        controller.bind(new Scene(), new MainView());
    }

    @Override
    public void log(String message) {
        logger.info(message);
    }
    
}
