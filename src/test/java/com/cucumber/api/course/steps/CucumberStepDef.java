package com.cucumber.api.course.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CucumberStepDef {

    @Given("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
    }

    @When("executar")
    public void executar() {
    }

    @Then("a especificação deve finalizar com sucesso")
    public void a_especificação_deve_finalizar_com_sucesso() {

    }

    private int contador = 0;

    @Given("que o valor do contador é {int}")
    public void queOValorDoContadorE(int arg0) {
        contador = arg0;
    }

    @When("eu incrementar em {int}")
    public void euIncrementarEm(int arg0) {
        contador = contador + arg0;
    }

    @Then("o valor do contador sera {int}")
    public void oValorDoContadorSera(int arg0) throws Throwable {
        System.out.println(arg0);
        System.out.println(contador);
        Assert.assertEquals(arg0, contador);
    }

    Date entrega = new Date();

    @Given("que a entrega eh dia (\\d{2}\\/\\d{2}\\/\\d{4})}")
    public void queAEntregaEhDia(Date data) {
        entrega = data;
    }

    @When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int arg0, String tempo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entrega);
        if (tempo.equals("dias")) {
            calendar.add(Calendar.DAY_OF_MONTH, arg0);
        }
        if (tempo.equals("meses")) {
            calendar.add(Calendar.MONTH, arg0);
        }

        entrega = calendar.getTime();
    }

    @Then("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeraEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

    @Given("^que o ticket é A.(\\d+)$")
    public void queOTicketEAF(int arg0) throws Throwable {
    }

    @Given("que o valor da passagem é R$ {double}")
    public void queOValorDaPassagemER$(int arg0, int arg1) throws Throwable{
    }

    @Given("que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroE(String arg0) throws Throwable{
    }

//    @Given("que o telefone do passageiro é {int}{int}")
//    public void queOTelefoneDoPassageiroE(int arg0, int arg1) throws Throwable{
//    }

    @Given("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroE(String telefone) throws Throwable{
    }

    @Given("criar os steps")
    public void criarOsSteps() throws Throwable{
    }

    @Then("o teste vai funcionar")
    public void oTesteVaiFuncionar() {
    }

    @Given("que o ticket é AB{int}")
    public void queOTicketEAB(int arg0) {
    }

    @Given("^que o ticket (especial)? é (A. \\{3})$")
    public void queOTicketEspecialEAB(String tipo, String arg0) {
    }

    @Given("que o ticket é CD{int}")
    public void queOTicketECD(int arg0) {
    }

    @Given("que o ticket é AG{int}")
    public void queOTicketEAG(int arg0) {
    }

    @Given("que o valor da passagem é R$ {double}{double}")
    public void queOValorDaPassagemER$(int arg0, int arg1, int arg2) {
    }
}