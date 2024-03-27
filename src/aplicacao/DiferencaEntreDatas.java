package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DiferencaEntreDatas {

	public static void main(String[] args) {
				
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


	}

}
