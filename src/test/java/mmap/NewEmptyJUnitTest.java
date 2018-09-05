/*
 * Copyright 2018 Veeam Software.
 * 
 * Created by Maksim Khramov
 * Date: Sep 5, 2018.
 */

package mmap;

import app.model.Model;
import app.view.View;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author maksim.khramov
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    
    @Test
    public void testMMap() {
        Multimap<Model, View> mmap = ArrayListMultimap.create();
        
    }
}