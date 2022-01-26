package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;


public class Tekstgrensesnitt {
	
	public Film lesFilm() { //Denne metoden h�ndterer ikke exceptions med � opprette objektet.
		
		Scanner input = new Scanner(System.in);
		System.out.print("Skriv inn informasjonen med komma som seperator: ");
		
		String inputen = input.nextLine();
		String[] split = inputen.split(", ");
		return new Film(Integer.parseInt(split[0]) , split[1], split[2], Integer.parseInt(split[3]), Sjanger.valueOf(split[4]), split[5]);

		
	}
	public void visFilm(int nr) { //FilmarkivADT skal ikke v�re paramter, retur skal kanskje v�re void
		
	}
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		
	}
	public void skrivUtProsusent(FilmarkivADT filma, String delstreng) {
		
		
	}
	public void skrivUtStatestikk(FilmarkivADT filma) {
		
	}
}
