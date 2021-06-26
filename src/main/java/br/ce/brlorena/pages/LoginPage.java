package br.ce.brlorena.pages;

import static br.ce.brlorena.core.DriverFactory.getDriver;

import br.ce.brlorena.core.BasePage;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me");
	}
	
	public void setEmail(String email) {
		write("email", email);
	}
	
	public void setPassword(String password) {
	write("senha", password);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
		
	}
	
	public void logar() {
		setEmail("brunomlorena95@gmail.com");
		setPassword("99531865");
		entrar();
	}
	
	public void reset() {
		clickLink("reset");
	}
	
}
