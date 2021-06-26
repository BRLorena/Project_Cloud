package br.ce.brlorena.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.HomePage;
import br.ce.brlorena.pages.MenuPage;

public class SaldoTest extends BaseTest {

	HomePage page = new HomePage();
	MenuPage menuPage = new MenuPage();
	
	@Test 
	public void testSaldoConta() {
		
		menuPage.acessarTelaPrincipal();
		
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
	
}
