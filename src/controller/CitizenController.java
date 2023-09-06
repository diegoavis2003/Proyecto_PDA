package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Citizen;
import entity.Crime;

public class CitizenController {

	   private static List<Crime> crimes = new ArrayList<>();


	//OPCION 1
	public static void addCitizen(List<Citizen> citizens, Scanner scanner) {
		System.out.println("----- Add a New Citizen -----");

		// DATOS DEL CIUDADANO
		System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
		String dateOfBirth = scanner.nextLine();
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Occupation: ");
		String occupation = scanner.nextLine();
		System.out.print("Enter National ID (DNI): ");
		String dni = scanner.nextLine();
		System.out.print("Enter Height (in meters): ");
		double height = scanner.nextDouble();
		System.out.print("Enter Weight (in kilograms): ");
		double weight = scanner.nextDouble();
		scanner.nextLine(); // Consume the newline

		// NUEVO CIUDADANO
		Citizen newCitizen = new Citizen(dateOfBirth, name, occupation, dni, crimes, false, false, height, weight, dni);

		// LO AÑADES A LA LISTA
		citizens.add(newCitizen);

		System.out.println("New citizen added successfully.");
	}
	
	//OPCION 2
	 public static void recordDeceasedOrMissing(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- Record Decease or Missing Citizen -----");
	        String dni = Controller.getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	            return;
	        }

	        String status = Controller.getStatusInput(scanner);
	        Controller.processStatus(citizen, status);
	    }

	
	    //OPCION 3
	    public static void addSearch(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- Add Search for a Citizen -----");
	        String dni = Controller.getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	        } else {
	            citizen.setWanted(true);
	            System.out.println("Citizen added to the list of wanted individuals.");
	        }
	    }

	    //OPCION 4
	    public static void removeSearch(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- Remove Search for a Citizen -----");
	        String dni =Controller. getDniInput(scanner);
	        Citizen citizen = Controller.findCitizenByDNI(citizens, dni);

	        if (citizen == null) {
	            System.out.println("No citizen found with the provided DNI.");
	        } else {
	            citizen.setWanted(false);
	            System.out.println("Citizen removed from the list of wanted individuals.");
	        }
	    }

	    //OPCION 10
	    public static void viewDebtsForCitizen(List<Citizen> citizens, Scanner scanner) {
	        System.out.println("----- View Debts for a Citizen -----");
	        String identifier = Controller.getDniInput(scanner);

	        List<Crime> citizenCrimes;
	        if (identifier.length() == 9) {
	            citizenCrimes = Controller.findCitizenByDNI(citizens, identifier).getCrimes();
	        } else {
	            citizenCrimes = Controller.findCitizenByName(citizens, identifier).getCrimes();
	        }

	        if (citizenCrimes.isEmpty()) {
	            System.out.println("No debts found for this citizen.");
	        } else {
	            System.out.println("Debts for Citizen (Identifier: " + identifier + "):");

	            for (Crime crime : citizenCrimes) {
	                if (!crime.isPaidCrime()) {
	                    System.out.println("Crime Code: " + crime.getCodeCrime());
	                    System.out.println("Crime Name: " + crime.getName());
	                    System.out.println("Crime Cost: $" + crime.getCost());
	                    System.out.println("------------------------");
	                }
	            }
	        }
	    }
	    
	    //OPCION 11
	    public static void viewDebtors(List<Citizen> citizens) {
	        System.out.println("----- View Debtors -----");

	        boolean foundDebtors = false;

	        for (Citizen citizen : citizens) {
	            double totalDebt = Controller.calculateTotalDebt(citizen.getCrimes());

	            if (totalDebt > 0) {
	                System.out.println("Citizen Name: " + citizen.getName());
	                System.out.println("National ID (DNI): " + citizen.getDni());
	                System.out.println("Total Debt: $" + totalDebt);
	                System.out.println("------------------------");
	                foundDebtors = true;
	            }
	        }

	        if (!foundDebtors) {
	            System.out.println("No debtors found.");
	        }
	    }
	
	    
	    // OPCION 13
	    public static void printCitizens(List<Citizen> citizens) {
	        System.out.println("----- Print Citizens -----");

	        if (citizens.isEmpty()) {
	            System.out.println("No citizens found.");
	        } else {
	            // Print the list of citizens
	            for (Citizen citizen : citizens) {
	                System.out.println("Name: " + citizen.getName());
	                System.out.println("Date of Birth: " + citizen.getDateBirth());
	                System.out.println("National ID (DNI): " + citizen.getDni());
	                System.out.println("Occupation: " + citizen.getEmployment());
	                System.out.println("Alive: " + (citizen.isAlive() ? "Yes" : "No"));
	                System.out.println("Height: " + citizen.getHeight() + " meters");
	                System.out.println("Weight: " + citizen.getWeight() + " kilograms");
	                System.out.println("Sex: " + citizen.getGender());
	                System.out.println("------------------------");
	            }

	            // Save the list of citizens to a file
	            Controller.saveCitizensToFile(citizens);
	        }
	    }

}
