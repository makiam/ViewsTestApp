/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Aug 24, 2018.
 */

package app.controller;

import app.model.Model;
import app.model.Scene;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maksim.khramov
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of getModels method, of class Controller.
     */
    @Test
    public void testGetModels() {

        Controller instance = new Controller();

        List<Model> result = instance.getModels();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test(expected =  java.lang.UnsupportedOperationException.class)
    public void testGetModelsAndModify() {

        Controller instance = new Controller();
        List<Model> result = instance.getModels();
        assertNotNull(result);
        result.add(new Scene());
    }
    
    @Test
    public void testAddModel() {
        Controller instance = new Controller();
        instance.add(new Scene());
        
        List<Model> result = instance.getModels();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}