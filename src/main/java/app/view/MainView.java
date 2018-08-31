/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 24, 2018.
 */
package app.view;

import app.actions.Actions;
import app.view.events.ViewChangedEvent;
import java.awt.Component;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;
import org.greenrobot.eventbus.EventBus;

/**
 *
 * @author maksim.khramov
 */
public class MainView extends View {
    private final JFrame mainFrame;

    public Component getSource() {
        return mainFrame;
    }
    
    public JFrame getMainFrame() {
        return mainFrame;
    }
    
    public MainView() {        
        mainFrame = new MainFrame();
    }

    @Override
    public void update() {
        
    }
    
    
    private class MainFrame extends JFrame implements WindowListener, WindowFocusListener {
        
        private org.greenrobot.eventbus.EventBus bus;
        
        private JMenuBar mb;
        
        private JMenu file;
        private JMenu view;
        private JMenu help;
        
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
            this.addWindowFocusListener(this);
            
            mb = new JMenuBar();
            file = mb.add(new JMenu("File"));
            file.addSeparator();
            file.add(Actions.getExitAction());
            
            
            view = mb.add(new JMenu("View"));
            view.add(Actions.getCloseAction());
            view.add(Actions.getShowDocumentsAction());
            
            help = mb.add(new JMenu("Help"));
            help.add(new JSeparator());
            help.add(Actions.getAboutAction());
            
            this.setJMenuBar(mb);
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
            this.dispose();
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
            
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }

        @Override
        public void windowGainedFocus(WindowEvent e) {
            bus.post(new ViewChangedEvent(MainView.this));
        }

        @Override
        public void windowLostFocus(WindowEvent e) {
        }
        
        
        
    }
    
}
