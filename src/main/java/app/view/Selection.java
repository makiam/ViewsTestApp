
package app.view;

import app.model.AXList;
import app.model.AXObject;

/**
 *
 * @author maksim.khramov
 */
public interface Selection {
    public AXList getSelection();
    
    public void setSelection(AXList selection);
    
    public void add(AXObject item);
    public void remove(AXObject item);
    
}
