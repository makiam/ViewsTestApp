
package app;

import app.controller.Controller;
import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;

/**
 *
 * @author maksim.khramov
 */
public class ConsoleApplication extends GenericApplication {
    
    private static final Logger logger = Logger.getLogger(ConsoleApplication.class.getName());
    
    private final Console console = System.console();
    
    public ConsoleApplication() {
        super();
    }

    @Override
    public Controller getController() {
        return null;
    }
    
    
    @Override
    public void run(String... args) {
        while(true) {
            System.out.print(":");
            String code = console.readLine();
            try {
                engine.eval("import app.model.*;" + "\n" + code);
            } catch (ScriptException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void exit() {
        System.exit(0);
    }
    
}
