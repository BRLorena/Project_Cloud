package br.ce.brlorena.pages;

import br.ce.brlorena.core.BasePage;

public class MenuPage extends BasePage {

	public void AcessarTelaInserirConta() {
		clickLink("Contas");
		clickLink("Adicionar");
		
	}
	
	public void AcessarTelaListarConta() {
		clickLink("Contas");
		clickLink("Listar");
		
	}
	
	public void AcessarTelaInserirMovimentacao() {
		clickLink("Criar Movimentação");
		
	}
	
	public void AcessarTelaResumo() {
		clickLink("Resumo Mensal");
		
	}
	
	public void acessarTelaPrincipal() {
		clickLink("Home");
	}
	

}
