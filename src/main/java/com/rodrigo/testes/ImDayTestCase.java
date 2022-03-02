package com.rodrigo.testes;

import com.rodrigo.controller.ImDayController;
import junit.framework.TestCase;

import java.util.Date;
import java.util.Map;

public class ImDayTestCase extends TestCase {
    public void testeFuncional(){
        ImDayController imDayController = new ImDayController();
        Map<Date,String> mapSequenciaSup = imDayController.listaOrdemResolucao();
        assertEquals(true,mapSequenciaSup != null);
        assertEquals(false,mapSequenciaSup.isEmpty());
        assertEquals(true,mapSequenciaSup.size() == 11);
    }
}
