import java.util.HashSet;
import java.util.Set;

public class Fahrzeug {
	private String Kennzeichen;
	private int position;

	public static Set<String> uniqueLicensePlates = new HashSet<>();


	public Fahrzeug(String Kennzeichen){
		this.Kennzeichen = Kennzeichen;

		if (!isLicensePlateUnique(Kennzeichen)){
			throw new IllegalArgumentException("Kennzeichen darf nur einmal Existieren");
		}
		uniqueLicensePlates.add(Kennzeichen);
	}

	private boolean isLicensePlateUnique(String Kennzeichen) {
		return !uniqueLicensePlates.contains(Kennzeichen);
	}

	public String getKennzeichen() {
		return Kennzeichen;
	}

	public int getPosition() {
		return position;
	}

	public void park(int position) {
		this.position = position;
	}

	@Override
	public String toString(){
		return "Auto mit Kennzeichen: "+Kennzeichen+"ist geparkt in "+position+".";
	}
}
