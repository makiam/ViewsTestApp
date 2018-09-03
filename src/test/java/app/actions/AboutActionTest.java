

package app.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author maksim.khramov
 */
public class AboutActionTest {

    public AboutActionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of actionPerformed method, of class AboutAction.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        AbstractAction instance = Actions.getAboutAction();
        instance.actionPerformed(e);

    }

}