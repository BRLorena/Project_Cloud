package br.ce.brlorena.tests;

import static br.ce.brlorena.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.MenuPage;
import br.ce.brlorena.pages.ResumoPage;

//Definir a ordem de forma alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

	 MenuPage menuPage = new MenuPage();
	ResumoPage resPage = new ResumoPage();
	
	
	@Test 
	public void test1ExcluirMovimentacao() {
		
		menuPage.AcessarTelaResumo();
		resPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resPage.getSucessMessage());
	} 
	
			//Definir oq é esperado 
	@Test //(expected = NoSuchElementException.class)
	public void test2testResumoMensal() {
		menuPage.AcessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resPage.selectYear("2016");
		resPage.buscar();
		
		//Add List WebElement elementosEncontrados P/ procurar por um item.
		List<WebElement> elementosEncontrados =
				getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
	}
	
	
}
