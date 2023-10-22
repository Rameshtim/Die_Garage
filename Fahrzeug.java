import java.util.List;

public class Fahrzeug {
	private String Kennzeichen;
	private List<Integer> position;

	public Fahrzeug(String Kennzeichen){
		this.Kennzeichen = Kennzeichen;
	}

	public String getKennzeichen() {
		return Kennzeichen;
	}

	public List<Integer> getPosition() {
		return position;
	}

	public void park(List<Integer> position) {
		this.position = position;
	}

	@Override
	public String toString(){
		return "Auto mit Kennzeichen: "+Kennzeichen+" ist geparkt in Etage"+position.get(0)+" position "+position.get(1)+".";
	}
}
