
package app.controller;

import app.model.Model;
import app.view.View;
import app.view.events.ViewChangedEvent;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

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
        List<View> vv = mv.putIfAbsent(model, Arrays.asList(view));
        if(null == vv) return;
        vv.add(view);
    }
    
    
    @org.greenrobot.eventbus.Subscribe
    public final void onChangeViewEvent(ViewChangedEvent event) {
        view = event.getView();
        org.greenrobot.eventbus.EventBus.getDefault().cancelEventDelivery(event);
    }
}
