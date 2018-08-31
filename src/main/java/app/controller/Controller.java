/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 24, 2018.
 */
package app.controller;

import app.model.Model;
import app.view.View;
import app.view.events.ViewChangedEvent;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
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
        System.out.println("add model to controller");
        mv.putIfAbsent(model, new ArrayList<>());
    }
    
    @org.greenrobot.eventbus.Subscribe
    public final void onChangeViewEvent(ViewChangedEvent event) {
        System.out.println("Recieve: " + event);
        view = event.getView();
        org.greenrobot.eventbus.EventBus.getDefault().cancelEventDelivery(event);
    }
}
