package br.ce.brlorena.pages;

import static br.ce.brlorena.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.brlorena.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao(String data) {
		write("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		write("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		write("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		write("interessado", interessado);
	}
	
	public void setValor(String valor) {
		write("valor", valor);
	}
	
	public void setConta(String conta) {
		selectCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clickRadio("status_pago");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String getSucessMessage() {
		return obtainTextWithBy(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String getErrorMessage() {
		return obtainTextWithBy(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obtainError() {
		//Escopo da msg de erro -> pega os valores da msg de erro e armazena na lista erros.
		//Para cada erro encontrado dentro da List de webElement add a list de String retorno
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
		
} 
