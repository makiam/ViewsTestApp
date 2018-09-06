
package app.controller;

import app.model.Model;
import app.ui.DocumentsDialog;
import app.view.View;
import app.view.events.ShowDocumentsEvent;
import app.view.events.ToggleViewEvent;
import app.view.events.ViewChangedEvent;
import app.view.events.ViewClosingEvent;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.SwingUtilities;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 *
 * @author maksim.khramov
 */
public final class Controller {
    
    private View view = null;

    public View getView() {
        return view;
    }
    
    private final Map<Model, List<View>> mv = new HashMap<>();
    private final Multimap<Model, View> mmv = ArrayListMultimap.create();
    
    private final Map<String, Model> nameToModel =  new HashMap<>();
    
    public Controller() {
        init();
    }
    
    private void init() {
        EventBus.getDefault().register(this);
    }
    
    public List<Model> getModels() {
        return mv.keySet().stream().collect(ImmutableList.toImmutableList());
    }
    
    public List<View> getViews(Model model) {
        return mv.getOrDefault(model, new ArrayList<>());
    }
    
    public void add(Model model) {
        mv.putIfAbsent(model, new ArrayList<>());
    }
    
    public void bind(Model model, View view) {   
        view.setModel(model);
        List<View> vv = mv.putIfAbsent(model, new ArrayList<>(Arrays.asList(view)));
        if(null == vv) return;
        vv.add(view);
    }
    
    
    @Subscribe
    public final void onChangeViewEvent(ViewChangedEvent event) {
        EventBus.getDefault().cancelEventDelivery(event);
        view = event.getView();
    }
    
    @Subscribe
    public final void onViewClosingEvent(ViewClosingEvent event) {
        EventBus.getDefault().cancelEventDelivery(event);
        view = event.getView();
        Model model = view.getModel();
        if(mv.containsKey(model)) {
            mv.get(model).remove(view);            
            SwingUtilities.invokeLater(() -> { view.close(); });
        }
    }
    
    @Subscribe
    public final void onShowDocumentsEvent(ShowDocumentsEvent event) {
        EventBus.getDefault().cancelEventDelivery(event);
        SwingUtilities.invokeLater(() -> { new DocumentsDialog((Frame)view.getSource(), true).setVisible(true); });
        
    }
    
    @Subscribe 
    public final void onToggeViewEvent(ToggleViewEvent event) {
        EventBus.getDefault().cancelEventDelivery(event);
        SwingUtilities.invokeLater(() -> { event.getView().activate(); });
    }
}
