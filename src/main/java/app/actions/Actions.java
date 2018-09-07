
package app.actions;

import app.Launcher;
import app.controller.Controller;
import app.model.Scene;
import app.view.MainView;
import app.view.events.ShowDocumentsEvent;
import app.view.events.ViewClosingEvent;
import app.view.events.ViewModelLoadEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class Actions {

    private static final EventBus bus = EventBus.getDefault();
    
    private Actions() {
    }
    
    private static final AbstractAction toggleMenuAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFrame owner = (JFrame)Launcher.getApplication().getController().getView().getSource();
            owner.getJMenuBar().setVisible(false);
        }
        
    };

    public static AbstractAction getToggleMenuAction() {
        return toggleMenuAction;
    }
    
    private static final AbstractAction openDocumentAction = new AbstractAction("Open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            bus.post(new ViewModelLoadEvent(Launcher.getApplication().getController().getView()));
        }
        
    };
    
    private static final AbstractAction newDocumentAction = new AbstractAction("New") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller = Launcher.getApplication().getController();
            controller.bind(new Scene(), new MainView());            
        }
        
    };
            
    private static final AbstractAction cloneAction = new AbstractAction("Clone") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller = Launcher.getApplication().getController();
            controller.bind(controller.getView().getModel(), new MainView());
        }        
    };
            
    private static final AbstractAction showDocumentsAction = new AbstractAction("Documents...") {
        @Override
        public void actionPerformed(ActionEvent e) {
            bus.post(new ShowDocumentsEvent());
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
            bus.post(new ViewClosingEvent(Launcher.getApplication().getController().getView()));            
        }
        
    };
            
    private static final AbstractAction exitAction = new AbstractAction("Exit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
          
    public static AbstractAction getNewDocumentAction() {
        return newDocumentAction;
    }
    
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
    
    public static AbstractAction getCloneAction() {
        return cloneAction;
    }
    
    public static AbstractAction getOpenAction() {
        return openDocumentAction;
    }
}
