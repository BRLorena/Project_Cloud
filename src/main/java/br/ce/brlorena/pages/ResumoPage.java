package br.ce.brlorena.pages;

import org.openqa.selenium.By;

import br.ce.brlorena.core.BasePage;

public class ResumoPage extends BasePage {
	
	//Clica no primeiro item P/ excluir
	public void excluirMovimentacao() { 
		clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String getSucessMessage() {
		return obtainTextWithBy(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void selectYear(String year) {
		selectCombo("ano", year);
	}
	
	public void buscar() {
		clickButton(By.xpath("//input[@value='Buscar']"));
	}
}
