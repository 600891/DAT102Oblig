package no.hvl.dat102.hobby;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	//Konstrukt�r
	
	//Andre metoder
	
	
	
	
	public boolean passerTil(Medlem medlem2) {
		if()
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
}
