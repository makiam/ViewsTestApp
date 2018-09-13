
package app.model;

import java.nio.file.Path;
import java.util.Optional;

/**
 *
 * @author maksim.khramov
 */
public class Scene extends Library {
    private static int sid = 0;
    public Scene() {
        super();
        this.name = "Scene";
    }
    
    public Scene(Path source) {
        this();
        this.path = Optional.of(source);
    }
}
