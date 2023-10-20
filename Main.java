import java.util.Scanner;

public class Main {
	public static void main (String[] args) {


		ParkHouse parkHouse = new ParkHouse();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nBitte Waehlen: ");
			System.out.println("1. Fahrzeug Parken.");
			System.out.println("2. Park Platz verlassen !");
			System.out.println("3. Position des Fahrzeug abfragen !");
			System.out.println("4. Simulation Beenden.");

			int choice = getUserChoice(scanner);

			switch (choice) {
				case 1:
					parkFahrzeug(parkHouse, scanner);
					break;
				case 2:
					leaveParkHouse(parkHouse, scanner);
					break;
				case 3:
					inquireAboutPosition(parkHouse, scanner);
					break;
				case 4:
					System.out.println("Simulation Beendet.");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Bitte gueltige auswahl treffen.");
			}
		}		
	}

	private static int getUserChoice(Scanner scanner) {
		System.out.print("Bitte auswahl geben : ");
		while (!scanner.hasNextInt()) {
			System.out.println("Bitte nummer eingeben");
			scanner.nextLine();
		}
		return scanner.nextInt();
	}

	private static void parkFahrzeug(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen eingeben: ");
		String kennzeichen = scanner.next();
		Fahrzeug fahrzeug = new Fahrzeug(kennzeichen);
		int	position = parkHouse.parkVehicle(fahrzeug);
		System.out.println("Das Fahrzeug wurde geparkt in position "+position);
	}

	private static void leaveParkHouse(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte position des Fahrzeug eingeben: ");
		String kennzeichen = scanner.next();
		Fahrzeug fahrzeug = parkHouse.getFahrzeugByKennzeichen(kennzeichen);
		if (fahrzeug != null) {
			System.out.println("Das Fahrzeug mit Kennzeichen "+fahrzeug.getKennzeichen()+"verlaesst das ParkHaus.");
			parkHouse.removeFahrzeug(kennzeichen);
		} else {
			System.out.println("Keine Fahrzeug gefunden mit kennzeichen "+kennzeichen+".");
		}
	}

	private static void inquireAboutPosition(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen geben fuer position anfragen: ");
		String inquiryKennzeichen = scanner.next();
		Fahrzeug inquryFahrzeug = parkHouse.getFahrzeugByKennzeichen(inquiryKennzeichen);

		if (inquryFahrzeug != null) {
			System.out.println("Details von "+inquiryKennzeichen+": "+inquryFahrzeug);
		} else {
			System.out.println("Das Fahrzeug mit Kennzeichne "+inquiryKennzeichen+" nicht gefunden.");
		}
	}
}


		// ParkHouse parkHouse = new ParkHouse();
		// Scanner scanner = new Scanner(System.in);

		// System.out.println("Geben Sie die Kennzeichen von Auto: ");
		// String kennzeichen1 = scanner.nextLine();
		// Fahrzeug fahrzeug1 = new Fahrzeug(kennzeichen1);
		// int position1 = parkHouse.parkVehicle(fahrzeug1);

		// System.out.println("Geben sie die Kennzeichen von Motorrad: ");
		// String kennzeichen2 = scanner.nextLine();
		// Fahrzeug fahrzeug2 = new Fahrzeug(kennzeichen2);
		// int position2 = parkHouse.parkVehicle(fahrzeug2);

		// System.out.println("Ihr autos sind geparked.");

		// System.out.println("Geben Sie die Kennzeichen fuer PlatzAnfrage ");
		// String inquiryKennzeichen = scanner.nextLine();
		// // Fahrzeug inquiryFahrzeug = parkHouse.getFahrzeugAtPosition(inquiryKennzeichen);
		// Fahrzeug inquiryFahrzeug = parkHouse.getFahrzeugByKennzeichen(inquiryKennzeichen);

		// if (inquiryFahrzeug != null) {
		// 	System.out.println("Die Details von "+inquiryKennzeichen+": "+inquiryFahrzeug);
		// }
		// else {
		// 	System.out.println("Das Fahrzeug mit Kennzeichen "+inquiryKennzeichen+" nicht gefunden.");
		// }
		// scanner.close();