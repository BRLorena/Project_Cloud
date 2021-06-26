package br.ce.brlorena.pages;

import br.ce.brlorena.core.BasePage;

public class HomePage extends BasePage {

	
	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}
