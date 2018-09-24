
package app.view;

import app.model.Library;
import java.awt.Component;
import javax.swing.JFrame;
import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class LibraryView extends View{
    
    private final JFrame source;
    
    public LibraryView(Library model) {
        source = new LibraryViewFrame();
    }
    
    @Override
    public Component getSource() {
        return source;
    }

    @Override
    public void activate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class LibraryViewFrame extends JFrame {
        private org.greenrobot.eventbus.EventBus bus;
        
        @Override
        protected void frameInit() {
            super.frameInit();
            bus = EventBus.getDefault();
        }
        
    }
    
}
