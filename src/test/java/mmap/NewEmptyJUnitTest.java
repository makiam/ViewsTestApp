

package mmap;

import app.model.Model;
import app.model.Scene;
import app.view.View;
import com.google.common.collect.Multimap;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author maksim.khramov
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    
    @Test
    public void testMMap() {
        Multimap<Model, View> mmap = com.google.common.collect.HashMultimap.create();
        Model scene  = new Scene();
        mmap.put(scene, null);

        Collection<View> views = mmap.get(scene);
        System.out.println(views.size());
        
        views.forEach(System.out::println);
        
    }
}