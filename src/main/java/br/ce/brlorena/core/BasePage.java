package br.ce.brlorena.core;

import static br.ce.brlorena.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/******** TextField e TextArea ************/

	//Escrever nos campos de texto
	public void writeBy(By by, String text) {
		getDriver().findElement(by).clear(); //limpar os campos
		getDriver().findElement(by).sendKeys(text);
	}
	
	//Escrever sem o By
	public void write(String id_field, String texto){
		writeBy(By.id(id_field), texto);
	}
	
	//Obter valor dos campos de texto
	public String obtainValueField(String id_field) {
		return getDriver().findElement(By.id(id_field)).getAttribute("value");
		
	}
	
	/********* Radio e Check ************/
	
	//clicar Radio button
	public void clickRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickRadio(String id_field) {
		clickRadio(By.id(id_field));
	}
	
	//click no radio e verifica se é true or false. 
	public boolean isRadioClicked(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	//Verificar os click's
	public void clickCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckClicked(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	//Selecionar opção comboBox
	public void selectCombo(String id, String value) {
		WebElement element = getDriver().findElement(By.id(id)); //Cria class WebElement que recebe info. da combo
		Select combo = new Select(element); //buca um elemento da comboBox
		combo.selectByVisibleText(value); //Filtra pelo valor que esta visível.. Oq o usuario vê
	}
	
	//Deselecionar o combo
	public void dismissCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	//Obter valor selecionado na comboBox, return uma String
	public String obtainValueCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id)); //Cria class WebElement que recebe info. da combo
		Select combo = new Select(element); //buca um elemento da comboBox
		return combo.getFirstSelectedOption().getText();//Verificar qual o valor selecionado

	}
	
	//Obter os valores do combo (Lista de opções e dps um for P/ correr a combo e obter valores.
	public List<String> valuesOfCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id)); //armazena o valor informado em element
		Select combo = new Select(element); //Instancia o Select p/ pegar um elemento do combo
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions(); //Pega todas as opções do combo e armazsena em allSelectedOptions
		List<String> value = new ArrayList<String>(); //Cria uma list de Strings (Array) e armazena em value
		
		for(WebElement option: allSelectedOptions) { //For in -> Percorre cada opção dentro de allSeelctedOptions
			value.add(option.getText()); // com a variavel value adiciona há uma opção de todas opções e recupera este valor com getText()
		}
		return value; //Return o value encontrado p/ ver se existe o value no comboBox
	}
	
	//Obter a quantidade de itens no combo
	public int quantityItemCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	//Verificar as opções do combo.. corre o combo todo com um for e dps um SE p/ comparar o valor selecionado com as opções do combo
	public boolean checkOptionsCombo(String id, String opcao){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	public void selectComboPrime(String radical, String value) {
		clickRadio(By.xpath("//*[@id='"+radical+":option_input']/../..//span")); //clicar no span P/ abrir a combo
		clickRadio(By.xpath("//li[@id='"+radical+":"+value+"']")); //clicar no item desejado da combo
	}
	
	/********* Botao ************/
	
	//Clicar botões
	public void clickButton(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clickButton(String id) {
		clickButton(By.id(id));
	}
	
	public void clicarBotaoPorTexto(String text) {
		clickButton(By.xpath("//button[.='"+text+"']"));
	}
	//Obter valor de um elemento
	public String getValueElement(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	//Clicar link
	public void clickLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	//Obter texto pelo BY.. ex: tagName, className e etc
	public String obtainTextWithBy(By by) {
		return getDriver().findElement(by).getText();
	}
	
		
		public String obtainText(String id) {
			return obtainTextWithBy(By.id(id));
		}
		
		/********* Alerts ************/
		
	//Obter text Alert
		public String alertObtainText(){
			Alert alert = getDriver().switchTo().alert(); //mudar a pag. P/ o alert
			return alert.getText();
		}
		
		//Obter texto clicando num botão aceito
		public String alertObtainTextRight(){
			Alert alert = getDriver().switchTo().alert();
			String value = alert.getText();
			alert.accept();
			return value;
			
		}
		
		//Obter texto clicando negativo
		public String alertObtainTextDeny(){
			Alert alert = getDriver().switchTo().alert();
			String value = alert.getText();
			alert.dismiss();
			return value;
			
		}
		
		//Enviar valores num alert, tipo prompt
		public void alertWrite(String value) {
			Alert alert = getDriver().switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		}
		
		/********* Frames e Janelas ************/
		
		//Entrar no frame
		public void enterFrame(String id) {
			getDriver().switchTo().frame(id);
		}
		
		//Sair do frame
		public void leaveFrame(){
			getDriver().switchTo().defaultContent();
		}
		
		public void changeWindow(String id) {
			getDriver().switchTo().window(id);
		}
		
		/************************ JS **************/
		
		//Metodo que vai receber um cmd -> comando e quantos parametros eu quiser do tipo Object
		public Object executeJs(String cmd, Object... param ) {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			return js.executeScript(cmd,param);
		}
		
		/************************ Tabela usando Xpath **************/
		
		public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
			//Procurar coluna do registro 
			WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
			int idColuna = obterIndiceColuna(colunaBusca, tabela);
			
			//encontrar a linha do registro
			int idLinha = obterIndiceLinha(valor, tabela, idColuna);
			
			//procurar coluna do botao
			int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
			
			//clicar no botao da celula encontrada
			WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
			 return celula; //clicar no botão relacionado com a coluna e a linha desejada, desce direto P/ o valor do botão
			
		}
		
		public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
			
			
			//clicar no botao da celula encontrada
			WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
			celula.findElement(By.xpath(".//input")).click(); //clicar no botão relacionado com a coluna e a linha desejada, desce direto P/ o valor do botão
			
		}
		
		// .//*[@id='elementosForm:tableUsuarios']//tr/td[1] -> xpath para linha coluna 1
		protected int  obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
			List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]")); //Xpath dinâmico, ele vai encontrar a linha referente a coluna que eu desejo encontrar no momento
			int idLinha = -1; //Armazenar o valor encontrado em colunaBusca, é -1 pois se encontrar algo sera i+1 = 1
			for(int i = 0; i < linhas.size(); i++) { //Varrer as linhas da coluna P/ ver onde esta o titulo que desejo
				if(linhas.get(i).getText().equals(valor)) { //Se o valor encontrado na linha for igual ao valor passado (argumento)
					idLinha = i+1; //Encontrado o valor
					break;
				}
			}
			return idLinha;
		}

		protected int obterIndiceColuna(String coluna, WebElement tabela) {
			List<WebElement> colunas = tabela.findElements(By.xpath(".//th")); // encontra lista de todas as colunas
			int idColuna = -1; //Armazenar o valor encontrado em colunaBusca, é -1 pois se encontrar algo sera i+1 = 1
			for(int i = 0; i < colunas.size(); i++) { //Varrer a coluna P/ ver onde esta o titulo que desejo
				if(colunas.get(i).getText().equals(coluna)) { //Se o valor encontrado na coluna for igual ao titulo passado na busca
					idColuna = i+1; //Encontrado o valor
					break;
				}
			}
			return idColuna; //retorna o valor encontrado
		}
}
