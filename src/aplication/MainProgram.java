package aplication;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class MainProgram {
	public static void main(String[] args) {

		DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Room number: ");
			Integer room = input.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(input.next(), dayMonthYear);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(input.next(), dayMonthYear);
			Reservation reservation = new Reservation(room, checkIn, checkOut);
			System.out.println(reservation);
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(input.next(), dayMonthYear);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(input.next(), dayMonthYear);
			reservation.updateDates(checkIn, checkOut);

			System.out.println(reservation);
		}
		catch (DateTimeException e) {
			System.out.println("Date format is wrong!");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}

		input.close();

	}
}
