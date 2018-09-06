package app.collections;


import app.model.Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maksim.khramov
 */
public final class ModelViewCollection {
    
    private final List<Model> models = new ArrayList<>();
    
    public ModelViewCollection() {        
    }
    
    /**
     * Returns the Model element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public Model getModel(int index) {
        Model model;
        try {
            model = models.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ModelNotFoundException();
        }
        return model;
    }
    
    public Model getModel(String name) {
        return null;
    }
}
