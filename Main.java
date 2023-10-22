import java.util.List;
// import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {


		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("||                                    ||");
		System.out.println("||    Willkommen in Parkhaus Vence    ||");
		System.out.println("||                                    ||");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.print("\nAnzahl die Parketagen :\n");
		Integer etage = getUserChoice(scanner);
		System.out.print("\nAnzahl die Parkplätze pro Etage :\n");
		Integer slot = getUserChoice(scanner);
		ParkHouse parkHouse = new ParkHouse(etage, slot);

		while (true) {
			System.out.println("\n********************************************");
			System.out.println("|         Bitte Wählen:                    |");
			System.out.println("|    1. Fahrzeug Parken.                   |");
			System.out.println("|    2. Park Platz verlassen.              |");
			System.out.println("|    3. Position des Fahrzeug abfragen.	   |");
			System.out.println("|    4. Frei Plätze Anzeigen.              |");
			System.out.println("|    5. Simulation Beenden.                |");
			System.out.println("********************************************\n");
			
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
					inquireAvailableSlots(parkHouse, scanner);
					break;
				case 5:
					System.out.println("\nSimulation Beendet.\n");
					scanner.close();
					System.exit(0);
				default:
					System.out.println();
			}
		}		
	}

	private static int getUserChoice(Scanner scanner) {
		int tmp;
		System.out.print("Bitte Auswahl geben : ");
		while (true){
			if (!scanner.hasNextInt()) {
				System.out.print("Ungültige Eingabe, nochmal versuchen : ");
				scanner.nextLine();
				continue;
			}
			tmp = scanner.nextInt();
			if (tmp < 1) {
				System.out.print("Ungültige Eingabe, nochmal versuchen : ");
				scanner.nextLine();
				// continue;
			} else {
				return tmp;
			}
		}
	}

	private static void parkFahrzeug(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen eingeben : ");
		String kennzeichen = scanner.next();
		System.out.println();
		List<Integer> position = parkHouse.getFahrzeugByKennzeichen(kennzeichen);
		if (position == null) {
			Fahrzeug fahrzeug = new Fahrzeug(kennzeichen);
			if (fahrzeug.getKennzeichen() != null){
				position = parkHouse.parkVehicle(fahrzeug);
				if (position != null){
					System.out.println("Das Fahrzeug wurde geparkt in Etage "+position.get(0)+" in Position "+position.get(1)+".\n");
				}
			}} else {
				System.out.println("Error\n Doppelte Kennzeichen.\n");
			}
		}
		
		private static void leaveParkHouse(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen eingeben : ");
		String kennzeichen = scanner.next();
		System.out.println();
		List<Integer> position = parkHouse.getFahrzeugByKennzeichen(kennzeichen);
		if (position != null) {
			System.out.println("Das Fahrzeug mit Kennzeichen "+kennzeichen+" verlässt das Parkhaus.\n");
			parkHouse.removeFahrzeug(kennzeichen);
		} else {
			System.out.println("Keine Fahrzeug gefunden mit Kennzeichen "+kennzeichen+".\n");
		}
	}

	private static void inquireAboutPosition(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen eingeben : ");
		String inquiryKennzeichen = scanner.next();
		System.out.println();
		List<Integer> inquryPosition = parkHouse.getFahrzeugByKennzeichen(inquiryKennzeichen);
		if (inquryPosition != null) {
			System.out.println("Das Fahrzeug mit Kennzeichen "+inquiryKennzeichen+" steht in Etage "+inquryPosition.get(0)+" in Position "+inquryPosition.get(1)+".\n");
		} else{
			System.out.println("Das Fahrzeug mit Kennzeichen "+inquiryKennzeichen+" nicht gefunden.");
		}
	}

	private static void inquireAvailableSlots(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Gesamt verfügbare freie Plätze sind :"+parkHouse.getAvailableSlots());
	}
}