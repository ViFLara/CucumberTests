package com.cucumber.api.course.services;

import com.cucumber.api.course.entities.Filme;
import com.cucumber.api.course.entities.NotaAluguel;
import com.cucumber.api.course.enums.TipoAluguel;
import com.cucumber.api.course.utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
        if(filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        switch (tipoAluguel) {
            case COMUM:
                nota.setPreco(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
                nota.setPontuacao(1);
            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
                nota.setPontuacao(2);
            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
                nota.setPontuacao(3);
        }

        nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
