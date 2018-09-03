
package scripting;

import app.ConsoleApplication;
import app.GenericApplication;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author maksim.khramov
 */
public class ScriptingTest {

    private static GenericApplication app;

    @BeforeClass
    public static void setUpClass() {
        app = new ConsoleApplication();
    }

    
    @Test(expected = NullPointerException.class)
    public void testScripting() {
        app.run((String[]) null);
    }
}