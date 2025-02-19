package no.hvl.dat102;

import java.util.ArrayList;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmsamling;
	private int antall;
	
	public Filmarkiv(int n) {
		filmsamling = new Film[n];
		antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		for(int i = 0; i < antall; i++ ) {
			if (filmsamling[i].getFilmnr() == nr) {
				return filmsamling[i];
			}
		}
		return null;
		
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (filmsamling.length <= antall) {
			Film[] temp = filmsamling;
			filmsamling = new Film[antall*2];
			for (int i = 0; i < antall; i++) {
				filmsamling[i] = temp[i];
			}
		}
		filmsamling[antall] = nyFilm;
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for(int i = 0; i < antall; i++ ) {
			if (filmsamling[i].getFilmnr() == filmnr) {
				for (int j = i; j < antall-1; j++) { //Flytter alle elementer et hakk mot start f�r � slippe null hull i listen
					filmsamling[j] = filmsamling[j+1]; 
				}
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		ArrayList<Film> filmer = new ArrayList<>();
		for (int i = 0; i < antall; i++) {
			if (filmsamling[i].getTittel().contains(delstreng)) {
				filmer.add(filmsamling[i]);
			}
		}
		return (Film[]) filmer.toArray();
	}
	@Override
	public int antall(Sjanger sjanger) {
		int teller = 0;
		for (int i = 0; i < antall; i++) {
			if (filmsamling[i].getSjanger().equals(sjanger)) {
				teller++;
			}
		}
		return teller;
	}

	@Override
	public int antall() {
		return antall;
	}
	
}
