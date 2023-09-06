package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import entity.Citizen;
import entity.Crime;

public class CrimeController {

	
	// OPCION 5
	public static void addCrime(List<Crime> crimes, Scanner scanner) {
        System.out.println("----- Add a New Crime -----");
        System.out.print("Enter Crime Code: ");
        String crimeCode = scanner.nextLine();
        System.out.print("Enter Paid Crime: ");
        boolean paidCrime = scanner.nextBoolean();
        System.out.print("Enter Crime Name: ");
        String crimeName = scanner.nextLine();
        System.out.print("Enter Crime Description: ");
        String crimeDescription = scanner.nextLine();
        System.out.print("Enter Crime Cost: ");
        double crimeCost = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Time in Prison (in months): ");
        int timeInPrison = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Crime Severity (Low, Medium, High): ");
        String crimeSeverity = scanner.nextLine();

        Crime newCrime = new Crime(crimeCode, false, crimeName, crimeDescription, crimeCost, timeInPrison, crimeSeverity);
        crimes.add(newCrime);

        System.out.println("New crime added successfully.");
    }
	
	//OPCION 6
	 public static void viewCrimes(List<Crime> crimes) {
	        System.out.println("----- View All Recorded Crimes -----");

	        if (crimes.isEmpty()) {
	            System.out.println("No crimes have been recorded yet.");
	        } else {
	            System.out.println("List of Recorded Crimes:");

	            Controller.tourCrimes(crimes);
	        }
	    }
	 
	 //OPCION 7
	 public static void recordCrimeForCitizen(List<Citizen> citizens, List<Crime> crimes, Scanner scanner) {
	        System.out.println("----- Record Crime for a Citizen -----");
	        String dni = Controller.getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	        } else {
	            String crimeCode = Controller.getCrimeCodeInput(scanner);
	            Crime crime = Controller.findCrimeByCode(crimes, crimeCode);

	            if (crime == null) {
	                System.out.println("No crime found with the provided code.");
	            } else {
	                citizen.addCrime(crime);
	                System.out.println("Crime added to Citizen (DNI: " + dni + ") successfully.");
	            }
	        }
	    }
	 //OPCION 8
	 public static void removeCrimeForCitizen(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- Remove Crime from a Citizen -----");
	        String dni = Controller.getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	        } else {
	            String crimeCode = Controller.getCrimeCodeInput(scanner);
	            Crime crime = Controller.findCrimeByCode(citizen.getChargedCrime(), crimeCode);

	            if (crime == null) {
	                System.out.println("No crime found for this citizen with the provided code.");
	            } else {
	                Controller.removeCrime(crime);
	                System.out.println("Crime removed from Citizen (DNI: " + dni + ") successfully.");
	            }
	        }
	    }
	 
	 //OPCION 9
	 public static void collectDebtForCrime(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- Collect Debt for a Crime -----");
	        String dni = Controller.getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	        } else {
	            String crimeCode = Controller.getCrimeCodeInput(scanner);
	            Crime crime = Controller.findCrimeByCode(citizen.getCrimes(), crimeCode);

	            if (crime == null) {
	                System.out.println("No crime found for this citizen with the provided code.");
	            } else {
	                if (crime.isPaidCrime()) {
	                    System.out.println("This crime has already been paid for.");
	                } else {
	                    double debt = crime.getCost();
	                    crime.setPaidCrime(true);
	                    System.out.println("Debt of $" + debt + " collected for Crime (Code: " + crimeCode + ").");
	                }
	            }
	        }
	    }
	 
	 //OPCION 12
	 public static void printCriminals(List<Citizen> citizens) {
	        System.out.println("----- Print Criminals -----");

	        // Create a list of criminals
	        List<Citizen> criminals = Controller.getCriminals(citizens);

	        if (criminals.isEmpty()) {
	            System.out.println("No criminals found.");
	        } else {
	          
	            Collections.sort(criminals, Comparator.comparing(Citizen::getCrimeSeverity).reversed());

	            // Print the list of criminals
	            for (Citizen criminal : criminals) {
	                System.out.println("Name: " + criminal.getName());
	                System.out.println("National ID (DNI): " + criminal.getDni());
	                System.out.println("Crime Severity: " + criminal.getGravedad());
	                System.out.println("------------------------");
	            }

	            // Save the list of criminals to a file
	            Controller.saveCriminalsToFile(criminals);
	        }
	    }

	  
}
