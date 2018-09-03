
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
