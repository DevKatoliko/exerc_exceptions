package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private static final DateTimeFormatter DMY = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // importante feixar em estático
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public Integer duration() {
		Period period = Period.between(checkIn, checkOut);
		 return period.getDays();
		
	}
	
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.parse("01/01/2019",DMY);
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates for update must be future dates";
		} 
		if (!checkIn.isBefore(checkOut)) {
			return"Check-out date must be after check-in date";
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	public String formatDate (LocalDate date) {
		return DMY.format(date);
	}
	
	@Override
	public String toString() {
		return "Reservetion: Room " + getRoomNumber() + ", check-in: " + formatDate(getCheckIn()) + ", check-out: " + formatDate(getCheckOut()) 
		+", "+ duration() + " nights" ;
	}
	
}
