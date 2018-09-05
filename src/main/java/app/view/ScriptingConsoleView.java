/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Sep 5, 2018.
 */
package app.view;

import java.awt.Component;
import javax.swing.JFrame;
import app.ui.ScriptingConsole;
import javax.swing.SwingUtilities;

/**
 *
 * @author maksim.khramov
 */
public class ScriptingConsoleView  extends View implements Partial {
    
    private final JFrame source;
    
    @Override
    public Component getSource() {
        return source;
    }

    @Override
    public void activate() {
        
    }

    @Override
    public void update() {
        
    }
    
    public ScriptingConsoleView() {
        source = new ScriptingConsole();            
        SwingUtilities.invokeLater(() -> {
            source.setVisible(true);
        });
    }

    @Override
    public void close() {
        source.dispose();
    }
}
