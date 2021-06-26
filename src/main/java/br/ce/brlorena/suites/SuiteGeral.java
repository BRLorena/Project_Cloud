package br.ce.brlorena.suites;

import static br.ce.brlorena.core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.brlorena.pages.LoginPage;
import br.ce.brlorena.tests.ContaTest;
import br.ce.brlorena.tests.MovimentacaoTest;
import br.ce.brlorena.tests.RemoverMovimentacaoContaTest;
import br.ce.brlorena.tests.ResumoTest;
import br.ce.brlorena.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {

	private static LoginPage page  = new LoginPage();
	
	@BeforeClass
	public static void reset() {		
		
		page.acessarTelaInicial();
		page.setEmail("brunomlorena95@gmail.com");
		page.setPassword("99531865");
		page.entrar();
		page.reset();
		
		killDriver();
		
	}
}
