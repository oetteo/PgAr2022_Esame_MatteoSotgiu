package it.unibs.fp.pgar.esame;
import java.util.*;
import it.unibs.fp.mylib.*;
public class Personaggio extends Creatura {
	private static ArrayList<Oggetto> inventario = new ArrayList<Oggetto>();
	private static Oggetto oggettoCorrente;
	public static int pianoCorrente = 0; //0 perchè è il piano iniziale
	private static int[] posizione = {0 , 21}; //posizione iniziale in base al doc xml livello1
	private static boolean isArmato = false;
	private static boolean chiaveScale = false;
	public static ArrayList<Oggetto> getInventario() {
		return inventario;
	}


	public static void setInventario(ArrayList<Oggetto> inventario) {
		Personaggio.inventario = inventario;
	}


	public static int[] getPosizione() {
		return posizione;
	}


	public static void setPosizione(int[] posizione) {
		Personaggio.posizione = posizione;
	}

	
	public static String azione() {
		String comando;
		do {
			comando = InputDati.leggiStringaNonVuota("\n\nCosa vuoi fare?\n W - spostamento verso l'alto\n A - spostamento verso sinistra\n"
					+ " S - spostamento verso il basso\n D - spostamento verso destra\n M - apri menù\n\nI comandi vanno scritti in maiuscolo ;)\n");	
		}while(!comando.matches("[WASDM]+"));
		
		return comando;
	}
	
	/*
	 * il metodo scontro viene invocato quando due creature si scontrano,
	 *	calcola chi rimane in vita e aggiorna la sua vita rimanente
	 */
	public void scontro(boolean chiave) {
		String input = "";
		int potenza1;
		double modificatore = 1.0;
	   
		Mostro m = new Mostro();
		m.creaMostro(chiave);
		
		System.out.println("Hai incontrato il mostro" + m.getNome() + "!\nChi vincerà?");
		if(chiave)
			System.out.println("Hai incontrato il mostro" + m.getNome() + " e ha una chiave!\nChi vincerà?");
		do {
			input = InputDati.leggiStringa("Premi Invio per proseguire");
		}while(!input.equals("\n"));
		
		if(!isArmato) potenza1 = 1;
		else 
			potenza1 = this.arma.getPotenza();
		
		do {
		int count = 0;
		int danno1; int danno2;
		
		if(count%2 == 0) {
		    Random rand = new Random();
			int random = rand.nextInt(1000); 
			if(random < 75) modificatore = 1.5; //sarà 1.5 nel 7.5% dei casi
				danno1 = (int) (((2 * potenza1 * this.atk)/(25 * this.def) + 2) * modificatore);
		}
		else {
		    Random rand = new Random();
			int random = rand.nextInt(1000); 
			if(random < 75) modificatore = 1.5; //sarà 1.5 nel 7.5% dei casi
				danno2 = (int) (((2 * m.getArma().getPotenza() * m.getAtk())/(25 * m.getDef()) + 2) * modificatore);
		}
		count++;
		
		}while(this.vita>0 && m.getVita()>0);
		
		if(this.vita<0) System.out.println("Sei morto! X_X");
		if(m.getVita()<0) {
			if(chiave) chiaveScale = true;
			System.out.println("Hai ucciso il mostro!\nOra la tua vita è: " + this.vita);
		}
		
	}
	
	public void scontroFinale() {
		Mostro m = new Mostro();
		double modificatore = 1.0;
		int potenza1;
		m.creaMostro(false);
		
		m.setVita(40);
		m.setArma(arma);
		m.getArma().setPotenza(70);
		m.setNome("Dijkstra");
		System.out.println("Hai incontrato il boss finale: Dijkstra! Chi vincerà?");
		
		do {
			int count = 0;
			int danno1; int danno2;
			
			if(count%2 == 0) {
			    Random rand = new Random();
				int random = rand.nextInt(1000); 
				if(random < 75) modificatore = 1.5; //sarà 1.5 nel 7.5% dei casi
					danno1 = (int) (((2 * potenza1 * this.atk)/(25 * this.def) + 2) * modificatore);
			}
			else {
			    Random rand = new Random();
				int random = rand.nextInt(1000); 
				if(random < 75) modificatore = 1.5; //sarà 1.5 nel 7.5% dei casi
					danno2 = (int) (((2 * m.getArma().getPotenza() * m.getAtk())/(25 * m.getDef()) + 2) * modificatore);
			}
			count++;
			
			}while(this.vita>0 && m.getVita()>0);
			
			if(this.vita<0) System.out.println("Sei morto! X_X");
			if(m.getVita()<0) {
				System.out.println("Hai ucciso il mostro!\nOra la tua vita è: " + this.vita);
			}
	}
	
	
}
