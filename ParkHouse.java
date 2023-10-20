import java.util.HashMap;
import java.util.Map;
// import java.util.Scanner;

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

	public Fahrzeug getFahrzeugByKennzeichen(String kennzeichen) {
		return parkingSpaces.get(kennzeichen);
	}

	public void removeFahrzeug(String kennzeichen) {
		if (parkingSpaces.containsKey(kennzeichen)) {
			parkingSpaces.remove(kennzeichen);
		}
	}
}
