import java.util.List;
// import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {


		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nAnzahl die Parketagen eingeben :");
		Integer etage = getUserChoice(scanner);
		System.out.println("\nAnzahl die Parkplaetze pro Etage eingeben :");
		Integer slot = getUserChoice(scanner);
		ParkHouse parkHouse = new ParkHouse(etage, slot);

		while (true) {
			System.out.println("\nBitte Waehlen: ");
			System.out.println("1. Fahrzeug Parken.");
			System.out.println("2. Park Platz verlassen.");
			System.out.println("3. Position des Fahrzeug abfragen.");
			System.out.println("4. Gesamt Frei Plaetze.");
			System.out.println("5. Simulation Beenden.");

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
		List<Integer> position = parkHouse.getFahrzeugByKennzeichen(kennzeichen);
		if (position == null) {
			Fahrzeug fahrzeug = new Fahrzeug(kennzeichen);
			if (fahrzeug.getKennzeichen() != null){
				position = parkHouse.parkVehicle(fahrzeug);
				if (position != null){
					System.out.println("Das Fahrzeug wurde geparkt in position "+position);
				}
		}} else {
			System.out.println("Error\n Doppelte Kennzeichen.");
		}
	}

	private static void leaveParkHouse(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte position des Fahrzeug eingeben: ");
		String kennzeichen = scanner.next();
		List<Integer> position = parkHouse.getFahrzeugByKennzeichen(kennzeichen);
		if (position != null) {
			System.out.println("Das Fahrzeug mit Kennzeichen "+kennzeichen+" verlaesst das ParkHaus.");
			parkHouse.removeFahrzeug(kennzeichen);
		} else {
			System.out.println("Keine Fahrzeug gefunden mit kennzeichen "+kennzeichen+".");
		}
	}

	private static void inquireAboutPosition(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Bitte Kennzeichen geben fuer position anfragen: ");
		String inquiryKennzeichen = scanner.next();
		List<Integer> inquryPosition = parkHouse.getFahrzeugByKennzeichen(inquiryKennzeichen);

		if (inquryPosition != null) {
			System.out.println("Details von "+inquiryKennzeichen+": "+inquryPosition);
		} else{
			System.out.println("Das Fahrzeug mit Kennzeichne "+inquiryKennzeichen+" nicht gefunden.");
		}
	}

	private static void inquireAvailableSlots(ParkHouse parkHouse, Scanner scanner) {
		System.out.print("Gesamt verfugbar frei plaetze sind :"+parkHouse.getAvailableSlots());
	}
}