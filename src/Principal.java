import java.util.*;

import entity.Citizen;
import entity.Crime;
import utils.Menu;
import entity.ChargedCrime;

import java.io.*;

public class Principal{
   // private static List<Citizen> citizens = new ArrayList<>();
   // public static List<Crime> crimes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       Menu.MainMenu(scanner);
    }

	

    /*
     * private static void addCitizen(Scanner scanner) {
    	System.out.println("----- Add a New Citizen -----");

        // Input citizen details
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

        // Create a new citizen
        Citizen newCitizen = new Citizen(dateOfBirth, name, occupation, dni, crimes, false, false, height, weight, dni);
				

        // Add the new citizen to the list
        citizens.add(newCitizen);

        System.out.println("New citizen added successfully.");    }
*/
    // Record a deceased or missing citizen
    /*private static void recordDeceasedOrMissing(Scanner scanner) {
    	 System.out.println("----- Dead Citizen -----");
    	    System.out.print("DNI of the citizen");
    	    String dni = scanner.nextLine();

    	    Citizen citizen = findCitizenByDNI(dni);

    	    if (citizen == null) {
    	        System.out.println("\r\n"
    	        		+ "No citizen was found with the provided ID.");
    	    } else {
    	        citizen.setVivo(false);
    	        System.out.println("The death of the citizen has been registered.");
    	    }
    }*/

    /*
    private static void addSuspect(Scanner scanner) {
    	System.out.println("----- \r\n"
    			+ "Add Search -----");
        System.out.print("ID of the citizen to look for:");
        String dni = scanner.nextLine();

        Citizen citizen = findCitizenByDNI(dni);

        if (citizen== null) {
            System.out.println("No citizen was found with the ID provided.");
        } else if (citizen.isBuscado()) {
            System.out.println("The citizen is already in search.");
        } else {
            citizen.setBuscado(true);
            System.out.println("\r\n"
            		+ "The citizen has been established as wanted.");
        }
    }

   

	// Remove a suspect
    private static void removeSuspect(Scanner scanner) {
    	 System.out.println("-----Remove Search-----");
    	    System.out.print("ID of the citizen to withdraw from the search:");
    	    String dni = scanner.nextLine();

    	    Citizen citizen = findCitizenByDNI(dni);

    	    if (citizen == null) {
    	        System.out.println("No citizen was found with the ID provided.");
    	    } else if (!citizen.isBuscado()) {
    	        System.out.println("The citizen is not in search.");
    	    } else {
    	        citizen.setBuscado(false);
    	        System.out.println("The citizen has been removed from the search.");
    	    }
    	    }    

    // Add a new crime
    private static void addCrime(Scanner scanner) {
    	System.out.println("----- Add a New Crime -----");

        // Input crime details
        System.out.print("Enter Crime Code: ");
        String crimeCode = scanner.nextLine();
        System.out.print("Enter Crime Name: ");
        String crimeName = scanner.nextLine();
        System.out.print("Enter Crime Description: ");
        String crimeDescription = scanner.nextLine();
        System.out.print("Enter Crime Cost: ");
        double crimeCost = scanner.nextDouble();
        System.out.print("Enter Time in Prison (in months): ");
        int timeInPrison = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Crime Severity (Low, Medium, High): ");
        String crimeSeverity = scanner.nextLine();

        // Create a new crime
        Crime newCrime = new Crime(crimeCode, false, crimeName, crimeDescription, crimeCost, timeInPrison, crimeSeverity);

        // Add the new crime to the list
        crimes.add(newCrime);

        System.out.println("New crime added successfully.");
    }

    // View all recorded crimes
    private static void viewCrimes() {
    	System.out.println("----- View All Recorded Crimes -----");

        if (crimes.isEmpty()) {
            System.out.println("No crimes have been recorded yet.");
        } else {
            System.out.println("List of Recorded Crimes:");

            for (int i = 0; i < crimes.size(); i++) {
                Crime crime = crimes.get(i);
                System.out.println("Crime " + (i + 1) + ":");
                System.out.println("Crime Code: " + crime.getCodeCrime());
                System.out.println("Crime Name: " + crime.getName());
                System.out.println("Crime Description: " + crime.getDescription());
                System.out.println("Crime Cost: " + crime.getCost());
                System.out.println("Time in Prison: " + crime.getPrisionTime() + " months");
                System.out.println("Crime Severity: " + crime.getGravity());
                System.out.println("------------------------");
            }
        }    }

    // Record a crime for a citizen
    private static void recordCrimeForCitizen(Scanner scanner) {
    	 System.out.println("----- Record Crime for a Citizen -----");
    	    System.out.print("Enter National ID (DNI) of the Citizen: ");
    	    String dni = scanner.nextLine();

    	    Citizen citizen = findCitizenByDNI(dni);

    	    if (citizen == null) {
    	        System.out.println("No citizen found with the provided DNI.");
    	    } else {
    	        System.out.print("Enter Crime Code: ");
    	        String crimeCode = scanner.nextLine();

    	        Crime crime = findCrimeByCode(crimeCode);

    	        if (crime == null) {
    	            System.out.println("No crime found with the provided code.");
    	        } else {
    	            citizen.addCrime(crime);
    	            System.out.println("Crime added to Citizen (DNI: " + dni + ") successfully.");
    	        }
    	    }
    }


	// Remove a crime from a citizen's record
    private static void removeCrimeFromCitizen(Scanner scanner) {
    	 System.out.println("----- Remove Crime from a Citizen -----");
    	    System.out.print("Enter National ID (DNI) of the Citizen: ");
    	    String dni = scanner.nextLine();

    	    Citizen citizen = findCitizenByDNI(dni);

    	    if (citizen == null) {
    	        System.out.println("No citizen found with the provided DNI.");
    	    } else {
    	        List<Crime> citizenCrimes = citizen.getChargedCrime();

    	        if (citizenCrimes.isEmpty()) {
    	            System.out.println("This citizen does not have any recorded crimes.");
    	        } else {
    	            System.out.println("Crimes for Citizen (DNI: " + dni + "):");

    	            for (int i = 0; i < citizenCrimes.size(); i++) {
    	                System.out.println((i + 1) + ". " + citizenCrimes.get(i).getCodeCrime());
    	            }

    	            System.out.print("Enter the number of the crime to remove: ");
    	            int choice = scanner.nextInt();
    	            scanner.nextLine(); // Consume the newline

    	            if (choice >= 1 && choice <= citizenCrimes.size()) {
    	                Crime removedCrime = citizenCrimes.remove(choice - 1);
    	                System.out.println("Crime '" + removedCrime.getCodeCrime() + "' removed successfully.");
    	            } else {
    	                System.out.println("Invalid choice. Please select a valid crime number.");
    	            }
    	        }
    	    }    }

    // Collect debt for a crime
    private static void collectDebtForCrime(Scanner scanner) {
    	System.out.println("----- Collect Debt for a Crime -----");
        System.out.print("Enter National ID (DNI) of the Citizen: ");
        String dni = scanner.nextLine();

        Citizen citizen = findCitizenByDNI(dni);

        if (citizen == null) {
            System.out.println("No citizen found with the provided DNI.");
        } else {
            List<Crime> citizenCrimes = citizen.getChargedCrime();

            if (citizenCrimes.isEmpty()) {
                System.out.println("This citizen does not have any recorded crimes.");
            } else {
                System.out.println("Crimes for Citizen (DNI: " + dni + "):");

                for (int i = 0; i < citizenCrimes.size(); i++) {
                    System.out.println((i + 1) + ". " + citizenCrimes.get(i).getCodeCrime());
                }

                System.out.print("Enter the number of the crime for which to collect debt: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                if (choice >= 1 && choice <= citizenCrimes.size()) {
                    Crime crime = citizenCrimes.get(choice - 1);
                    double debtAmount = crime.getCost();
                    System.out.println("Debt collected for crime '" + crime.getCodeCrime() + "' ($" + debtAmount + ").");
                    citizenCrimes.remove(crime);
                } else {
                    System.out.println("Invalid choice. Please select a valid crime number.");
                }
            }
        }    }

    // View a citizen's debts
    private static void viewCitizenDebts(Scanner scanner) {
    	 System.out.println("----- View Citizen's Debts -----");
    	    System.out.print("Enter National ID (DNI) of the Citizen: ");
    	    String dni = scanner.nextLine();

    	    Citizen citizen = findCitizenByDNI(dni);

    	    if (citizen == null) {
    	        System.out.println("No citizen found with the provided DNI.");
    	    } else {
    	        List<Crime> citizenCrimes = citizen.getChargedCrime();

    	        if (citizenCrimes.isEmpty()) {
    	            System.out.println("This citizen does not have any recorded debts.");
    	        } else {
    	            double totalDebt = 0.0;

    	            for (Crime crime : citizenCrimes) {
    	                totalDebt += crime.getCost();
    	            }

    	            System.out.println("Total Debt for Citizen (DNI: " + dni + "): $" + totalDebt);
    	        }
    	    }
    	    }

    // View debtors (citizens with unpaid debts)
    private static void viewDebtors() {
    	 System.out.println("----- View Debtors -----");

    	    boolean foundDebtor = false;

    	    for (Citizen citizen : citizens) {
    	        List<Crime> citizenCrimes = citizen.getChargedCrime();

    	        if (!citizenCrimes.isEmpty()) {
    	            double totalDebt = 0.0;

    	            for (Crime crime : citizenCrimes) {
    	                totalDebt += crime.getCost();
    	            }

    	            System.out.println("Citizen (DNI: " + citizen.getDni() + ") owes $" + totalDebt);
    	            foundDebtor = true;
    	        }
    	    }

    	    if (!foundDebtor) {
    	        System.out.println("No debtors found.");
    	    }    }

    // Print a list of criminals
    private static void printCriminals() {
    	System.out.println("----- Print Criminals -----");

        boolean foundCriminals = false;

        for (Citizen citizen : citizens) {
            if (citizen.isCriminal()) {
                System.out.println("Citizen (DNI: " + citizen.getDni() + ")");

                System.out.println("Name: " + citizen.getName());
                System.out.println("Occupation: " + citizen.getEmployment());
                System.out.println("------------------------");
                
                foundCriminals = true;
            }
        }

        if (!foundCriminals) {
            System.out.println("No criminals found.");
        }
    }

    private static double getGravedadValue(String gravedad) {
        switch (gravedad.toLowerCase()) {
            case "leve":
                return 1;
            case "medio":
                return 2;
            case "grave":
                return 3;
            default:
                return 0;
        }
    }

    private static double calcularPeligrosidad(Citizen citizen) {
        return citizen.getDelitosImputados().stream()
                .mapToDouble(delito -> getGravedadValue(delito.getGravedad()))
                .sum();
    	    }

    // Print a list of all citizens
    private static void printCitizens() {
    	 System.out.println("----- Print Citizens -----");

    	    if (citizens.isEmpty()) {
    	        System.out.println("No citizens have been recorded yet.");
    	    } else {
    	        System.out.println("List of Recorded Citizens:");

    	        for (int i = 0; i < citizens.size(); i++) {
    	            Citizen citizen = citizens.get(i);
    	            System.out.println("Citizen " + (i + 1) + ":");
    	            System.out.println("Name: " + citizen.getName());
    	            System.out.println("Date of Birth: " + citizen.getDateBirth());
    	            System.out.println("Occupation: " + citizen.getEmployment());
    	            System.out.println("National ID (DNI): " + citizen.getDni());
    	            System.out.println("Height: " + citizen.getHeight() + " meters");
    	            System.out.println("Weight: " + citizen.getWeight() + " kilograms");
    	            System.out.println("------------------------");
    	        }
    	    }
    	    }

    // Print a list of all crimes
    private static void printCrimes() {
    	 System.out.println("----- Print Crimes -----");

    	    if (crimes.isEmpty()) {
    	        System.out.println("No crimes have been recorded yet.");
    	    } else {
    	        System.out.println("List of Recorded Crimes:");

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
    	    }

    // Load citizens from a file
    private static void loadCitizensFromFile() {
    	System.out.println("----- Load Citizens from File -----");

        try (Scanner fileScanner = new Scanner(new File("citizens.txt"))) {
            while (fileScanner.hasNextLine()) {
                String dateOfBirth = fileScanner.nextLine().replace("Date of Birth: ", "");
                String name = fileScanner.nextLine().replace("Name: ", "");
                String occupation = fileScanner.nextLine().replace("Occupation: ", "");
                String dni = fileScanner.nextLine().replace("National ID (DNI): ", "");
                double height = Double.parseDouble(fileScanner.nextLine().replace("Height: ", ""));
                double weight = Double.parseDouble(fileScanner.nextLine().replace("Weight: ", ""));

                Citizen citizen = new Citizen(dateOfBirth, name, occupation, dni, crimes, false, false, height, weight, dni);
                citizens.add(citizen);

                fileScanner.nextLine(); // Consume the empty line
            }

            System.out.println("Citizens loaded from file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("The 'citizens.txt' file was not found.");
        } catch (Exception e) {
            System.out.println("Error loading citizens from file.");
        }
        }

    // Load crimes from a file
    private static void loadCrimesFromFile() {
    	System.out.println("----- Load Crimes from File -----");

        try (Scanner fileScanner = new Scanner(new File("crimes.txt"))) {
            while (fileScanner.hasNextLine()) {
                String crimeCode = fileScanner.nextLine().replace("Crime Code: ", "");
                String crimeName = fileScanner.nextLine().replace("Crime Name: ", "");
                String crimeDescription = fileScanner.nextLine().replace("Crime Description: ", "");
                double crimeCost = Double.parseDouble(fileScanner.nextLine().replace("Crime Cost: $", ""));
                int timeInPrison = Integer.parseInt(fileScanner.nextLine().replace("Time in Prison: ", ""));
                String crimeSeverity = fileScanner.nextLine().replace("Crime Severity: ", "");

                Crime crime = new Crime(crimeCode, false, crimeName, crimeDescription, crimeCost, timeInPrison, crimeSeverity);
                crimes.add(crime);

                fileScanner.nextLine(); // Consume the empty line
            }

            System.out.println("Crimes loaded from file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("The 'crimes.txt' file was not found.");
        } catch (Exception e) {
            System.out.println("Error loading crimes from file.");
        }
        }
    private static Citizen findCitizenByDNI(String dni) {
    	 for (Citizen citizen : citizens) {
    	        if (citizen.getDni().equals(dni)) {
    	            return citizen;
    	        }
    	    }
		return null;
	}

    private static Crime findCrimeByCode(String crimeCode) {
    	 for (Crime crime : crimes) {
    	        if (crime.getCodeCrime().equals(crimeCode)) {
    	            return crime;
    	        }
    	    }
    	    return null;
	}*/
    
}