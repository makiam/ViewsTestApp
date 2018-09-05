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

/**
 *
 * @author maksim.khramov
 */
public class ScriptingConsoleView  extends View {
    
    private final JFrame source;
    
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
    
    public ScriptingConsoleView() {
        source = new ScriptingConsole();
    }
}
