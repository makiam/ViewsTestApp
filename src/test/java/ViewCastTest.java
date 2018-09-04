
import app.view.MainView;
import app.view.View;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maksim.khramov
 */
public class ViewCastTest {

    public ViewCastTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void castTest() {
        final Object ct = new MainView();
        System.out.println("Item is: " + ct);
        System.out.println("ct instanceof MainView: " + (ct instanceof MainView));
        System.out.println("ct instanceof View: " + (ct instanceof View));
        assertTrue(ct instanceof View);
    }
}