package it.unibs.fp.pgar.esame;

import java.util.ArrayList;

public class Mappa {
	private static ArrayList<Piano> piani = new ArrayList<>();
	
	public static ArrayList<Piano> getPiani() {
		return piani;
	}
	
	/*
	 * Stampa il piano desiderato e la legenda della mappa
	 */
	public void stampaPiano(int num){
		System.out.println("\nSiamo al piano " + num + ", eccone la mappa:");
		piani.get(num).stampaPiano();;
		System.out.println("\nLegenda:\nMuro: #\n"
				+ "Casella libera: .\n"
				+ "Giocatore: O\n"
				+ "Mostro: M\n"
				+ "Cesta: C\n"
				+ "Principessa Kibo: K\n"
				+ "Scale in salita: T\n"
				+ "Scale in discesa: t\n"
				+ "Nemico con la chiave per le scale: B\n");
	}
	

	/*
	 * Il metodo creaMappa ha la funzione di aggiungere all'array di piani della mappa ciascun piano 
	 * in seguito alla lettura di diversi documenti XML
	 */
	public void creaMappa() {
		piani.add(LetturaXML.leggiXML("livello1.xml"));
		piani.add(LetturaXML.leggiXML("livello2.xml"));
		piani.add(LetturaXML.leggiXML("livello3.xml"));
		piani.add(LetturaXML.leggiXML("livello4boss.xml"));
		piani.add(LetturaXML.leggiXML("livello4princess.xml"));
	}
	
	
}
