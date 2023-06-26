package com.cucumber.api.course.steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasStepDef {

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAplicacao() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");

    }

    @Quando("informo o usuário {string}")
    public void informoOUsuario(String arg0) {
        driver.findElement(By.id("email")).sendKeys(arg0);
    }

    @E("a senha {string}")
    public void aSenha(String arg0) {
        driver.findElement(By.name("senha")).sendKeys(arg0);
    }

    @E("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPaginaInicial() {
       String texto = driver.findElement(By.xpath("//div[@class='alert-success']")).getText();
       Assert.assertEquals("Bem-vindo, wagner!", texto);
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @E("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @E("informo a conta {string}")
    public void informoAConta(String arg0) {
        driver.findElement(By.id("nome")).sendKeys(arg0);
    }

    @E("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaEInseridaComSucesso() {
        String texto = driver.findElement(By.xpath("//div[@class='alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }
}
