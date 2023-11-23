package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class MainProgram {
	public static void main(String[] args) {
		DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);
		System.out.print("Room number: ");
		Integer room = input.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		LocalDate checkIn = LocalDate.parse(input.next(), dayMonthYear);
		System.out.print("Check-out date (DD/MM/YYYY): ");
		LocalDate checkOut = LocalDate.parse(input.next(), dayMonthYear);

		if (!checkIn.isBefore(checkOut)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} 
		else {
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(input.next(), dayMonthYear);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(input.next(), dayMonthYear);
			String error = reservation.updateDates(checkIn, checkOut);
				if(error!=null)
					System.out.println("Error in reservation: " + error);
				else {
					
					System.out.println(reservation);
				}

		}

		input.close();

	}
}
