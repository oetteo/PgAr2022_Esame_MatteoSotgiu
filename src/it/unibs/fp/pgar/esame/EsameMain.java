package it.unibs.fp.pgar.esame;

import java.util.Random;

import it.unibs.fp.mylib.InputDati;

public class EsameMain {
	static boolean vinto = false; 
	
	public static void main(String[] args) {
		Personaggio p = new Personaggio();
		p.setNome(InputDati.leggiStringaNonVuota("Qual è il tuo nome guerriero?"));
		Mappa mappa = new Mappa();
		mappa.creaMappa();
		mappa.stampaPiano(Personaggio.pianoCorrente);
		
		do {
			char azione = Turno.procedi();
			if(azione == 'M')	
				p.scontro(false); //false e true indicano se lo scontro avviene con un mostro con o senza chiave
			if(azione == 'B')	
				p.scontro(true); //false e true indicano se lo scontro avviene con un mostro con o senza chiave
			if(azione=='D')
				p.scontroFinale();
			if(azione == 'K')
				vinto = true;
			
		}while(!vinto);
		
		System.out.println("\n\nComplimenti! Hai vinto!");
	}

}
