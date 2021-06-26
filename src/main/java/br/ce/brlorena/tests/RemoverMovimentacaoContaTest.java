package br.ce.brlorena.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.ContasPage;
import br.ce.brlorena.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.AcessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.getErrorMessage());
	}
}
