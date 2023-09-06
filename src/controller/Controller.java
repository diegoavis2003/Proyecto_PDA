package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Citizen;
import entity.Crime;

public class Controller {

	// RECORRERCRIMENES
	public static void tourCrimes(List<Crime> crimes) {
		for (int i = 0; i < crimes.size(); i++) {
		    Crime crime = crimes.get(i);
		    System.out.println("Crime " + (i + 1) + ":");
		    System.out.println("Crime Code: " + crime.getCodeCrime());
		    System.out.println("Crime Name: " + crime.getName());
		    System.out.println("Crime Description: " + crime.getDescription());
		    System.out.println("Crime Cost: $" + crime.getCost());
		    System.out.println("Time in Prison: " + crime.getPrisionTime() + " months");
		    System.out.println("Crime Severity: " + crime.getGravity());
		    System.out.println("------------------------");
		}
	}
	//NOMBRE DEL CIUDADANO 
	  public static Citizen findCitizenByName(List<Citizen> citizens, String name) {
	        for (Citizen citizen : citizens) {
	            if (citizen.getName().equalsIgnoreCase(name)) {
	                return citizen;
	            }
	        }
	        return null;
	    }
	  
    // CODIGO DEL CRIMEN 
    public static String getCrimeCodeInput(Scanner scanner) {
        System.out.print("Enter Crime Code: ");
        return scanner.nextLine();
    }
    
    // ENTONTAR CODIGO DEL CRIMEN
    public static Crime findCrimeByCode(List<Crime> crimes, String crimeCode) {
        for (Crime crime : crimes) {
            if (crime.getCodeCrime().equals(crimeCode)) {
                return crime;
            }
        }
        return null;
    }
    

    
    
    // IDENTIFICAR CIUDADNO POR DNI
    public static Citizen findCitizenByDNI(List<Citizen> citizens, String dni) {
        for (Citizen citizen : citizens) {
            if (citizen.getDni().equals(dni)) {
                return citizen;
            }
        }
        return null;
    }


	// MENSAJE DEL DNI
    public static String getDniInput(Scanner scanner) {
        System.out.print("Enter National ID (DNI) of the Citizen: ");
        return scanner.nextLine();
    }


    // ESTADO DEL CIUDADANO
    public static String getStatusInput(Scanner scanner) {
        System.out.print("Is the citizen deceased or missing? (deceased/missing): ");
        return scanner.nextLine().toLowerCase();
    }

    public static void processStatus(Citizen citizen, String status) {
        if (status.equals("deceased")) {
            citizen.setAlive(false);
            System.out.println("Citizen marked as deceased.");
        } else if (status.equals("missing")) {
            citizen.setMissing(true);
            System.out.println("Citizen marked as missing.");
        } else {
            System.out.println("Invalid status. Please enter 'deceased' or 'missing'.");
        }
    }
    
    //BORRAR CRIMEN
	public static void removeCrime(Crime crime) {
		
		
	}
	
	//CALTULAR TOTAL DEUDAS
	 public static double calculateTotalDebt(List<Crime> crimes) {
	        double totalDebt = 0;

	        for (Crime crime : crimes) {
	            if (!crime.isPaidCrime()) {
	                totalDebt += crime.getCost();
	            }
	        }

	        return totalDebt;
	    }
	
	// CRIMINALE ALTOS
	 public static List<Citizen> getCriminals(List<Citizen> citizens) {
	        // Create a list to store criminals
	        List<Citizen> criminals = new ArrayList<>();

	        
	        for (Citizen citizen : citizens) {
	            if (!citizen.getCrimes().isEmpty() && citizen.getGravedad().equalsIgnoreCase("High")) {
	                criminals.add(citizen);
	            }
	        }

	        return criminals;
	    }
	 
	 // GUARDAR CRIMINALES EN FICHERO
	 public static void saveCriminalsToFile(List<Citizen> criminals) {
	        try (FileWriter writer = new FileWriter("criminals.txt")) {
	            for (Citizen criminal : criminals) {
	                writer.write("Name: " + criminal.getName() + "\n");
	                writer.write("National ID (DNI): " + criminal.getDni() + "\n");
	                writer.write("Crime Severity: " + criminal.getGravedad() + "\n");
	                writer.write("------------------------\n");
	            }
	            System.out.println("Criminals have been saved to 'criminals.txt'.");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	    }
	 
	 //GUARDAR CIUDDADANOS EN FICHERO
	  public static void saveCitizensToFile(List<Citizen> citizens) {
	        try (FileWriter writer = new FileWriter("citizens.txt")) {
	            for (Citizen citizen : citizens) {
	                writer.write("Name: " + citizen.getName() + "\n");
	                writer.write("Date of Birth: " + citizen.getDateBirth() + "\n");
	                writer.write("National ID (DNI): " + citizen.getDni() + "\n");
	                writer.write("Occupation: " + citizen.getEmployment() + "\n");
	                writer.write("Alive: " + (citizen.isAlive() ? "Yes" : "No") + "\n");
	                writer.write("Height: " + citizen.getHeight() + " meters\n");
	                writer.write("Weight: " + citizen.getWeight() + " kilograms\n");
	                writer.write("Sex: " + citizen.getGender() + "\n");
	                writer.write("------------------------\n");
	            }
	            System.out.println("Citizens have been saved to 'citizens.txt'.");
	        } catch (IOException e) {
	            System.err.println("Error writing to the file: " + e.getMessage());
	        }
	    }
	 
}
