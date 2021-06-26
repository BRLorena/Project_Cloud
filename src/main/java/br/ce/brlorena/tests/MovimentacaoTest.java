package br.ce.brlorena.tests;

import static br.ce.brlorena.utils.DataUtils.obterDateFormated;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.brlorena.core.BaseTest;
import br.ce.brlorena.pages.MenuPage;
import br.ce.brlorena.pages.MovimentacaoPage;
import br.ce.brlorena.utils.DataUtils;


//Definir a ordem de forma alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();

	@Test
	public void test1InserirMovimentacao(){
		menuPage.AcessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDateFormated(new Date()));
		movPage.setDataPagamento(obterDateFormated(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.getSucessMessage());
	}
	
	@Test @Ignore 
	public void test2CamposObrigatorios(){
		menuPage.AcessarTelaInserirMovimentacao();
		movPage.salvar();
		
		List<String> erros = movPage.obtainError();

		Assert.assertTrue(erros.containsAll(Arrays.asList(
			"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
			Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3InserirMovimentacaoFutura(){
		menuPage.AcessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDateWithDifferentDays(5);
		
		movPage.setDataMovimentacao(obterDateFormated(dataFutura));
		movPage.setDataPagamento(obterDateFormated(dataFutura));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obtainError();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
}
