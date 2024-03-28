package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class ReservaPrograma {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reserva reserva;
		
		try {
			System.out.print("Número do quarto: ");
			int numero = sc.nextInt();
			sc.nextLine();
			System.out.print("Data check-in: ");
			LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Data check-out: ");
			LocalDate checkOut = LocalDate.parse(sc.next(), dtf);
			
			
			reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data check-in: ");
			checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Data check-out: ");
			checkOut = LocalDate.parse(sc.next(), dtf);
			
			reserva.AtualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		//catch(IllegalArgumentException e) {
		//	System.out.println("Erro na reserva: " + e.getMessage());
		//}
		// trocando para exceção personalizada
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro não esperado:");
			System.out.println(e.getClass());
		}
		sc.close();
	}
}
