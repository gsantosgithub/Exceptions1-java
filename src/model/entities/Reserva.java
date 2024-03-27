package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {

	private Integer numeroQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reserva() {
	}
	public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) {
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
	public void AtualizarDatas(LocalDate checkIn, LocalDate checkOut) {
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
