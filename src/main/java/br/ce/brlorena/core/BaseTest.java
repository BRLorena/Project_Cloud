package br.ce.brlorena.core;

import static br.ce.brlorena.core.DriverFactory.getDriver;
import static br.ce.brlorena.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.brlorena.pages.LoginPage;

public class BaseTest {
	
	@Rule //Rule do JUnit
	public TestName testName = new TestName(); // Pega o nome do Test executado

	private LoginPage page = new LoginPage();
	
	@Before
	public void initialize() {
		
		page.acessarTelaInicial();
		page.setEmail("brunomlorena95@gmail.com");
		page.setPassword("99531865");
		page.entrar();
		
	}
	
	@After
	public void quitSession() throws IOException {
		//Pegar um screenshot
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+File.separator+"screenshot" //Primeiro o arquivo q vou pegar e dps onde armazenar
				+File.separator+ testName.getMethodName() +".jpg")); //File.separator -> da class Java.IO utilizado para definir q tipo de / usar.
		if(Propriedades.FECHAR_BROWSER) { 
			killDriver();
		}

	}
}
