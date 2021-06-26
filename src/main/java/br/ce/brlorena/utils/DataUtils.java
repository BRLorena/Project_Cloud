package br.ce.brlorena.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public static  Date obterDateWithDifferentDays(int day) {
		//Instanciar o Calendar e apontar p/ data atual
		Calendar calendar = Calendar.getInstance();
		
		//Add  os dias na data inicial pela quantidade de dias passada. Ex: day = 1 amanhã  e -1 ontem
		//Significa 1 dia de diferenca.
		calendar.add(Calendar.DAY_OF_MONTH, day); 
		
		// Retorna uma instancia de Date
		return calendar.getTime();
	}
	
	public static String obterDateFormated(Date  date) {
			//Definir a forma de como sera apresentada a data
			DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
			return format.format(date);
		}
}
