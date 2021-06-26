package br.ce.brlorena.pages;

import org.openqa.selenium.By;

import br.ce.brlorena.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		write("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String getSucessMessage() {
		return obtainTextWithBy(By.xpath("//div[@class='alert alert-success']"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas") //Encontra a celula para clicar
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();// Define em qual botao ira clicar = edit	
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas") //Encontra a celula para clicar
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();// Define em qual botao ira clicar = edit	
	}
	
	//
	
	public String getErrorMessage() {
		return obtainTextWithBy(By.xpath("//div[@class='alert alert-danger']"));
	}
	
}
