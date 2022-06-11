package it.unibs.fp.pgar.esame;

import java.util.Random;

public class Chest {
	private Oggetto oggetto;
	
	public void generaChest() {
		 Random rand = new Random();
			int random = rand.nextInt(100); 
			if (random<=40) {
				Arma arma = new Arma();
				Random rand2 = new Random();
				int random2 = rand.nextInt(20)+35; 
				arma.setPotenza(random2);
				System.out.println("Hai trovato un'arma!");
				this.oggetto = arma;
			}
			
			if(random>40 && random < 75) {
				Scudo scudo = new Scudo();
				System.out.println("Hai trovato uno scudo!");
				this.oggetto = scudo;
			}
			if(random > 75) {
				Pozione pozione = new Pozione();
				System.out.println("Hai trovato una pozione!");
				this.oggetto = pozione;
			}
			
				
	}
	
	public void daiOggetto() {
		Personaggio.getInventario().add(oggetto);
	}
}
