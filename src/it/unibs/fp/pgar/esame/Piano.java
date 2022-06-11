package it.unibs.fp.pgar.esame;

import java.util.ArrayList;

public class Piano {
	private char[][] mappaPiano; //la "griglia" del piano
	private int altezza;
	private int larghezza;
	
	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public char[][] getMappaPiano() {
		return mappaPiano;
	}

	public void setMappaPiano(char[][] mappaPiano) {
		this.mappaPiano = mappaPiano;
	}
	
	public void stampaPiano() {
		System.out.println("-------------------------------");	
		for(int i = 0; i < altezza; i++) {
			for(int j = 0; j < larghezza; j++) {
				System.out.print(mappaPiano[i][j]);
			}
			System.out.println("");
		}
		System.out.println("-------------------------------");
	}
}
