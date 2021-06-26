package br.ce.brlorena.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.FIREFOX;
	
	public static TipoExec TIPOEXEC = TipoExec.CLOUD;

	//Define que a conta criada ao final tera um tempo diferente da nova conta criada
//	public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime(); 
	
	
	//Definir quais browser desejamos exec.
	public enum Browsers {
		CHROME,
		FIREFOX,
		IE
	}
	
	public enum TipoExec {
		LOCAL,
		GRID,
		CLOUD
		
	}
}
