
package app;

import app.controller.Controller;
import app.model.Model;
import app.model.Scene;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;

/**
 *
 * @author maksim.khramov
 */
public abstract class GenericApplication implements Application {
    
    protected ScriptEngine engine;

    @Override
    public ScriptEngine getEngine() {
        return engine;
    }
    
    private final Controller controller = new Controller();

    @Override
    public Controller getController() {
        return controller;
    }
    
    
    public List<Model> getModels() {
        return controller.getModels();
    }
    
    public Model open(String path) {
        Path modelPath = Paths.get(path);
        Model model = new Scene(modelPath);
        controller.add(model);
        return model;
    }
    
    
    public void add(Model model) {
        System.out.println("do add model");
        controller.add(model);
    }
    
    public GenericApplication() {
        engine = new javax.script.ScriptEngineManager().getEngineByName("groovy");        
        init();
    }
    private void init() {
        Bindings bind = engine.getBindings(ScriptContext.GLOBAL_SCOPE);
        bind.put("app", this);
    }
    
    public void log(String message) {
        System.out.println(message);
    }
    
    @Override
    public abstract void run(String... args);
    
}
