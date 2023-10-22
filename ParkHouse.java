// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParkHouse {
	private HashMap<String, List<Integer>> parkingSpaces = new HashMap<>();
	private Integer nextAvailablePosition = 1;
	private Integer etage;
	private Integer slot;

	public ParkHouse (Integer etage, Integer slot){
		this.etage = etage;
		this.slot = slot;
	}

	public List<Integer> parkVehicle(Fahrzeug fahrzeug) {
		List<Integer> position = Arrays.asList(1, 1);
		while (this.parkingSpaces.containsValue(position))
		{
			if (position.get(1) >= this.slot){
				if (position.get(0) < this.etage){
					int firstValue = position.get(0);
            		firstValue++; 
            		position.set(0, firstValue);
					int secondValue = position.get(1);
					secondValue = 1; 
					position.set(1, secondValue);
				}
				else {
					System.out.println("\n********************************");
					System.out.println("*******Keine Platz Mehr*********");
					System.out.println("********************************\n");
					return null;
				}
			}
			else {
				int secondValue = position.get(1);
            	secondValue++; 
            	position.set(1, secondValue);
			}
		}
		fahrzeug.park(position);
		parkingSpaces.put(fahrzeug.getKennzeichen(), position);
		nextAvailablePosition++;
		return position;
	}

	public List<Integer> getFahrzeugByKennzeichen(String kennzeichen) {
		return parkingSpaces.get(kennzeichen);
	}

	public void removeFahrzeug(String kennzeichen) {
		if (parkingSpaces.containsKey(kennzeichen)) {
			parkingSpaces.remove(kennzeichen);
		}
	}

	public HashMap<String, List<Integer>> getParkingSpaces() {
		return this.parkingSpaces;
	}

	public Integer getAvailableSlots(){
		return this.etage * this.slot - this.parkingSpaces.size();
	}
}
