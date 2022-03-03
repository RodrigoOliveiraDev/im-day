package com.rodrigo.controller;

import com.rodrigo.model.Suporte;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@Api(value="API im-day")
@RestController
public class ImDayController {

    @ApiOperation(value = "Retorna json ordenado com a ordem de suportes e a data que ele irá atender")
    @RequestMapping("/im-day")
    public Map<Date, String>  listaOrdemResolucao() {
        //será retornado maps para que possa ser tratado a visualização no front-end
        Map<Date, String> mapSequenciaSup = obterSequenciaSuporte();
        return mapSequenciaSup;
    }

    @ApiOperation(value = "Organiza a lista de suportes baseado na ordem definida")
    private Map<Date,String> obterSequenciaSuporte(){
        Map<Date,String> mapSequenciaSup = new TreeMap<Date,String>();
        List<Suporte> suportes = preencheSuportes();
        Calendar dataAtual = Calendar.getInstance();
        dataAtual.add(Calendar.DAY_OF_MONTH,-1);
        int diaSemana;
        //
        mapSequenciaSup.put(dataAtual.getTime(),suportes.get(8).getNome());
        for (int i=0;i<10;i++){//fixo porém com persistencia no banco isso poderia ser variavel
            dataAtual.add(Calendar.DAY_OF_MONTH,1);
            int ordem = i > 8  ? i-9 : i;//para "reiniciar" a sequencia e não estourar a lista não funciona muito bem se houvesse mais suportes
            diaSemana = dataAtual.get(Calendar.DAY_OF_WEEK);
            if (diaSemana == 1 || diaSemana == 7) {//verifica se sera domingo ou sabado
                mapSequenciaSup.put(dataAtual.getTime(), "Sem atendimento");
            } else {
                mapSequenciaSup.put(dataAtual.getTime(), suportes.get(ordem).getNome());
            }
        }
        return mapSequenciaSup;
    }

    @ApiOperation(value = "Preenche a lista de suportes fixos")
    private List<Suporte> preencheSuportes() {
        List<Suporte> suportes = new ArrayList<>();
        for(int i=0;i<9;i++){
            Suporte suporte = new Suporte();
            suporte.setNome(getNome(i));
            suporte.setOrdem(i);
            suportes.add(suporte);
        }
        return suportes;
    }

    @ApiOperation(value = "Retorna o Nome de cada suporte baseado na ordem definida na descrição do teste")
    private String getNome(int ordem){
        switch (ordem){
            case 0:
                return "João";
            case 1:
                return "Maria";
            case 2:
                return "Zeca";
            case 3:
                return "Mario";
            case 4:
                return "Gustavo";
            case 5:
                return "Camila";
            case 6:
                return "Pedro";
            case 7:
                return "Juliana";
            case 8:
                return "Gisele";
        }
        return "Não encontrado";
    }
}