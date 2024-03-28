package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reserva() {
	}
	public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if(!checkOut.isAfter(checkIn)){
			throw new DomainException( "Erro na reserva: Data do check-out tem que ser"
					+ " posterior à data do check-in");
		}
		LocalDate hoje = LocalDate.now();
		if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) {
			throw new DomainException("Erro na reserva: Datas precisam ser datas futuras");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public Long Duracao() {
		long diferencaEmDias = ChronoUnit.DAYS.between(checkIn, checkOut);
		return diferencaEmDias;
	}
	public void AtualizarDatas(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		LocalDate hoje = LocalDate.now();
		if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) {
			//throw new IllegalArgumentException("Erro na reserva: Datas precisam ser datas futuras") ;
			// alterando para uma exceção personalizada
			throw new DomainException("Erro na reserva: Datas precisam ser datas futuras");
		}
		if(!checkOut.isAfter(checkIn)){
			//throw new IllegalArgumentException( "Erro na reserva: Data do check-out tem que ser"
			//		+ " posterior à data do check-in");
			// alterando para uma exceção personalizada
			throw new DomainException( "Erro na reserva: Data do check-out tem que ser"
					+ " posterior à data do check-in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	@Override
	public String toString() {
		return "Quarto: "
				+ numeroQuarto
				+ ", check-in: "
				+ dtf.format(checkIn)
				+ ", check-out "
				+ dtf.format(checkOut)
				+ ", "
				+ Duracao()
				+ " noites";
	}
}
