package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DiferencaEntreDatas {

	public static void main(String[] args) throws ParseException {
				
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Data1: ");
		LocalDate d01 = LocalDate.parse(sc.next(), dtf1);
		System.out.print("Data2: ");
		LocalDate d02 = LocalDate.parse(sc.next(), dtf1);
		
		 // Calcula a diferen�a de dias entre as duas datas
        long diferencaEmDias = ChronoUnit.DAYS.between(d01, d02);
        // Calcula a diferen�a de meses entre as duas datas
        long diferencaEmMes = ChronoUnit.MONTHS.between(d01, d02);
        // Calcula a diferen�a de anos entre as duas datas
        long diferencaEmAnos = ChronoUnit.YEARS.between(d01, d02);
        
        // Exibe a diferen�a em dias entre as datas
        System.out.println("Diferen�a em dias entre " + d01 + " e " + d02 + " = " + diferencaEmDias);
        // Exibe a diferen�a em meses entre as datas
        System.out.println("Diferen�a em meses entre " + d01 + " e " + d02 + " = " + diferencaEmMes);
        // Exibe a diferen�a em anos entre as datas
        System.out.println("Diferen�a em anos entre " + d01 + " e " + d02 + " = " + diferencaEmAnos);
		
				
		sc.close();

		//**********************************
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d03 = sdf.parse("03/08/1962");
		Date d04 = sdf.parse("25/03/2024");
		
		long diff = d04.getTime() - d03.getTime();
	    long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    System.out.println("N�mero de dias: " + dias);
	    
	  //**********************************
	    
	    Date d = new Date();

	    Calendar cal = Calendar.getInstance();
	    cal.setTime(d);
	    d = cal.getTime();
	    System.out.println(sdf.format(d));
	}

}
