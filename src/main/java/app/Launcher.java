package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Launcher {
    private static final Logger logger = Logger.getLogger(Launcher.class.getName());    
    
    private static Application app;

    public static Application getApplication() {
        return app;
    }
    
    static {
        
        logger.log(Level.INFO, "Initiating shutdown hook...");        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {logger.log(Level.INFO, "Shutdown..."); }, "Shutdown thread"));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException {
        Thread.setDefaultUncaughtExceptionHandler(eh);
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        
        
        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        app = new GuiApplication();
        app.run(args);
    }
    
    static Thread.UncaughtExceptionHandler eh = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
            //System.out.println("Execution Exception " + e + " catched from: " + t);
        }
    };
}
