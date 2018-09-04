
package app.actions;

import app.Launcher;
import app.view.events.ShowDocumentsEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class Actions {


    
    private Actions() {
    }
    
    private static final AbstractAction showDocumentsAction = new AbstractAction("Documents...") {
        @Override
        public void actionPerformed(ActionEvent e) {
            EventBus.getDefault().post(new ShowDocumentsEvent());
        }
        
    };
    
    private static final AbstractAction aboutAction = new AbstractAction("About") {
        
        @Override
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        public void actionPerformed(ActionEvent e) {
            final Component owner = Launcher.getApplication().getController().getView().getSource();
            JOptionPane.showMessageDialog(owner, "About");
        }
        
    };
            
    private static final AbstractAction closeAction = new AbstractAction("Close") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Close View...");
        }
        
    };
            
    private static final AbstractAction exitAction = new AbstractAction("Exit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
            
    public static AbstractAction getExitAction() {
        return exitAction;
    }

    public static AbstractAction getCloseAction() {
        return closeAction;
    }

    public static AbstractAction getAboutAction() {
        return aboutAction;
    }

    public static final AbstractAction getShowDocumentsAction() {
        return showDocumentsAction;
    }
    
}
