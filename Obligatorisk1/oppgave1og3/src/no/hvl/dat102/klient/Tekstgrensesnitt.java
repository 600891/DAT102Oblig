package no.hvl.dat102.klient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

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
		return new Film(Integer.parseInt(split[0]) , split[1], split[2], Integer.parseInt(split[3]), Sjanger.valueOf(split[4].toUpperCase()), split[5]);
	}
	public void visFilm(Film film) { 
		System.out.println(film);
	}
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] filmer = filma.soekTittel(delstreng);
		for (Film filmen: filmer) {
			visFilm(filmen);
		}
	}
	public void skrivUtProdusent(FilmarkivADT filma, String delstreng) {
		//Elendig og veldig lite effektiv m�te:
		boolean funnet = false;
		if (filma.antall() > 0) {
			for (int i = 0; i < filma.antall(); i++) {
				Film filmen = filma.finnFilm(i);
				if (filmen != null) { //Kan ligge null-pekere i tabellen. Kan bruke try,catch.
					if (filmen.getProdusent().contains(delstreng)) {
						funnet = true;
						visFilm(filmen);
					}
				}
			}
			if (!funnet) {
				System.out.println("Fant ingen film med denne produsenten");
			}
		}
	}
	public void skrivUtStatestikk(FilmarkivADT filma) {
		HashMap<String, Integer> dict = new HashMap();
		Sjanger[] sjangre = Sjanger.values();
		/*for (Sjanger sjangeren: sjangre) {
			System.out.println(sjangeren);
			dict.put(sjangeren, 0);
		 */
		for(int i = 0; i < filma.antall(); i++) {
			Film filmen = filma.finnFilm(i);
			if (filmen != null) {
				//F�rste bokstav i stringen blir stor bokstav resten sm� (.capitalize())
				String sjanger = capitalize(filmen.getSjanger().toString());
				if (!dict.containsKey(sjanger)) {
					dict.put(sjanger, 1);
				}
				else {
					dict.put(sjanger, dict.get(sjanger)+1);
				}
			}
			
		}
		for (Entry<String, Integer> item: dict.entrySet()) {
			System.out.println(item.getKey() + ": " + item.getValue());

		}
		System.out.println("Det er totalt " + filma.antall() + " filmer i akrivet");
	}
	private String capitalize(String string) {
		return string.substring(0, 1).toUpperCase() + string.toLowerCase().substring(1);
	}
	
}
