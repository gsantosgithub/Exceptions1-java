package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;

public class ReservaPrograma {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reserva reserva;
		
		System.out.print("Número do quarto: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Data check-in: ");
		LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
		System.out.print("Data check-out: ");
		LocalDate checkOut = LocalDate.parse(sc.next(), dtf);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Erro na reserva: Data do check-out tem que ser"
					+ " posterior à data do check-in");
		}else {
			reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data check-in: ");
			checkIn = LocalDate.parse(sc.next(), dtf);
			System.out.print("Data check-out: ");
			checkOut = LocalDate.parse(sc.next(), dtf);
			reserva.AtualizarDatas(checkIn, checkOut);
			
			LocalDate hoje = LocalDate.now();
			if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) {
				System.out.println("Erro na reserva: Datas precisam ser datas futuras");
			}else if(!checkOut.isAfter(checkIn)){
				System.out.println("Erro na reserva: Data do check-out tem que ser"
						+ " posterior à data do check-in");
			}else {
				reserva = new Reserva(numero, checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
			
		}
		
		
		
		
		sc.close();

	}

}
