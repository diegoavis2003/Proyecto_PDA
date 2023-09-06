package utils;

import java.util.Scanner;

import controller.CitizenController;
import controller.CrimeController;

public class Menu {

	
	public static void MainMenu(Scanner scanner) {
		while (true) {
            System.out.println("\n----- Criminal Records Management System -----");
            System.out.println("1. Add Citizen");
            System.out.println("2. Record Deceased or Missing Citizen");
            System.out.println("3. Add Suspect");
            System.out.println("4. Remove Suspect");
            System.out.println("5. Add Crime");
            System.out.println("6. View Crimes");
            System.out.println("7. Record Crime for a Citizen");
            System.out.println("8. Remove Crime from a Citizen");
            System.out.println("9. Collect Debt for a Crime");
            System.out.println("10. View Citizen's Debts");
            System.out.println("11. View Debtors");
            System.out.println("12. Print Criminals");
            System.out.println("13. Print Citizens");
            System.out.println("14. Print Crimes");
            System.out.println("15. Load Citizens from File");
            System.out.println("16. Load Crimes from File");
            System.out.println("17. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    CitizenController.addCitizen(null, scanner);
                    break;
                case 2:
                	CitizenController.recordDeceasedOrMissing(null, scanner);
                    break;
                case 3:
                    CitizenController.addSearch( null, scanner);
                    break;
                case 4:
                	CitizenController.removeSearch(null, scanner);
                    break;
                case 5:
                    CrimeController.addCrime(null, scanner);
                    break;
                case 6:
                    CrimeController.viewCrimes(null);
                    break;
                case 7:
                    CitizenController.recordCrimeForCitizen(null, null, scanner);
                    break;
                case 8:
                    CrimeController.removeCrimeForCitizen(null, scanner);
                    break;
                case 9:
                    CrimeController.collectDebtForCrime(null, scanner);
                    break;
                case 10:
                    CitizenController.viewDebtsForCitizen(null, scanner);
                    break;
                case 11:
                    CitizenController.viewDebtors(null);
                    break;
                case 12:
                    CrimeController.printCriminals(null);
                    break;
                case 13:
                    CitizenController.printCitizens(null);
                    break;
                case 14:
                    CrimeController.printCrimes();
                    break;
                case 15:
                    CitizenController.loadCitizensFromFile();
                    break;
                case 16:
                    CrimeController.loadCrimesFromFile();
                    break;
                case 17:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
	}

}