
package app.view;

import app.actions.Actions;
import app.model.Model;
import app.view.events.ViewClosingEvent;
import app.view.events.ViewChangedEvent;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class MainView extends View {
    private final JFrame source;
    private ScriptingConsoleView console;
    
    @Override
    public Component getSource() {
        return source;
    }
    
    public JFrame getMainFrame() {
        return source;
    }
    
    public MainView() {        
        source = new MainFrame();
    }

    @Override
    public void update() {
        
    }

    @Override
    public void setModel(Model model) {
        super.setModel(model);
        source.setTitle("Model: " + model);
    }

    @Override
    public void activate() {
        source.requestFocus();
    }

    @Override
    public void close() {
        source.dispose();
    }
    
    
    private class MainFrame extends JFrame implements WindowListener {
        
        final KeyStroke escStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0);
        
        private org.greenrobot.eventbus.EventBus bus;
        
        private JToolBar tb;
        private JMenuBar mb;
        
        private JMenu file;
        private JMenu edit;
        private JMenu view;
        private JMenu help;
        private JMenu tools;
        
        
        public MainFrame() {
            super();
        }
        
        @Override
        protected void frameInit() {
            super.frameInit();
            bus = EventBus.getDefault();
            
            this.setTitle("Test");
            this.setSize(800,600);
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            this.addWindowListener(this);
            
            
            tb = new JToolBar(JToolBar.HORIZONTAL);
            tb.setRollover(true);
            
            tb.add(Actions.getNewDocumentAction());
            tb.add(Actions.getOpenAction());
            tb.add(Actions.getCloseAction());
            tb.add(Actions.getCloneAction());
            tb.add(Actions.getShowDocumentsAction());
            
            mb = new JMenuBar();
            file = mb.add(new JMenu("File"));
            file.add(Actions.getNewDocumentAction());
            file.add(Actions.getOpenAction());
            file.addSeparator();
            file.add(Actions.getExitAction());
            
            edit = mb.add(new JMenu("Edit"));
            edit.add(Actions.getCutAction());
            edit.add(Actions.getCopyAction());
            edit.add(Actions.getPasteAction());
            
            view = mb.add(new JMenu("View"));
            view.add(Actions.getCloseAction());
            view.add(Actions.getCloneAction());
            view.add(Actions.getShowDocumentsAction());
            
            tools = mb.add(new JMenu("Tools"));
            tools.add(new AbstractAction("Console") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainView.this.console = new ScriptingConsoleView();
                }

            });
            help = mb.add(new JMenu("Help"));
            help.add(new JSeparator());
            help.add(Actions.getAboutAction());
            this.add(tb);
            this.setJMenuBar(mb);
            
            this.setLocationByPlatform(true);
            this.setVisible(true);
        }

        @Override
        public void dispose() {
            super.dispose();
        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            bus.post(new ViewClosingEvent(MainView.this));
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
            bus.post(new ViewChangedEvent(MainView.this));
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }

    }
    
}
