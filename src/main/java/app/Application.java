
package app;

import app.controller.Controller;
import javax.script.ScriptEngine;

/**
 *
 * @author maksim.khramov
 */
public interface Application {
    
    public ScriptEngine getEngine();
    public Controller getController();
    public void run(String... args);
}
