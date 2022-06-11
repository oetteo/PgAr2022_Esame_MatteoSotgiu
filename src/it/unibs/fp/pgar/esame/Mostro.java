package it.unibs.fp.pgar.esame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mostro extends Creatura{
	char[] nomePartenza = "dijkstra".toCharArray();
	char[] nomeC;
	String nome;
	boolean chiave = false;
	
	/*
	 * Il metodo creaMostro genera un mostro con attributi randomici esclusi atk e def che sono fissi
	 * In casi opportuni il mostro viene generato in possesso di una chiave
	 */
	public void creaMostro(boolean chiave) {
		if(chiave) this.chiave = true;
		//crea nome
		List<Character> list = new LinkedList<>(); 
	    for (int i = 0; i < nomePartenza.length; i++) {
	        list.add(nomePartenza[i]);
	    }
	    Collections.shuffle(list);  
	    for (int i = 0; i < nomePartenza.length; i++) {
	        nomeC[i] = list.get(i);
	    }
	    this.nome = nomeC.toString();
	    
	    //setta la vita
	    Random rand = new Random();
		int random = rand.nextInt(10) + 15; 
	    this.setVita(random);
	    
	    //setta atk e def
	    this.setAtk(5); this.setDef(5);
	    
	    //setta l'arma
	    Arma armaMostro = new Arma();
	    Random rand2 = new Random();
		int random2 = rand2.nextInt(20) + 35; 
	    armaMostro.setPotenza(random2);
	    this.setArma(armaMostro);
	 //   this.setArmato(true);
	    
	}
}
