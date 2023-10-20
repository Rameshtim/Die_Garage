import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkHouse {
	private Map<Integer, Fahrzeug> parkingSpaces = new HashMap<>();
	private int nextAvailablePosition = 1;

	public int parkVehicle(Fahrzeug fahrzeug) {
		int position = nextAvailablePosition;
		fahrzeug.park(position);
		parkingSpaces.put(position, fahrzeug);
		nextAvailablePosition++;
		return position;
	}

	public Fahrzeug getFahrzeugAtPosition(int position) {
		return parkingSpaces.get(position);
	}

	public Fahrzeug getFahrzeugByKennzeichen(String Kennzeichen) {
		return parkingSpaces.get(Kennzeichen);
	}
// }

// public class Main {
	public static void main (String[] args) {
		ParkHouse parkHouse = new ParkHouse();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Geben Sie die Kennzeichen von Auto: ");
		String kennzeichen1 = scanner.nextLine();
		Fahrzeug fahrzeug1 = new Fahrzeug(kennzeichen1);
		int position1 = parkHouse.parkVehicle(fahrzeug1);

		System.out.println("Geben sie die Kennzeichen von Motorrad: ");
		String kennzeichen2 = scanner.nextLine();
		Fahrzeug fahrzeug2 = new Fahrzeug(kennzeichen2);
		int position2 = parkHouse.parkVehicle(fahrzeug2);

		System.out.println("Ihr autos sind geparked.");

		System.out.println("Geben Sie die Kennzeichen fuer PlatzAnfrage ");
		String inquiryKennzeichen = scanner.nextLine();
		// Fahrzeug inquiryFahrzeug = parkHouse.getFahrzeugAtPosition(inquiryKennzeichen);
		Fahrzeug inquiryFahrzeug = parkHouse.getFahrzeugByKennzeichen(inquiryKennzeichen);

		if (inquiryFahrzeug != null) {
			System.out.println("Die Details von "+inquiryKennzeichen+": "+inquiryFahrzeug);
		}
		else {
			System.out.println("Das Fahrzeug mit Kennzeichen "+inquiryKennzeichen+" nicht gefunden.");
		}
		scanner.close();
	}
}
