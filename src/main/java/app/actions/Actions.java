
package app.actions;

import app.Launcher;
import app.controller.Controller;
import app.model.Scene;
import app.ui.OptionsDialog;
import app.view.MainView;
import app.view.events.ShowDocumentsEvent;
import app.view.events.ViewClosingEvent;
import app.view.events.ViewModelLoadEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.Getter;

import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class Actions {

    private static final EventBus bus = EventBus.getDefault();

 
    private Actions() {
    }
    
    @Getter
    private static final AbstractAction optionsDialogAction = new AbstractAction("Options") {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFrame owner = (JFrame)Launcher.getApplication().getController().getView().getSource();
            SwingUtilities.invokeLater(() -> { new OptionsDialog(owner, true).setVisible(true); });
        }
            
    };
    @Getter
    private static final AbstractAction cutAction = new AbstractAction("Cut", new ImageIcon(Actions.class.getResource("/icons/cut.png"))) {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        }
        
    };
    
    @Getter
    private static final AbstractAction copyAction = new AbstractAction("Copy", new ImageIcon(Actions.class.getResource("/icons/copy.png"))) {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };
    
    @Getter
    private static final AbstractAction pasteAction = new AbstractAction("Paste", new ImageIcon(Actions.class.getResource("/icons/paste.png"))) {
        @Override
        public void actionPerformed(ActionEvent e) {
        } 
    };
    
    @Getter
    private static final AbstractAction toggleMenuAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JFrame owner = (JFrame)Launcher.getApplication().getController().getView().getSource();
            owner.getJMenuBar().setVisible(!owner.getJMenuBar().isVisible());            
        }
        
    };
    
    @Getter()
    private static final AbstractAction openDocumentAction = new AbstractAction("Open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            bus.post(new ViewModelLoadEvent(Launcher.getApplication().getController().getView()));
        }
        
    };
    
    @Getter
    private static final AbstractAction newDocumentAction = new AbstractAction("New") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller = Launcher.getApplication().getController();
            controller.bind(new Scene(), new MainView());            
        }
        
    };
           
    @Getter
    private static final AbstractAction cloneAction = new AbstractAction("Clone") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller controller = Launcher.getApplication().getController();
            controller.bind(controller.getView().getModel(), new MainView());
        }        
    };
    
    @Getter
    private static final AbstractAction showDocumentsAction = new AbstractAction("Documents...") {
        @Override
        public void actionPerformed(ActionEvent e) {
            bus.post(new ShowDocumentsEvent());
        }
        
    };
    
    @Getter
    private static final AbstractAction aboutAction = new AbstractAction("About") {
        
        @Override
        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        public void actionPerformed(ActionEvent e) {
            final Component owner = Launcher.getApplication().getController().getView().getSource();
            JOptionPane.showMessageDialog(owner, "About");
        }
        
    };
    
    @Getter
    private static final AbstractAction closeAction = new AbstractAction("Close") {
        @Override
        public void actionPerformed(ActionEvent e) {
            bus.post(new ViewClosingEvent(Launcher.getApplication().getController().getView()));            
        }
        
    };
    
    @Getter 
    private static final AbstractAction exitAction = new AbstractAction("Exit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

}
