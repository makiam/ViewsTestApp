
package app.model;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

/**
 *
 * @author maksim.khramov
 */
public abstract class Model extends AXObject {
    
    protected Boolean dirty = false;

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    protected String name;
    protected String description;
    
    protected transient Optional<Path> path = Optional.empty();
    
//    public Model(File source) {
//        this.path = Optional.of(source.toPath());
//    }
}
