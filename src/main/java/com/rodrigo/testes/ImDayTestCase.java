package com.rodrigo.testes;

import com.rodrigo.controller.ImDayController;
import com.rodrigo.view.RetornoJsonImDay;
import junit.framework.TestCase;

import java.util.List;

public class ImDayTestCase extends TestCase {
    public void testeFuncional(){
        ImDayController imDayController = new ImDayController();
        List<RetornoJsonImDay> listRetorno = imDayController.listaOrdemResolucao();
        assertEquals(true,listRetorno != null);
        assertEquals(false,listRetorno.isEmpty());
        assertEquals(true,listRetorno.size() == 11);
    }
}
