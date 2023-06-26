package com.cucumber.api.course.steps;

import com.cucumber.api.course.entities.Filme;
import com.cucumber.api.course.entities.NotaAluguel;
import com.cucumber.api.course.enums.TipoAluguel;
import com.cucumber.api.course.services.AluguelService;
import com.cucumber.api.course.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AlugarFilmesStepDef {

    private Filme filme;
    private final AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Dado("um filme com estoque de (\\d+) unidades")
    public void umFilmeComEstoqueDeUnidades(int arg0) {
        filme = new Filme();
        filme.setEstoque(arg0);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(int arg0) {
        filme.setAluguel(arg0);
    }

    @Quando("alugar")
    public void alugar() throws Throwable{
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Então("o preço do aluguel será R$ {int}")
    public void oPrecoDoAluguelSeraR$(int arg0) {
        Assert.assertEquals(arg0, nota.getPreco());
    }

//    @Então("a data de entrega será no dia seguinte")
//    public void aDataDeEntregaSeraNoDiaSeguinte() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//
//        Date dataRetorno = nota.getDataEntrega();
//        Calendar calRetorno = Calendar.getInstance();
//        calRetorno.setTime(dataRetorno);
//
//        Assert.assertEquals(calendar.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
//        Assert.assertEquals(calendar.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
//        Assert.assertEquals(calendar.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
//    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeraUnidade(int arg0) {
        Assert.assertEquals(arg0, filme.getEstoque());
    }

    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL : tipo.equals("extendido")? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Então(("^a data de entrega será em (\\d+) dias?$"))
    public void aDataDeEntregaSeráEmDias(int arg0) throws Throwable {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(arg0);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada),format.format(dataReal));
    }

    @Então("^a pontuação será de (\\d+) pontos$")
    public void aPontuaçãoSeráDePontos(int arg0) throws Throwable {
        Assert.assertEquals(arg0, nota.getPontuacao());
    }


    @Então("o preço do aluguel seja R\\$ (\\d+)$")
    public void oPrecoDoAluguelSejaR$(int arg0) {
        filme.setAluguel(arg0);
    }

    @Dado("um filme")
    public void umFilme(DataTable table) throws Throwable {
        Map<String, String> map = table.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL : tipo.equals("extendido")? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;

    }
}

